// !Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where: 

//! '.' Matches any single character.​​​​ 

//! '*' Matches zero or more of the preceding element. 

//! The matching should cover the entire input string (not partial). 

//!   

//! Example 1: 

//! Input: s = "aa", p = "a" 

//! Output: false 

//! Explanation: "a" does not match the entire string "aa". 

//! Example 2: 

//! Input: s = "aa", p = "a*" 

//! Output: true 

//! Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa". 

//! Example 3: 

//! Input: s = "ab", p = ".*"

//! Output: true

//! Explanation: ".*" means "zero or more (*) of any character (.)".

//! Constraints: 

//! 1 <= s.length <= 20 

//! 1 <= p.length <= 20 

//! s contains only lowercase English letters. 

//! p contains only lowercase English letters, '.', and '*'. 

//! It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 

public class RegexMatch {

    public static void main(String[] args) {
        String s;
        String p;
        if (args.length >= 2) {
            s = args[0];
            p = args[1];
        } else if (args.length == 1) {
            // If only one arg, read pattern from stdin
            s = args[0];
            try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
                p = sc.hasNextLine() ? sc.nextLine().trim() : "";
            }
        } else {
            try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
                // Expect two lines: first s, second p
                s = sc.hasNextLine() ? sc.nextLine().trim() : "";
                p = sc.hasNextLine() ? sc.nextLine().trim() : "";
            }
        }
        RegexMatch solver = new RegexMatch();
        System.out.println(solver.isMatch(s, p));
    }

    // Dynamic programming solution: O(m*n) time, O(m*n) space
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Initialize first row for patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '.' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Zero of preceding element
                    dp[i][j] = dp[i][j - 2];
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == s.charAt(i - 1)) {
                        // One more occurrence of preceding element
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
