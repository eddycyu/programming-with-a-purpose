public class RightTriangle {

    public static void main(String[] args) {
        // use long instead of int to handle overflow
        final long a = Long.parseLong(args[0]);
        final long b = Long.parseLong(args[1]);
        final long c = Long.parseLong(args[2]);

        final long a2 = a * a;
        final long b2 = b * b;
        final long c2 = c * c;

        final boolean result = (a > 0) && (b > 0) && (c > 0)
                && ((a2 + b2 == c2) || (a2 + c2 == b2) || (b2 + c2 == a2));
        System.out.println(result);
    }
}