//! Given a string s, return the longest palindromic substring in s. 

//! Example 1: 

//! Input: s = "babad" 

//! Output: "bab" 

//! Explanation: "aba" is also a valid answer. 

//! Example 2: 

//! Input: s = "cbbd" 

//! Output: "bb"  

//! Constraints: 

//! 1 <= s.length <= 1000 

//! s consist of only digits and English letters. 

class Solution {
    // Quick manual run helper:
    // Usage examples:
    //   java Solution babad
    //   (or) echo babad | java Solution
    // Prints the longest palindromic substring to stdout.
    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
                if (sc.hasNextLine()) {
                    input = sc.nextLine().trim();
                } else {
                    System.out.println("");
                    return;
                }
            }
        }
        Solution solver = new Solution();
        System.out.println(solver.longestPalindrome(input));
    }

    /**
     * Finds the longest palindromic substring in s.
     *
     * @param s The input string.
     * @return The longest palindromic substring.
     */
    public String longestPalindrome(String s) {
        // Handle edge cases: null or empty string
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindrome (center is s.charAt(i))
            // e.g., "racecar"
            int len1 = expandAroundCenter(s, i, i);

            // Case 2: Even-length palindrome (center is between i and i+1)
            // e.g., "noon"
            int len2 = expandAroundCenter(s, i, i + 1);

            // Find the maximum length from the two cases
            int len = Math.max(len1, len2);

            // If we found a new, longer palindrome, update our pointers
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the final longest substring
        return s.substring(start, end + 1);
    }

    /**
     * A helper method to expand from a center and find the length of the palindrome.
     *
     * @param s The input string.
     * @param left The left pointer of the center.
     * @param right The right pointer of the center.
     * @return The length of the palindrome found.
     */
    private int expandAroundCenter(String s, int left, int right) {
        // Expand outwards as long as we are within bounds and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // The length is the distance between the two pointers after they stop matching
        return right - left - 1;
    }
}