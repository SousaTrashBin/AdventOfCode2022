package Day8;

import java.util.Arrays;

public class TreeMap {
	private final int[][] treeGrid;
	private final int length;
	private final int height;

	public TreeMap(String s) {
		treeGrid = s.lines().map(line -> line.chars().map(Character::getNumericValue).toArray()).toArray(int[][]::new);
		length = treeGrid.length;
		height = treeGrid[0].length;
	}

	public int getVisibleGrids() {
		int sum = length * height - ((length - 2) * (height - 2));
		for (int i = 1; i < treeGrid.length - 1; i++) {
			for (int j = 1; j < treeGrid[i].length - 1; j++) {
				if (isVisible(i, j))
					sum += 1;
			}
		}
		return sum;
	}

	public int biggestScenicScore() {
		int maxScenicScore = 0;
		for (int i = 1; i < treeGrid.length - 1; i++) {
			for (int j = 1; j < treeGrid[i].length - 1; j++) {
				maxScenicScore = Math.max(maxScenicScore, getScenicScore(i, j));
			}
		}
		return maxScenicScore;
	}

	private int getScenicScore(int i, int j) {
		int rightScenicScore = 0;
		int leftScenicScore = 0;
		int topScenicScore = 0;
		int bottomScenicScore = 0;

		for (int k = i + 1; k < height; k++) {
			bottomScenicScore++;
			if (treeGrid[k][j] >= treeGrid[i][j]) {
				break;
			}
		}

		for (int k = i - 1; k >= 0; k--) {
			topScenicScore++;
			if (treeGrid[k][j] >= treeGrid[i][j]) {
				break;
			}
		}

		for (int k = j + 1; k < length; k++) {
			rightScenicScore++;
			if (treeGrid[i][k] >= treeGrid[i][j]) {
				break;
			}
		}

		for (int k = j - 1; k >= 0; k--) {
			leftScenicScore++;
			if (treeGrid[i][k] >= treeGrid[i][j]) {
				break;
			}
		}

		return rightScenicScore * leftScenicScore * topScenicScore * bottomScenicScore;
	}

	private boolean isVisible(int i, int j) {
		boolean visibleToTheLeft = true;
		boolean visibleToTheRight = true;
		boolean visibleToTheTop = true;
		boolean visibleToTheBottom = true;

		for (int k = 0; k < j; k++) {
			if (treeGrid[i][j] <= treeGrid[i][k]) {
				visibleToTheLeft = false;
				break;
			}
		}
		for (int k = j + 1; k < treeGrid[i].length; k++) {
			if (treeGrid[i][j] <= treeGrid[i][k]) {
				visibleToTheRight = false;
				break;
			}
		}
		for (int k = 0; k < i; k++) {
			if (treeGrid[i][j] <= treeGrid[k][j]) {
				visibleToTheTop = false;
				break;
			}
		}
		for (int k = i + 1; k < treeGrid.length; k++) {
			if (treeGrid[i][j] <= treeGrid[k][j]) {
				visibleToTheBottom = false;
				break;
			}
		}
		return visibleToTheLeft || visibleToTheRight || visibleToTheTop || visibleToTheBottom;
	}

	@Override
	public String toString() {
		return Arrays.deepToString(treeGrid);
	}
}
