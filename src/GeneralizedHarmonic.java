public class GeneralizedHarmonic {

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int r = Integer.parseInt(args[1]);

        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum = sum + (1 / Math.pow(i, r));
        }
        System.out.println(sum);
    }
}