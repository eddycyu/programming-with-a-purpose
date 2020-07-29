public class Birthday {

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int trials = Integer.parseInt(args[1]);

        // note: at most n+1 people will enter a room before encountering
        // a pair that shares the same birthday; hence need to try up to
        // n+1 instead of n
        final int[] count = new int[n+1];
        for (int t = 0; t < trials; t++) {
            final boolean[] seenBirthday = new boolean[n];
            for (int nextPerson = 0; nextPerson < count.length; nextPerson++) {
                int birthday = (int) (Math.random() * n);
                // check if any person in the room has the same birthday as the next person
                if (seenBirthday[birthday]) {
                    count[nextPerson]++;
                    break;
                }
                seenBirthday[birthday] = true;
            }
        }

        // compute fraction and output
        final double[] fraction = new double[count.length];
        System.out.println(1 + "\t" + count[0] + "\t" + fraction[0]);
        for (int i = 1; i < count.length; i++) {
            double sum = 0.0;
            for (int j = 1; j <= i; j++) {
                sum += count[j];
            }
            fraction[i] = sum / trials;
            System.out.println(i + 1 + "\t" + count[i] + "\t" + fraction[i]);
            if (fraction[i] >= 0.5) {
                break;
            }
        }
    }
}