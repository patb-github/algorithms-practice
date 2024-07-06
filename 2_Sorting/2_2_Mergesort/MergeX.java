public class MergeX {

    private MergeX() {};

    private static void merge(Comparable[] dest, Comparable[] aux, int lo, int mid, int hi) {
        // dest[lo] ... dest[mid] is sorted
        // dest[mid+1] ... dest[hi] is sorted
        for (int i = lo; i <= hi; i++) aux[i] = dest[i];

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
        if (lo >= hi) return;

        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    } 

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {
        sort(args);
        for (String s : args) System.out.print(s + " ");
    }
}
