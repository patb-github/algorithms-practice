public class Sort3 {
    private static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a > b) { int t = a; a = b; b = t; };
        if (a > c) { int t = a; a = c; c = t; };
        if (b > c) { int t = b; b = c; c = t; };

        System.out.println(a + " " + b + " " + c);
        
        // int[] num = new int[3];
        // int[] pos = new int[3];  // position of a is pos[0], position of b is pos[1], etc.
        // for (int i = 0; i < 3; i++)
        // {
        //     pos[i] = i;
        //     num[i] = Integer.parseInt(args[i]);
        // } 

        // if (num[0] > num[1]) swap(pos, 0, 1); // if (a > b) swap positions of a and b;
        // if (num[0] > num[2]) swap(pos, 0, 2); // if (a > c) swap positions of a and c;
        // if (num[1] > num[2]) swap(pos, 1, 2); // if (b > c) swap positions of b and c;

        // for (int i : pos) System.out.print(num[i] + " ");
    }
}