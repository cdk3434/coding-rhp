import java.util.*;

class koushik_graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        System.out.print("Enter no of rows and columns in the grid: ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] grid = new int[row][col];

        System.out.println("Enter elements:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter element index to find the sum of adjacent elements: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] diff = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        for (int i = 0; i < 8; i++) {
            int ar = m + diff[i][0];
            int ac = n + diff[i][1];
            if (ar >= 0 && ar < row && ac >= 0 && ac < col) {
                sum += grid[ar][ac];
            }
        }

        System.out.println("Sum: " + sum);
        sc.close();
    }
}
