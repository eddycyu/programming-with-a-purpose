public class Inversions {

    // Return the number of inversions in the permutation a[].
    // Max time complexity = O(n2)
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    // Max time complexity = O(n)
    public static int[] generate(int n, long k) {
        // generate starting sequence of length n with no inversions
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        // nothing to do
        if (k == 0) {
            return a;
        }

        /**
         * Example:
         *
         * n = 6
         *
         * 0 1 2 3 4 5 -> 5 0 1 2 3 4 == 5 inversions  (1 swap)
         * 5 0 1 2 3 4 -> 5 4 0 1 2 3 == 9 inversions  (2 swaps)
         * 5 4 0 1 2 3 -> 5 4 3 0 1 2 == 12 inversions (3 swaps)
         * 5 4 3 0 1 2 -> 5 4 3 2 0 1 == 14 inversions (4 swaps)
         * 5 4 3 2 0 1 -> 5 4 3 2 1 0 == 15 inversions (5 swaps)
         */

        // compute the number of swaps (as shown above example)
        int minSwap = 0;
        int inversionCount = 0;
        for (int i = 1; i < n; i++) {
            final int newInversions = (n - i);
            if ((inversionCount + newInversions) <= k) {
                minSwap++;
                inversionCount += newInversions;
            } else {
                break;
            }
        }
        // perform min swaps (bulk inversions)
        for (int i = 0; i < minSwap; i++) {
            a[i] = (n - 1) - i;
        }
        // fill in remaining numbers
        for (int i = 0; i < (n - minSwap); i++) {
            a[minSwap + i] = i;
        }
        // do remining individual inversions
        for (int i = 0; (i < (n - minSwap)) && (inversionCount < k); i++) {
            for (int j = i + 1; (j < (n - minSwap)) && (inversionCount < k); j++) {
                // swap to create inversion
                final int temp = a[minSwap + i];
                a[minSwap + i] = a[minSwap + j];
                a[minSwap + j] = temp;
                inversionCount++;
            }
        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final long k = Long.parseLong(args[1]);
        final int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}