public class DiscreteDistribution {

    public static void main(String[] args) {
        final int m = Integer.parseInt(args[0]);

        // read sequence of positive integer command-line arguments
        final int n = args.length - 1;
        final int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
        }

        // define the cumulative sums
        final int[] sum = new int[a.length + 1];
        sum[0] = 0;
        for (int i = 0; i < a.length; i++) {
            sum[i + 1] = sum[i] + a[i];
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            // pick a random integer r uniformly between 0 and Sn - 1
            // double r = Math.random() * (sum[n] - 1);
            final double r = Math.random() * (sum[n]);
            // find the unique index i between 1 and n such that Si-1<=r<Si
            for (int j = 0; j < sum.length; j++) {
                if (r < sum[j]) {
                    System.out.print(j + " ");
                    count++;
                    if (count == 25) {
                        System.out.println();
                        count = 0;
                    }
                    break;
                }
            }
        }
    }
}