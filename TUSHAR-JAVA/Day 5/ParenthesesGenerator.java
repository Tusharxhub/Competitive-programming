//! Given n pairs of parentheses, generate all combinations of well-formed parentheses.
//! Examples:
//! n = 3 -> ["((()))","(()())","(())()","()(())","()()()"]
//! n = 1 -> ["()"]
//! Constraint: 1 <= n <= 8

import java.util.*;

public class ParenthesesGenerator {
	/**
	 * Returns all well-formed parentheses strings of length 2*n.
	 * Time: O(Catalan(n)); Space: O(n) recursion + output size.
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n < 0) return res; // defensive
		char[] current = new char[2 * n];
		backtrack(res, current, 0, 0, n, 0);
		return res;
	}

	private static void backtrack(List<String> res, char[] current, int open, int close, int n, int idx) {
		// If we've placed all 2*n chars
		if (idx == current.length) {
			res.add(new String(current));
			return;
		}
		// We can add '(' if we still have room to open more
		if (open < n) {
			current[idx] = '(';
			backtrack(res, current, open + 1, close, n, idx + 1);
		}
		// We can add ')' if there are unmatched '(' to close
		if (close < open) {
			current[idx] = ')';
			backtrack(res, current, open, close + 1, n, idx + 1);
		}
	}

	// Entry point: reads an integer n from stdin and prints each combination.
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.hasNextInt() ? sc.nextInt() : 3;
			if (n < 0 || n > 8) {
				System.err.println("n must be in range 0..8");
				return;
			}
			List<String> ans = generateParenthesis(n);
			System.out.println(ans);
			// for (String s : ans) System.out.println(s);
		}
	}
}



