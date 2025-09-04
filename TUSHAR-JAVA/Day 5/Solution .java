//! Longest Palindromic Substring (LeetCode 5 style)
//! Given a string s (1 <= s.length <= 1000, consisting of digits and English letters),
//! return the longest palindromic substring in s.
//! Examples:
//!  Input: "babad" -> "bab" ("aba" also valid)
//!  Input: "cbbd"  -> "bb"
//! Approach used: Expand Around Center (O(n^2) time, O(1) extra space), which is
//! sufficient for n <= 1000. For every index we expand for both odd and even centers.

import java.util.*;

class Solution { // non-public so file name can stay 1.java
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 2) return s == null ? "" : s;
		int start = 0, end = 0; // inclusive bounds of best palindrome
		for (int i = 0; i < s.length(); i++) {
			int len1 = expand(s, i, i);     // odd length
			int len2 = expand(s, i, i + 1); // even length
			int len = Math.max(len1, len2);
			if (len > end - start + 1) {
				// Compute new bounds
				int newStart = i - (len - 1) / 2;
				int newEnd = i + len / 2;
				start = newStart;
				end = newEnd;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expand(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
		return r - l - 1; // length after overshoot
	}

	// Optional faster solution (Manacher) could be added if needed; omitted for brevity.

	public static void main(String[] args) {
		String input;
		if (args.length > 0) {
			input = args[0];
		} else {
			try (Scanner sc = new Scanner(System.in)) {
				if (!sc.hasNextLine()) return;
				input = sc.nextLine().trim();
			}
		}
		System.out.println(longestPalindrome(input));
	}
}

// Simple inline tests (run only if executed directly without args and with no stdin data)
// You can comment this block out in production.
@SuppressWarnings("unused")
class _LongestPalindromeTestHarness {
	public static void main(String[] args) {
		Map<String, String> cases = new LinkedHashMap<>();
		cases.put("babad", "bab"); // or aba
		cases.put("cbbd", "bb");
		cases.put("a", "a");
		cases.put("ac", "a"); // or c
		cases.put("forgeeksskeegfor", "geeksskeeg");
		for (var e : cases.entrySet()) {
			String got = Solution.longestPalindrome(e.getKey());
			boolean ok = got.equals(e.getValue()) || (e.getKey().equals("babad") && got.equals("aba")) || (e.getKey().equals("ac") && got.equals("c"));
			System.out.println(e.getKey() + " -> " + got + (ok ? " (OK)" : " (EXPECTED: " + e.getValue() + ")"));
		}
	}
}