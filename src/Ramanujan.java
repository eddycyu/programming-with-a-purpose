public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long firstA = 0;
        long firstB = 0;
        int count = 0;

        // if minA = 1, then maxA cannot be larger than cbrt(n)
        final long minA = 1;
        final long maxA = (long) Math.cbrt(n);
        for (long a = minA; a < maxA; a++) {
            final long curA = a * a * a;
            // if curA, then the only possible value for b is cbrt(n - curA)
            final long b = (long) Math.cbrt(n - curA);
            final long curB = b * b * b;
            final long ab = curA + curB;
            if (ab == n) {
                if (count == 0) {
                    count++;
                    firstA = a;
                    firstB = b;
                } else if ((firstA != b) && (firstB != a)) { // make sure not reversed
                    count++;
                }
                if (count > 1) {
                    return true; // found two positive cubes in two different ways
                }
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        final long n = Long.parseLong(args[0]);
        StdOut.print(isRamanujan(n));
    }
}