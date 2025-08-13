//!  wap to implement sum of two sum in an array




public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};  // Input array
        int target = 9;              // Target sum

        for (int i = 0; i < arr.length; i++) {           // Step 1: Loop over each element
            for (int j = i + 1; j < arr.length; j++) {   // Step 2: Check every other element after it
                if (arr[i] + arr[j] == target) {         // Step 3: If their sum equals target
                    System.out.println("Indices: " + i + ", " + j);
                    System.out.println("Values: " + arr[i] + " + " + arr[j] + " = " + target);
                    return; // Exit after finding one pair
                }
            }
        }
        System.out.println("No pair found with the given sum.");
    }
}



// ? output
// ? Indices: 0, 1
// ? Values: 2 + 7 = 9





