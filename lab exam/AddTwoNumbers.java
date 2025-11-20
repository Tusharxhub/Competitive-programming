//! Add two Numbers 

//!You are given two mon-empty linked lists representing two non-negative integers. The digits are sorted in reverce order, and each of their nodes contains a single  digit.And the two numbers and return the sum as a linked lisr.

//!You may assume the two numbers do not contain any loading zero,except the number 0 itself.

//! Example: Input i1=[2,4,3], i2 =[5,6,4] output:[7,0,8]






import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int v) {
        val = v;
    }
}

public class AddTwoNumbers {
    static ListNode add(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
    }

    static ListNode makeList(String[] arr) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (String s : arr) {
            cur.next = new ListNode(Integer.parseInt(s));
            cur = cur.next;
        }
        return dummy.next;
    }

    static void print(ListNode n) {
        while (n != null) {
            System.out.print(n.val + (n.next != null ? " -> " : ""));
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number digits (reverse order):");
        ListNode l1 = makeList(sc.nextLine().trim().split("\\s+"));
        System.out.println("Enter second number digits (reverse order):");
        ListNode l2 = makeList(sc.nextLine().trim().split("\\s+"));
        print(add(l1, l2));
    }
}



