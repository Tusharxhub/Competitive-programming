//! Linear Search Algorithm in Java



public class LinearSearch {
    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10, 23, 45, 70, 11, 15};
        int res = search(nums, 70);
        System.out.println(res == -1 ? "Not found" : "Found at index: " + res);
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
