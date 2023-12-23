package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		List<Assignment> assignmentList = Files.readString(Path.of("src/Day4/input.txt")).lines().map(Assignment::new)
				.toList();
		System.out.println("Part 1 -> " + assignmentList.stream().filter(Assignment::containsAnother).count());
		System.out.println("Part 2 -> " + assignmentList.stream().filter(Assignment::isOverLapped).count());
	}
}
