public class RandomWalkers {

    public static void main(String[] args) {
        final int r = Integer.parseInt(args[0]);
        final int trials = Integer.parseInt(args[1]);

        double random;
        int totalSteps = 0;
        for (int trial = 0; trial < trials; trial++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            int distance = 0;
            while ((r > 0) && (distance != r)) {
                random = Math.random();
                if (random < 0.25) {
                    x -= 1;
                } else if (random < 0.50) {
                    x += 1;
                } else if (random < 0.75) {
                    y -= 1;
                } else {
                    y += 1;
                }
                steps++;

                // calculate new manhattan distance
                distance = Math.abs(x) + Math.abs(y);
            }
            totalSteps += steps;
        }
        System.out.println("average number of steps = " + (double) totalSteps / (double) trials);
    }
}