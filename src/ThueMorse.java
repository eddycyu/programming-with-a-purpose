public class ThueMorse {

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);

        // construct sequence
        final int[] sequence = new int[n];
        for (int i = 1; i < sequence.length; i = i * 2) {
            for (int j = 0; j < i; j++) {
                // skip if n is not a power of 2
                if (i + j >= n) {
                    continue;
                }

                if (sequence[j] == 0) {
                    sequence[i + j] = 1;
                } else {
                    sequence[i + j] = 0;
                }
            }
        }

        // output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}