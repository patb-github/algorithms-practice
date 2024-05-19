public class BinarySearch {

    private BinarySearch() {}
  
    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param  arr the sorted array
     * @param  key the item we want to find the index of 
     * @return the index of {@code key} in {@code arr} if it exists; -1 otherwise
     */
    public static int indexOf(Comparable[] arr, Comparable key) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = (lo + hi) / 2;

        while (lo <= hi) 
        {
            if (arr[mid].compareTo(key) == 0) return mid;
            else if (arr[mid].compareTo(key) < 0) lo = mid + 1; // + 1 because index cannot be mid
            else hi = mid - 1;                                  // - 1 because index cannot be mid                                
            mid = (lo + hi) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] a = {1,3,5,7,9,11,13,15,17};
        System.out.println(indexOf(a, Integer.parseInt(args[0])));
    }
}
