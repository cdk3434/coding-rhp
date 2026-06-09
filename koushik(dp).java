public class koushik_dp {

    public static int maxSumDP(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // dp[i][j] = max sum to reach cell (i, j) from any cell in col 0
        int[][] dp = new int[rows][cols];

        // Base case: first column
        for (int i = 0; i < rows; i++) {
            dp[i][0] = grid[i][0];
        }

        // Fill column by column (left to right)
        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                // Best value reachable from the previous column
                int best = dp[i][j - 1];                              // straight right
                if (i > 0)       best = Math.max(best, dp[i-1][j-1]); // from row above
                if (i < rows-1)  best = Math.max(best, dp[i+1][j-1]); // from row below

                dp[i][j] = grid[i][j] + best;
            }
        }

        // Answer: max in the last column
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            maxSum = Math.max(maxSum, dp[i][cols - 1]);
        }
        return maxSum;
    }

    // Rebuild the dp table (helper for path tracing)
    public static int[][] buildDP(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int best = dp[i][j - 1];
                if (i > 0)      best = Math.max(best, dp[i-1][j-1]);
                if (i < rows-1) best = Math.max(best, dp[i+1][j-1]);
                dp[i][j] = grid[i][j] + best;
            }
        }
        return dp;
    }

    // Trace back the optimal path
    public static int[] tracePath(int[][] grid, int[][] dp) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Find end row (max value in the last column)
        int endRow = 0;
        for (int i = 1; i < rows; i++) {
            if (dp[i][cols-1] > dp[endRow][cols-1]) endRow = i;
        }

        int[] path = new int[cols]; // path[j] = row index at column j
        path[cols-1] = endRow;

        for (int j = cols-1; j > 0; j--) {
            int cur = path[j];
            int best = Integer.MIN_VALUE;
            int prev = cur;
            for (int di = -1; di <= 1; di++) {
                int ni = cur + di;
                if (ni >= 0 && ni < rows && dp[ni][j-1] > best) {
                    best = dp[ni][j-1];
                    prev = ni;
                }
            }
            path[j-1] = prev;
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 5, 2, 4},
            {4, 2, 1, 6, 3},
            {2, 5, 3, 1, 7},
            {3, 1, 4, 5, 2}
        };

        // Print the grid
        System.out.println("Grid:");
        for (int[] row : grid) {
            for (int val : row) System.out.printf("%3d", val);
            System.out.println();
        }

        // Compute max sum
        int result = maxSumDP(grid);
        System.out.println("\nMaximum sum along rows: " + result);

        // Trace and print the optimal path
        int[][] dp = buildDP(grid);
        int[] path = tracePath(grid, dp);

        System.out.print("Optimal path (row index per column): ");
        for (int r : path) System.out.print(r + " ");
        System.out.println();

        System.out.print("Optimal path values: ");
        for (int j = 0; j < path.length; j++) {
            System.out.print(grid[path[j]][j]);
            if (j < path.length - 1) System.out.print(" -> ");
        }
        System.out.println();
    }
}
