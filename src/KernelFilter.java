import java.awt.Color;

public class KernelFilter {

    private static int wrap(int index, int max) {
        if (index < 0) {
            // wrap from left to right
            if (max == 1) {
                return 0;
            } else {
                return max + (index % max);
            }
        } else if (index >= max) {
            // wrap from right to left
            if (max == 1) {
                return 0;
            } else {
                return index % max;
            }
        } else {
            return index;
        }
    }

    private static int roundAndClamp(double value) {
        long result = Math.round(value);
        if (result < 0) {
            return 0;
        } else if (result > 255) {
            return 255;
        } else {
            return (int) result;
        }
    }

    private static Picture applyFilter(Picture picture, int[][] filter, double multiplier) {
        final int width = picture.width();
        final int height = picture.height();
        final Picture result = new Picture(picture);
        // iterate through the picture
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int newR = 0, newG = 0, newB = 0;
                int mid = filter.length / 2;
                // iterate through the filter
                for (int i = -mid; i <= mid; i++) {
                    for (int j = -mid; j <= mid; j++) {
                        final Color color = picture.get(wrap(col + j, width), wrap(row + i, height));
                        final int r = color.getRed();
                        final int g = color.getGreen();
                        final int b = color.getBlue();
                        newR += (r * filter[i + mid][j + mid]);
                        newG += (g * filter[i + mid][j + mid]);
                        newB += (b * filter[i + mid][j + mid]);
                    }
                }
                newR = roundAndClamp(newR * multiplier);
                newG = roundAndClamp(newG * multiplier);
                newB = roundAndClamp(newB * multiplier);
                final Color newColor = new Color(newR, newG, newB);
                result.set(col, row, newColor);
            }
        }
        return result;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        final int[][] filter = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        return applyFilter(picture, filter, 1);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        final int[][] filter = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}};
        return applyFilter(picture, filter, 1.0 / 16.0);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        final int[][] filter = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}};
        return applyFilter(picture, filter, 1);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        final int[][] filter = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}};
        return applyFilter(picture, filter, 1);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        final int[][] filter = {
                {-2, -1, 0},
                {-1, 1, 1},
                {0, 1, 2}};
        return applyFilter(picture, filter, 1);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        final int[][] filter = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        return applyFilter(picture, filter, 1.0 / 9.0);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        identity(picture).show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();
    }
}