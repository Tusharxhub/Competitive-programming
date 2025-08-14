//! wap in java to remove duplicates from an array.



public class RemoveDuplicates {
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1;
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