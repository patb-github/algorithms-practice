public class Creative_20 {
    /*
     * An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. 
     * Write a program that, given a bitonic array of n distinct int values, determines whether a given integer is in the array. 
     * Your program should use ~ 3 log n compares in the worst case.
     */
    private Creative_20() { };

    // Returns index of the inflection point (maximum value) in the bitonic array.
    private static int indexOfMax(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = (lo + hi + 1) / 2;    // +1 because we will access mid - 1; for when array has length 2

        while (lo < hi)  
        {
            // lo will always be on the increasing part, and hi will always be on the decreasing part
            if (arr[mid - 1] < arr[mid]) lo = mid;          // arr[mid] could be the max, so we cannot set lo = mid + 1 
            else hi = mid - 1;                              // arr[mid] cannot be the max, so we can set hi = mid - 1                            
            mid = ((lo + hi + 1) / 2);
        }
        return mid;
    }

    private static int binarySearch(int[] arr, int key, int low, int high, boolean increasing) {
        int lo = low;
        int hi = high;
        int mid = (lo + hi) / 2;

        while (lo <= hi) 
        {
            if (arr[mid] == key) return mid;
            else if (increasing ? arr[mid] < key : arr[mid] > key) lo = mid + 1; 
            else hi = mid - 1;                                                
            mid = (lo + hi) / 2;
        }
        return -1;
    }

     /**
     * Returns the index of the specified key in the specified bitonic array. The array cannot have duplicates.
     *
     * @param  arr the bitonic array
     * @param  key the item we want to find the index of 
     * @return the index of {@code key} in {@code arr} if it exists; -1 otherwise
     */
    public static int indexOf(int[] arr, int key) {
        int inflectionIndex = indexOfMax(arr);

        // Since we assume that all array elements are distinct, we can search both sides and guarantee at most one index is not -1;
        // But if the key is the inflection point, searching the right and left sides will return the same index
        int leftIndex = binarySearch(arr, key, 0, inflectionIndex, true);
        if (leftIndex != -1) return leftIndex; // No need to search right side if key is already found
        else return binarySearch(arr, key, inflectionIndex, arr.length - 1, false);
    }

    public static void main(String[] args) {
        int[] bitonicArray = {1,3,5,7,6,4,2};
        System.out.println(indexOf(bitonicArray, Integer.parseInt(args[0])));
    }
}
