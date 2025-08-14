//! wap in java to remove duplicates from an array.



public class RemoveDuplicates {

    /*
     Algorithm (Two-Pointer Technique) - works on a sorted array:
     1. If array empty -> return 0.
     2. Maintain two indices:
        - j: index of last unique element found (slow pointer).
        - i: current scanning index (fast pointer).
     3. For each i from 1..n-1:
        - If arr[i] != arr[j], increment j and copy arr[i] to arr[j].
     4. After loop, unique elements occupy positions 0..j.
     5. Return length = j + 1.
     Time: O(n), Space: O(1) in-place.
    */
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int j = 0; // last index of the unique portion
        for (int i = 1; i < arr.length; i++) { // scan rest of array
            if (arr[i] != arr[j]) {             // found a new unique value
                j++;                            // extend unique segment
                arr[j] = arr[i];                // place new unique value
            }
        }
        return j + 1; // size of unique segment
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int newSize = removeDuplicates(arr);
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}




//? output
//? Array after removing duplicates:
//? 1 2 3 4 5


//? Time Complexity: O(n)
//? Space Complexity: O(1)