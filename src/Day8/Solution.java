package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
	public static void main(String[] args) throws IOException {
		TreeMap grid = new TreeMap(Files.readString(Path.of("inputFiles/Day8.txt")));
		System.out.println("Part 1 -> " + grid.getVisibleGrids());
		System.out.println("Part 2 -> " + grid.biggestScenicScore());
	}
}
