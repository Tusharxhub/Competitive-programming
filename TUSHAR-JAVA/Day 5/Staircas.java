//! 4.	You are climbing a staircase. It takes n steps to reach the top.
//! Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//!
//! Example 1:
//! Input: n = 2
//! Output: 2
//! Explanation: There are two ways to climb to the top.
//! 1. 1 step + 1 step
//! 2. 2 steps
//! Example 2:
//! Input: n = 3
//! Output: 3
//! Explanation: There are three ways to climb to the top.
//! 1. 1 step + 1 step + 1 step
//! 2. 1 step + 2 steps
//! 3. 2 steps + 1 step
//!
//! Constraints:
//! 1 <= n <= 45




public class Staircas {
	public static int climbStairs(int n) {
		if (n <= 2) return n;
		int a = 1, b = 2;
		for (int i = 3; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("Enter number of steps (n): ");
		int n = sc.nextInt();
		System.out.println("Distinct ways to climb to the top: " + climbStairs(n));
		sc.close();
	}
}



