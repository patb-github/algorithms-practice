/*
 * Creative Problem 11. Write a program MergeX.java that implements 
 * the three improvements to mergesort that are described in the text: 
 * 1) add a cutoff from small subarrays, 
 * 2) test whether the array is already in order, and
 * 3) avoid the copy by switching arguments in the recursive code.
 */

public class MergeX {

    private static int CUTOFF = 7;
    private MergeX() {};

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int k = i;
            while (k > lo && a[k].compareTo(a[k - 1]) < 0) {
                // swap a[k] and a[k - 1]
                Comparable t = a[k];
                a[k] = a[k - 1];
                a[k - 1] = t;
                k--;
            }
        }
    }

    private static void merge(Comparable[] dest, Comparable[] aux, int lo, int mid, int hi) {
        // dest[lo] ... dest[mid] is sorted
        // dest[mid+1] ... dest[hi] is sorted

        int left = lo;
        int right = mid + 1;
        int i = lo;
        while (left <= mid && right <= hi) {
            int cmp = aux[left].compareTo(aux[right]);
            if (cmp <= 0) dest[i++] = aux[left++];
            else dest[i++] = aux[right++];
        }

        if (left > mid) {
            while (right <= hi) dest[i++] = aux[right++];
        } else {
            while (left <= mid) dest[i++] = aux[left++];            
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // Optimization 1: Use insertion sort at cutoff
        if (hi - lo + 1 <= CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        int mid = (lo + hi) / 2;
        sort(aux, a, lo, mid);      // swapped aux and a
        sort(aux, a, mid + 1, hi);  // swapped aux and a
        // Optimization 2: Check if subarrays are already in order
        if (a[mid].compareTo(a[mid + 1]) <= 0) return;
        merge(a, aux, lo, mid, hi);
    } 

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        // Optimization: Copy array for optimization 3
        for (int i = 0; i < a.length; i++) aux[i] = a[i];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {
        sort(args);
        for (String s : args) System.out.print(s + " ");
    }
}
