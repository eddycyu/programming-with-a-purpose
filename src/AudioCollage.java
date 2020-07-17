public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[a.length - 1 - i] = a[i];
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        final int length = Math.max(a.length, b.length);
        double[] result = new double[length];
        for (int i = 0; i < result.length; i++) {
            if ((i < a.length) && (i < b.length)) {
                result[i] = a[i] + b[i];
            } else if ((i < a.length) && (i >= b.length)) {
                result[i] = a[i];
            } else {
                result[i] = b[i];
            }
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] result = new double[(int) (a.length / alpha)];
        for (int i = 0; i < result.length; i++) {
            result[i] = a[(int) (i * alpha)];
        }
        return result;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        final double[] a = StdAudio.read("beatbox.wav");
        final double[] b = StdAudio.read("harp.wav");
        final double[] c = StdAudio.read("piano.wav");
        final double[] d = StdAudio.read("exposure.wav");
        final double[] e = StdAudio.read("singer.wav");
        final double[] aMixB = mix(a, b);
        final double[] dMixE = mix(d, e);
        final double[] reverseC = reverse(c);
        final double[] amplifyE = amplify(e, 1.5);
        final double[] speedD = changeSpeed(d, 2);
        double[] result = merge(aMixB, dMixE);
        result = merge(result, reverseC);
        result = merge(result, amplifyE);
        result = merge(result, speedD);

        // sample must be between -1 and 1
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 1.0) {
                result[i] = 0.9999999999;
            } else if (result[i] < -1.0) {
                result[i] = -0.9999999999;
            }
        }
        StdAudio.play(result);
    }
}