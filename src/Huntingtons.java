public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int previousJ = -1;
        int count = 0;
        int maxCount = 0;
        int i = 0;
        while (i < dna.length()) {
            int j = dna.indexOf("CAG", i);
            if (j == -1) {
                // no more occurrence of CAG is found
                break;
            } else if ((previousJ == -1) || (previousJ == (j - 3))) {
                // first find or found consecutive
                count++;
            } else {
                // non-consecutive; restart count
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
            previousJ = j;
            i = j + 3;
        }
        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace("\t", "").replace("\n", "").replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if ((maxRepeats >= 0) && (maxRepeats <= 9)) {
            return "not human";
        } else if ((maxRepeats >= 10) && (maxRepeats <= 35)) {
            return "normal";
        } else if ((maxRepeats >= 36) && (maxRepeats <= 39)) {
            return "high risk";
        } else if ((maxRepeats >= 40) && (maxRepeats <= 180)) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        final String dna = removeWhitespace(new In(args[0]).readAll());
        final int count = maxRepeats(dna);
        StdOut.println("max repeats = " + count);
        StdOut.println(diagnose(count));
    }
}