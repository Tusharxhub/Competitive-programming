//! An online store records the prices of items in array. write a program to sort the prices from lowest to highest.Display the sorted output.



import java.util.Arrays;
import java.util.Scanner;

public class PriceSorter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        double[] prices = new double[n];

        System.out.println("Enter the prices of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Price " + (i + 1) + ": ");
            prices[i] = scanner.nextDouble();
        }

        Arrays.sort(prices);

        System.out.println("\nSorted prices (lowest to highest):");
        for (double price : prices) {
            System.out.println(price);
        }

        scanner.close();
    }
}
