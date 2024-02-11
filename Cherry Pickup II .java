class Solution {
    public int cherryPickup(int[][] grid) {
        final int m = grid.length;       
    final int n = grid[0].length;   
    int[][][] mem = new int[m][n][n];  


    // Initialize memoization array with -1
    for (int[][] A : mem)
      Arrays.stream(A).forEach(B -> Arrays.fill(B, -1));

    // Start the recursion from the top-left corner of the grid
    return cherryPick(grid, 0, 0, n - 1, mem);
  }

  // Recursive function to calculate the maximum cherries collected
  // x: current row, y1: column for robot #1, y2: column for robot #2
  private int cherryPick(int[][] grid, int x, int y1, int y2, int[][][] mem) {
    if (x == grid.length)
      return 0;

    if (y1 < 0 || y1 == grid[0].length || y2 < 0 || y2 == grid[0].length)
      return 0;

    // Check if the result for the current state is already computed and stored in mem
    if (mem[x][y1][y2] != -1)
      return mem[x][y1][y2];

    // Calculate the cherries collected in the current row for both robots
    final int currRow = grid[x][y1] + (y1 == y2 ? 0 : grid[x][y2]);

    // Explore all possible moves for both robots in the next row
    for (int d1 = -1; d1 <= 1; ++d1)
      for (int d2 = -1; d2 <= 1; ++d2)
        mem[x][y1][y2] =
            Math.max(mem[x][y1][y2], currRow + cherryPick(grid, x + 1, y1 + d1, y2 + d2, mem));

    return mem[x][y1][y2];
    }
}
