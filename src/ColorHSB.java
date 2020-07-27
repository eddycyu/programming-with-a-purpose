public class ColorHSB {

    private static final int MAX_HUE = 359;
    private static final int MAX_SATURATION = 100;
    private static final int MAX_BRIGHTNESS = 100;

    private final int hue;          // 0...359, 0 = red, 120 = green, 24 = blue
    private final int saturation;   // 0...100
    private final int brightness;   // 0...100

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if ((h < 0) || (h > MAX_HUE)) {
            throw new IllegalArgumentException();
        }
        if ((s < 0) || (s > MAX_SATURATION)) {
            throw new IllegalArgumentException();
        }
        if ((b < 0) || (b > MAX_BRIGHTNESS)) {
            throw new IllegalArgumentException();
        }
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (saturation == 0) || (brightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException();
        }
        return (int) (Math.min(Math.pow(hue - that.hue, 2), Math.pow(360 - Math.abs(hue - that.hue), 2))
                + Math.pow(saturation - that.saturation, 2)
                + Math.pow(brightness - that.brightness, 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        final int h = Integer.parseInt(args[0]);
        final int s = Integer.parseInt(args[1]);
        final int b = Integer.parseInt(args[2]);
        final ColorHSB colorHSB1 = new ColorHSB(h, s, b);
        int closestDistance = Integer.MAX_VALUE;
        String closestColorName = null;
        ColorHSB closestColorHSB = null;
        while (StdIn.hasNextLine() && !StdIn.isEmpty()) {
            final String colorName = StdIn.readString();
            final int h2 = StdIn.readInt();
            final int s2 = StdIn.readInt();
            final int b2 = StdIn.readInt();
            final ColorHSB colorHSB2 = new ColorHSB(h2, s2, b2);
            final int distance = colorHSB1.distanceSquaredTo(colorHSB2);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestColorName = colorName;
                closestColorHSB = colorHSB2;
            }
        }
        StdOut.println(closestColorName + " " + closestColorHSB);
    }
}