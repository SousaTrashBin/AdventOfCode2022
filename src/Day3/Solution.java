package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		Path FilePath = Path.of("inputFiles/Day3.txt");
		Part1(FilePath);
		Part2(FilePath);
	}

	private static void Part2(Path FilePath) throws IOException {
		String[] ruckSacks = Files.readString(FilePath).lines().toArray(String[]::new);
		List<RuckSackGroup> ruckSackGroupList = new ArrayList<>();
		for (int i = 0; i < ruckSacks.length / 3; i++) {
			ruckSackGroupList.add(new RuckSackGroup(ruckSacks[i * 3], ruckSacks[i * 3 + 1], ruckSacks[i * 3 + 2]));
		}
		System.out.println("Part 2 -> "
				+ ruckSackGroupList.stream().map(RuckSackGroup::getRuckSackPriorityNumber).reduce(0, Integer::sum));
	}

	private static void Part1(Path FilePath) throws IOException {
		List<RuckSack> listOfContents = Files.readString(FilePath).lines().map(RuckSack::new).toList();
		System.out.println("Part 1 -> "
				+ listOfContents.stream().map(RuckSack::getRuckSackPriorityNumber).reduce(0, Integer::sum));
	}
}
