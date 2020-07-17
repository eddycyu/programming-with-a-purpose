public class ShannonEntropy {

    public static void main(String[] args) {
        final int m = Integer.parseInt(args[0]);

        int count = 0;
        final int[] proportions = new int[m];
        while (!StdIn.isEmpty()) {
            int number = StdIn.readInt();
            proportions[number - 1]++;
            count++;
        }

        double h = 0.0;
        double p = 0.0;
        for (int i = 0; i < proportions.length; i++) {
            if (proportions[i] != 0) {
                p = (proportions[i] / (double) count);
                // log2N = log10(N)/log10(2)
                final double a = Math.log10(p);
                final double b = Math.log10(2);
                final double pi = -(p * (a / b));
                h += pi;
            }
        }
        StdOut.printf("%.4f", h);
    }
}