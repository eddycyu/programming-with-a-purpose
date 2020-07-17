public class Minesweeper {

    public static void main(String[] args) {
        final int m = Integer.parseInt(args[0]); // row
        final int n = Integer.parseInt(args[1]); // col
        final int k = Integer.parseInt(args[2]);

        final int[][] grid = new int[m][n];
        final int[] mineRow = new int[k];
        final int[] mineCol = new int[k];

        // generate mines
        final double[] randomValues = new double[2];
        int row;
        int col;
        int mineCount = 0;
        while (mineCount < k) {
            // required for passing the tests
            for (int i = 0; i < 2; i++) {
                randomValues[i] = Math.random();
            }
            row = (int) (randomValues[0] * m);
            col = (int) (randomValues[1] * n);
            if (grid[row][col] >= 0) {
                grid[row][col] = Integer.MIN_VALUE;
                mineRow[mineCount] = row;
                mineCol[mineCount] = col;
                mineCount++;
            }
        }

        // sum for neighboring cells next to mines
        final int maxRowIndex = m - 1;
        final int maxColIndex = n - 1;
        for (int i = 0; i < k; i++) {
            row = mineRow[i];
            col = mineCol[i];
            if (row > 0) {
                grid[row - 1][col]++; // up
                if (col > 0) {
                    grid[row - 1][col - 1]++; // upper left
                }
                if (col < maxColIndex) {
                    grid[row - 1][col + 1]++; // upper right
                }
            }
            if (row < maxRowIndex) {
                grid[row + 1][col]++; // down
                if (col > 0) {
                    grid[row + 1][col - 1]++; // lower left
                }
                if (col < maxColIndex) {
                    grid[row + 1][col + 1]++; // lower right
                }
            }
            if (col > 0) {
                grid[row][col - 1]++; // left
            }
            if (col < maxColIndex) {
                grid[row][col + 1]++; // right
            }
        }

        // output
        for (row = 0; row < m; row++) {
            for (col = 0; col < n; col++) {
                if (grid[row][col] < 0) {
                    System.out.print("*  ");
                } else {
                    System.out.print(grid[row][col] + "  ");
                }
            }
            System.out.println();
        }
    }
}