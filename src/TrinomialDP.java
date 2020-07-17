public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {

        if ((k > n) || (k < -n)) {
            return 0;
        }

        final long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1; // if n=0 && k=0 then T(n,k)=1
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j >= 0; j--) {
                long a; // T(n-1,k-1)
                if (j - 1 >= 0) {
                    a = dp[i - 1][j - 1];
                } else {
                    // T(n,k) = T(n,-k)
                    a = dp[i - 1][Math.abs(j - 1)];
                }
                final long b = dp[i - 1][j]; // T(n-1,k)
                final long c;
                if (j < i) {
                    c = dp[i - 1][j + 1]; // T(n-1,k+1)
                } else {
                    c = 0; // if k > n then 0
                }
                dp[i][j] = a + b + c;
            }
        }
        return dp[n][Math.abs(k)];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}