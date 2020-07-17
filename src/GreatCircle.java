public class GreatCircle {

    public static void main(String[] args) {
        final double x1 = Math.toRadians(Double.parseDouble(args[0]));
        final double y1 = Math.toRadians(Double.parseDouble(args[1]));
        final double x2 = Math.toRadians(Double.parseDouble(args[2]));
        final double y2 = Math.toRadians(Double.parseDouble(args[3]));

        final double sin2x = Math.sin((x2 - x1) / 2);
        final double sin2y = Math.sin((y2 - y1) / 2);
        final double twor = 2 * 6371.0;

        final double distance =
                twor * Math.asin(Math.sqrt(
                        (sin2x * sin2x) + (Math.cos(x1) * Math.cos(x2) * (sin2y * sin2y))));
        System.out.println(distance + " kilometers");
    }
}