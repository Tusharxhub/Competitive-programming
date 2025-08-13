//! Linear Search Algorithm in Java



public class LinearSearch {
    // Performs linear search on array a for target t
    static int ls(int[] a, int t) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == t) // if current element is target
                return i;  // return its index
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10}; // input array
        System.out.println(ls(a, 5));     // search for 5, expect index 4
    }
}

// ? output
// ? 4

// ?    Time complexity: Best case: O(1) (found at first check)
// ?    Average case: O(n)
// ?    Worst case: O(n)

// ?    Space complexity: O(1)
// ?    Iterative: O(1) (no extra space)
// ?    Recursive: O(n) (due to call stack)
