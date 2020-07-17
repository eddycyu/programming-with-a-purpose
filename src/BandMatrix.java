public class BandMatrix {

    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int width = Integer.parseInt(args[1]);
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (Math.abs(x - y) > width) {
                    if (x == 0) {
                        System.out.print("0");
                    } else {
                        System.out.print("  0");
                    }
                } else {
                    if (x == 0) {
                        System.out.print("*");
                    } else {
                        System.out.print("  *");
                    }
                }
            }
            System.out.println();
        }
    }
}