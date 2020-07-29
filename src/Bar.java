import java.util.Arrays;

public class Bar implements Comparable<Bar> {

    private final String name;
    private final int value;
    private final String category;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if ((name == null) || (value < 0) || (category == null)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException();
        }
        // sort value in ascending order
        return Integer.compare(value, that.value);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        Bar[] bars = new Bar[3];
        bars[0] = new Bar("bar1", 10, "category1");
        bars[1] = new Bar("bar2", 5, "category1");
        bars[2] = new Bar("bar3", 10, "category1");
        Arrays.sort(bars);
        for (Bar bar : bars) {
            StdOut.println(bar.getName() + ", " + bar.getValue() + ", " + bar.getCategory());
        }
    }
}