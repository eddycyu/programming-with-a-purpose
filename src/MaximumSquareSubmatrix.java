public class MaximumSquareSubmatrix {

    private static void labelCells(int[][] a, int row, int col, int size) {
        for (int r = row; r < (row + size); r++) {
            for (int c = col; c < col + size; c++) {
                if (a[r][c] < size) {
                    a[r][c] = size;
                }
            }
        }
    }

    private static int contig(int[][] a, int row, int col, int size, int maxRow, int maxCol) {
        if (a[row][col] == 0) {
            return size; // no increase, return previous size
        }

        /**
         * example:
         *
         * 011?0
         * 011?0
         * 0???0
         *
         * size = 2
         * check for (2*size+1) counts
         */

        int count = 0;
        for (int r = 0; r < size + 1; r++) {
            // check rows (size+1) at fixed column [vertical direction]
            if (a[row + r][col + size] > 0) {
                count++;
            }
        }
        for (int c = 0; c < size; c++) {
            // check columns (size) at fixed row [horizontal direction]
            if (a[row + size][col + c] > 0) {
                count++;
            }
        }
        if (count == (2 * size + 1)) {
            // found next larger square
            size++;
            if ((row + size - 1 < maxRow) && (col + size - 1 < maxCol)) {
                // try same row, next column
                return contig(a, row, col, size, maxRow, maxCol);
            } else {
                // no more columns to try; return current size
                return size;
            }
        } else {
            return size; // no increase in size, return previous size
        }
    }

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        // make copy of a (to pass 'no mutate' test)
        int maxSize = 0;
        final int maxRowCol = a[0].length - 1;
        final int[][] a2 = new int[maxRowCol + 1][maxRowCol + 1];
        for (int row = 0; row < a2[0].length; row++) {
            for (int col = 0; col < a2[0].length; col++) {
                a2[row][col] = a[row][col];
                maxSize = Math.max(maxSize, a2[row][col]);
            }
        }

        // matrix row/col must be 2 or larger; else just return value in single cell matrix
        if (a2[0].length < 2) {
            return a2[0][0];
        }

        // sum up largest contiguous square submatrix (row by row)
        for (int row = 0; row < maxRowCol; row++) {
            for (int col = 0; col < maxRowCol; col++) {
                if (a2[row][col] > 0) {
                    final int size = contig(a, row, col, 1, maxRowCol, maxRowCol);
                    // mark submatrix with size
                    labelCells(a2, row, col, size);
                    // remember max size
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        // return largest
        return maxSize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        final int n = StdIn.readInt();
        final int[][] a = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                a[row][col] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }
}