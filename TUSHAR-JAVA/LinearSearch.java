//! Linear Search Algorithm in Java



public class LinearSearch {
    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)      // Step 1: Start from first element
            if (arr[i] == key) return i;          // Step 2: If match found, return index
        return -1;                                // Step 3: If not found, return -1
    }

    public static void main(String[] args) {
        int[] nums = {10, 23, 45, 70, 11, 15};     // Step 0: Array to search in
        int res = search(nums, 70);                // Step 4: Call search method
        System.out.println(res == -1               // Step 5: Check result and print
            ? "Not found"
            : "Found at index: " + res);
    }
}



// ? output
// ? Found at index: 3

// ?    Time complexity: Best case: O(1) (found at first check)
// ?    Average case: O(n)
// ?    Worst case: O(n)

// ?    Space complexity: O(1)
// ?    Iterative: O(1) (no extra space)
// ?    Recursive: O(n) (due to call stack)
