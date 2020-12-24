package graphs;

public class NumIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid[0].length == 0) {
			return 0;
		}

		char[][] clonedGrid = grid.clone();
		int numberIslands = 0;

		for (int i = 0; i < clonedGrid.length; i++) {
			for (int j = 0; j < clonedGrid[0].length; j++) {
				if (clonedGrid[i][j] == '1') {
					numberIslands++;
					depthFirstTraversal(clonedGrid, i, j);

				}
			}
		}

		return numberIslands;
	}

	private void depthFirstTraversal(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		depthFirstTraversal(grid, i - 1, j);
		depthFirstTraversal(grid, i + 1, j);
		depthFirstTraversal(grid, i, j - 1);
		depthFirstTraversal(grid, i, j + 1);
	}
}
