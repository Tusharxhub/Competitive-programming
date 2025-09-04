//! Longest Palindromic Substring (LeetCode 5 style)
//! Given a string s (1 <= s.length <= 1000, consisting of digits and English letters),
//! return the longest palindromic substring in s.
//! Examples:
//!  Input: "babad" -> "bab" ("aba" also valid)
//!  Input: "cbbd"  -> "bb"
//! Approach used: Expand Around Center (O(n^2) time, O(1) extra space), which is
//! sufficient for n <= 1000. For every index we expand for both odd and even centers.

class Solution {
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