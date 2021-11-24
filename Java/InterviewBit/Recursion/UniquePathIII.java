package Recursion;

/**
 * @author Kedar Erande
 */
public class UniquePathIII {
    public static void main(String[] args) {

        int grid[][] = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(solve(grid));
    }

    private static int solve(int[][] grid) {
        int zero = 0;
        int sx = 0;
        int sy = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    zero++;
                } else if (grid[r][c] == 1) {
                    sx = r;
                    sy = c;
                }
            }
        }

        return dfs(grid, sx, sy, zero);
    }

    private static int dfs(int grid[][], int sx, int sy, int zero) {
        if (sx < 0 || sy < 0 || sx >= grid.length || sy >= grid[0].length || grid[sx][sy] == -1) {
            return 0;
        }
        if (grid[sx][sy] == 2) {
            return zero == -1 ? 1 : 0;
        }
        grid[sx][sy] = -1; //visited path hence make it -1;
        zero--;
        int totalPaths = dfs(grid, sx + 1, sy, zero) +
                dfs(grid, sx, sy + 1, zero) +
                dfs(grid, sx - 1, sy, zero) +
                dfs(grid, sx, sy - 1, zero);

        grid[sx][sy] = 0;
        zero++;
        return totalPaths;
    }
}
