public class CMYKtoRGB {

    public static void main(String[] args) {
        final double c = Double.parseDouble(args[0]);
        final double m = Double.parseDouble(args[1]);
        final double y = Double.parseDouble(args[2]);
        final double k = Double.parseDouble(args[3]);

        final double w = 1.0 - k;
        final double r = 255.0 * w * (1.0 - c);
        final double g = 255.0 * w * (1.0 - m);
        final double b = 255.0 * w * (1.0 - y);

        System.out.println("red   = " + Math.round(r));
        System.out.println("green = " + Math.round(g));
        System.out.println("blue  = " + Math.round(b));
    }
}