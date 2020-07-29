import java.util.Arrays;

public class BarChartRacer {

    private static void readGroup(In file, int k, BarChart chart) {
        final int n = Integer.parseInt(file.readLine());
        final Bar[] bars = new Bar[n];
        for (int i = 0; i < n; i++) {
            final String line = file.readLine();
            final String[] tokens = line.split(",");
            final String year = tokens[0];
            final String name = tokens[1];
            // final String country = tokens[2];
            final int value = Integer.parseInt(tokens[3]);
            final String category = tokens[4];
            bars[i] = new Bar(name, value, category);
            chart.setCaption(year);
        }
        Arrays.sort(bars);
        int count = 0;
        for (int i = bars.length - 1; (i >= 0) && (count < k); i--) {
            final Bar bar = bars[i];
            chart.add(bar.getName(), bar.getValue(), bar.getCategory());
            count++;
        }
    }

    public static void main(String[] args) {
        final int k = Integer.parseInt(args[1]);
        final In file = new In(args[0]);
        final String title = file.readLine();
        final String xAxisLabel = file.readLine();
        final String dataSource = file.readLine();
        // StdAudio.loop("soundtrackA.wav");
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        while (file.hasNextLine()) {
            chart.reset();
            StdDraw.clear();
            file.readLine();
            readGroup(file, k, chart);
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
        }
        file.close();
        // StdAudio.close();
    }
}