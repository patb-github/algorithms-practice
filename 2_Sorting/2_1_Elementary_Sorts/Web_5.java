public class Web_5 {
    /*
     * 5. Optimal non-oblivious sorting. Write a program that sorts 5 inputs using only 7 comparisons. 
     * Hint: First compare the first two numbers, the second two numbers, and the larger of the two groups, and label them so that a < b < d and c < d. 
     * Second, insert the remaining item e into its proper place in the chain a < b < d by first comparing against b, then either a or d depending on the outcome. 
     * Third, insert c into the proper place in the chain involving a, b, d, and e in the same manner that you inserted e (with the knowledge that c < d). 
     * This uses 3 (first step) + 2 (second step) + 2 (third step) = 7 comparisons. This method was first discovered by H. B. Demuth in 1956.
     * 
     * Note: The inequalities used here refer to the ordering, but the numbers a,b,c,d,e need not be distinct.
     */
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);

        if (a > b) { int t = a; a = b; b = t; }; // now a < b
        if (c > d) { int t = c; c = d; d = t; }; // now c < d
        if (b > d) { int t = a; a = c; c = t; t = b; b = d; d = t;}; // swap a,c and b,d so that a < b < d and c < d

        if (e > b) {
            if (e < d) { int t = e; e = c; c = t; } // swap e,c; now a < b < c < d and e < d
            else { int t = c; c = d; d = t; t = e; e = d; d = t; } // e >= d; swap c,d then e,d; now a < b < c < d and e < d
        }
        else { // e <= b
            if (e < a) {
                // swap b,c then swap a,b then swap a,e; now a < b < c < d and e < d
                int t = c; c = b; b = t;
                t = a; a = b; b = t;
                t = a; a = e; e = t;
            } 
            else { // e is between a and b;
                // swap b,c then swap b,e; now a < b < c < d and e < d
                int t = c; c = b; b = t;
                t = e; e = b; b = t;
            }
        }

        if (e > b) { // e will be to the right of b
            if (e > c) { int t = e; e = d; d = t; }
            else { int t = e; e = d; d = t; t = d; d = c; c = t; };
        }
        else {
            if (e < a) { // e is first; shift everything else right
                int t = e; e = d; d = t;
                t = d; d = c; c = t;
                t = c; c = b; b = t;
                t = b; b = a; a = t;
            }
            else { // e is between a and b
                int t = e; e = d; d = t;
                t = d; d = c; c = t;
                t = c; c = b; b = t;
            }
        }

        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " ");
    }
}
