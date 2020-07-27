public class Clock {

    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;
    private static final int MAX_HOURS = HOURS_PER_DAY - 1;
    private static final int MAX_MINUTES = MINUTES_PER_HOUR - 1;

    private int hours;      // 00-23
    private int minutes;    // 00-59

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if ((h < 0) || (h > MAX_HOURS)) {
            throw new IllegalArgumentException();
        }
        if ((m < 0) || (m > MAX_MINUTES)) {
            throw new IllegalArgumentException();
        }
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if ((s == null) || (s.length() != 5) || (s.charAt(2) != ':')) {
            throw new IllegalArgumentException();
        }
        final int h = Integer.parseInt(s.substring(0, 2));
        final int m = Integer.parseInt(s.substring(3, 5));
        if ((h < 0) || (h > MAX_HOURS)) {
            throw new IllegalArgumentException();
        }
        if ((m < 0) || (m > MAX_MINUTES)) {
            throw new IllegalArgumentException();
        }
        hours = h;
        minutes = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hours < that.hours) {
            return true;
        } else if (hours > that.hours) {
            return false;
        } else {
            return (minutes < that.minutes);
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minutes++;
        if (minutes > MAX_MINUTES) {
            hours++;
            minutes = 0;
        }
        if (hours > MAX_HOURS) {
            hours = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException();
        }
        if (delta > MAX_MINUTES) {
            final int dHours = (delta / MINUTES_PER_HOUR) % HOURS_PER_DAY;
            for (int i = 0; i < dHours; i++) {
                hours++;
                if (hours > MAX_HOURS) {
                    hours = 0;
                }
            }
        }
        final int dMinutes = delta % MINUTES_PER_HOUR;
        for (int i = 0; i < dMinutes; i++) {
            minutes++;
            if (minutes > MAX_MINUTES) {
                hours++;
                minutes = 0;
            }
            if (hours > MAX_HOURS) {
                hours = 0;
            }
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        final Clock clock1 = new Clock(0, 0);
        final Clock clock2 = new Clock(1, 30);
        StdOut.println("clock1: " + clock1);
        StdOut.println("clock2: " + clock2);
        StdOut.println("clock1 is before clock2: " + clock1.isEarlierThan(clock2));
        clock1.tic();
        StdOut.println("clock1: " + clock1);
        StdOut.println("clock2: " + clock2);
        clock1.toc(90);
        StdOut.println("clock1: " + clock1);
        StdOut.println("clock2: " + clock2);
        StdOut.println("clock1 is before clock2: " + clock1.isEarlierThan(clock2));
        Clock clock3 = new Clock("22:59");
        StdOut.println("clock3: " + clock3);
        clock3.toc(1440);
        StdOut.println("clock3: " + clock3);
    }
}