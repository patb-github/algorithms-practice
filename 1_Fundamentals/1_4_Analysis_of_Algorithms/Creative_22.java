/*
 * 22. Binary search with only addition and subtraction. 
 * 
 * Write a program that, given an array of n distinct integers in ascending order, determines whether a given integer is in the array. 
 * You may use only additions and subtractions and a constant amount of extra memory. 
 * The running time of your program should be proportional to log(n) in the worst case.
 */

public class Creative_22 {
    // Assumes array has distinct integers in ascending order
    public static boolean containsKey(int[] arr, int key) {
        return containsKey(arr, key, 0, arr.length - 1);
    }

    private static boolean containsKey(int[] arr, int key, int lo, int hi) {
        if (lo > hi) return false;
        if (arr[lo] == key) return true;

        int d = 1;
        while (lo + d <= hi && arr[lo + d] > key) {
            d += d;
        }

        return containsKey(arr, key, lo, Math.min(lo + d, hi));
    }

    public static void main(String[] args) {
        int[] a = {0};
        System.out.println(containsKey(a, Integer.parseInt(args[0])));
    }
}
