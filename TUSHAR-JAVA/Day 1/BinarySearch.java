//! wap a binary search algorithm in java.



public class BinarySearch {
    static int search(int[] arr, int key) {
        int l = 0, r = arr.length - 1;           // Step 1: Set left and right boundaries
        while (l <= r) {                         // Step 2: Repeat until search space empty
            int m = (l + r) >>> 1;               // Step 3: Find mid index
            if (arr[m] == key) return m;         // Step 4: If match, return index
            if (arr[m] < key) l = m + 1;         // Step 5: Search right half
            else r = m - 1;                      // Step 6: Search left half
        }
        return -1;                               // Step 7: Not found
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};     // Step 0: Sorted array
        int res = search(nums, 5);               // Step 8: Call search method
        System.out.println(res == -1             // Step 9: Print result
            ? "Not found"
            : "Found at index: " + res);
    }
}




// ? output
// ? Found at index: 4







//?     Time complexity: Best case: 
// ?    Best case: O(1) (found at first check)
//?    Average case: O(log n)
//?    Worst case: O(log n)


//?    Space complexity: O(1)
//?    Iterative: O(1) (no extra space)
//?    Recursive: O(log n) (due to call stack)
