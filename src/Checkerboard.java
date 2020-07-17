import java.awt.Color;

public class Checkerboard {

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);

        StdDraw.setScale(0, n);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row % 2 == 0) {
                    if (col % 2 == 0) {
                        StdDraw.setPenColor(Color.BLUE);
                    } else {
                        StdDraw.setPenColor(Color.LIGHT_GRAY);
                    }
                } else {
                    if (col % 2 == 0) {
                        StdDraw.setPenColor(Color.LIGHT_GRAY);
                    } else {
                        StdDraw.setPenColor(Color.BLUE);
                    }
                }
                StdDraw.filledSquare(col + 0.5, row + 0.5, 0.5);
            }
        }
    }
}