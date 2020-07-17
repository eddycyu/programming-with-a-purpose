import java.awt.Color;

public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        // draw filled square
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2.0);
        // draw border
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.square(x, y, length / 2);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) {
            return;
        }

        // lower left and lower right
        double x01 = x - (length / 2);
        double y01 = y - (length / 2);
        double x02 = x + (length / 2);
        double y02 = y - (length / 2);
        // uppper left and upper right
        double x11 = x - (length / 2);
        double y11 = y + (length / 2);
        double x12 = x + (length / 2);
        double y12 = y + (length / 2);

        // draw from upper left to lower right
        draw(n - 1, x11, y11, length / 2);    // upper left
        draw(n - 1, x12, y12, length / 2);    // upper right
        drawSquare(x, y, length);
        draw(n - 1, x01, y01, length / 2);    // lower left
        draw(n - 1, x02, y02, length / 2);    // lower right
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}