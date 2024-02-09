package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		Path filePath = Path.of("inputFiles/Day5.txt");
		CrateStack crateStack = new CrateStack(Files.readString(filePath).split("\n\n")[0]);
		List<Action> actionList = Files.readString(filePath).split("\n\n")[1].lines().map(Action::new).toList();
		Part1(actionList, crateStack.copy());
		Part2(actionList, crateStack.copy());
	}

	private static void Part1(List<Action> actionList, CrateStack crateStack) {
		actionList.forEach(crateStack::applyPart1);
		System.out.println("Part 1 -> " + crateStack.getSecretMessage());
	}

	private static void Part2(List<Action> actionList, CrateStack crateStack) {
		actionList.forEach(crateStack::applyPart2);
		System.out.println("Part 2 -> " + crateStack.getSecretMessage());
	}

}
