public class RandomWalker {

    public static void main(String[] args) {
        final int r = Integer.parseInt(args[0]);

        // output starting position
        int x = 0;
        int y = 0;
        System.out.println("(" + x + "," + y + ")");

        double random = 0.0;
        int steps = 0;
        int distance = 0;
        while (distance != r) {
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

            // output new position
            System.out.println("(" + x + "," + y + ")");

            // calculate new manhattan distance
            distance = Math.abs(x) + Math.abs(y);
        }
        System.out.println("steps = " + steps);
    }
}