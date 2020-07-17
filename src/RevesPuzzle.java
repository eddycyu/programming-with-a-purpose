public class RevesPuzzle {

    private static void reves(int n, char a, char b, char c, char d) {
        if (n == 1) {
            StdOut.println("Move disc " + n + " from " + a + " to " + d);
            return;
        }

        final int k = (int) Math.round(n + 1.0 - (Math.sqrt((2 * n) + 1.0)));
        // transfer k smallest discs from (A) to single pole (B)
        // other than start or destination pole
        reves(k, a, c, d, b);
        // transfer remaining n-k discs from (A) to destination (D)
        // and skip (B)
        hanoi(n, k, a, c, d);
        // transfer k smallest discs from (B) to destination (D)
        reves(k, b, a, c, d);

    }

    private static void hanoi(int n, int k, char start, char mid, char end) {
        if ((n == 0) || (n <= k)) {
            return;
        }
        hanoi(n - 1, k, start, end, mid);
        StdOut.println("Move disc " + n + " from " + start + " to " + end);
        hanoi(n - 1, k, mid, start, end);
    }

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        reves(n, 'A', 'B', 'C', 'D');
    }
}