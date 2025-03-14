package MediumQuestions;

public class NumberOfIslands {

    /**
     Given an n*n 2d binary grid which represents a map of "1"s (land) and "0"s(water)
     return the number of islands
     An island is surrounded by water and is formed
     by connecting adjacent lands horizontally or vertically.
     You may assume all four edges of the grid are surrounded by water
     */


        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int numIslands = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') { // Found an unvisited island
                        numIslands += 1;
                        dfs(grid, i, j); // Explore the island
                    }
                }
            }
            return numIslands;
        }

        private void dfs(char[][] grid, int row, int col) {
            // Check bounds and if the cell is water ('0') or already visited
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
                return;
            }

            // Mark the cell as visited
            grid[row][col] = '0';

            // Explore all four directions
            dfs(grid, row + 1, col); // Down
            dfs(grid, row - 1, col); // Up
            dfs(grid, row, col + 1); // Right
            dfs(grid, row, col - 1); // Left
        }


    }


