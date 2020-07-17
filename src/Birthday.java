public class Birthday {

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int trials = Integer.parseInt(args[1]);

        final int[] count = new int[n];
        final boolean[] seenBirthday = new boolean[n];
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++) {
                seenBirthday[i] = false;
            }
            for (int nextPerson = 0; nextPerson < n; nextPerson++) {
                int birthday = (int) (Math.random() * n);
                // check if any person in the room has the same birthday as the next person
                if (seenBirthday[birthday]) {
                    count[nextPerson]++;
                    break;
                }
                seenBirthday[birthday] = true;
            }
        }

        // compute fraction
        final double[] fraction = new double[n];
        for (int i = 1; i < count.length; i++) {
            double sum = 0.0;
            for (int j = 1; j <= i; j++) {
                sum += count[j];
            }
            fraction[i] = sum / trials;
        }

        // output
        for (int i = 0; i < count.length; i++) {
            System.out.println(i + 1 + "\t" + count[i] + "\t" + fraction[i]);
            if (fraction[i] >= 0.5) {

                break;
            }
        }
    }
}