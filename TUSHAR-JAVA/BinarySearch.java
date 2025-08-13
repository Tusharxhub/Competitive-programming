//! wap a binary search algorithm in java.



public class BinarySearch {
    // Performs iterative binary search on sorted array a for target t
    static int bs(int[] a, int t) {
        int l = 0;                 // left boundary (inclusive)
        int r = a.length - 1;      // right boundary (inclusive)
        while (l <= r) {           // continue while search space is not empty
            int m = (l + r) >>> 1; // mid index (unsigned shift avoids overflow)
            if (a[m] == t)         // if middle element is target
                return m;          // return its index
            if (a[m] < t)          // if middle element less than target
                l = m + 1;         // discard left half including m
            else
                r = m - 1;         // discard right half including m
        }
        return -1;                 // target not found
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10}; // sorted input array
        System.out.println(bs(a, 5));     // search for 5, expect index 4
    }
}




// ? output
// ? 







//?     Time complexity: Best case: 
// ?    Best case: O(1) (found at first check)
//?    Average case: O(log n)
//?    Worst case: O(log n)


//?    Space complexity: O(1)
//?    Iterative: O(1) (no extra space)
//?    Recursive: O(log n) (due to call stack)
