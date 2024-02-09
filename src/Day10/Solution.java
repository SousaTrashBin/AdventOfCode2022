package Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
	public static void main(String[] args) throws IOException {
		CPU c = new CPU();
		Files.readString(Path.of("inputFiles/Day10.txt")).lines().forEach(c::processLine);
		System.out.println("Part 1 -> " + c.getSignalStrength());
		System.out.println(c.drawSprite());
	}
}
