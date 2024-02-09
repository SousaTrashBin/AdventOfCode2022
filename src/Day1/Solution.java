package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		List<Elf> listOfElfs = Arrays.stream(Files.readString(Path.of("inputFiles/Day1.txt")).split("\n\n"))
				.map(Elf::new).toList();
		Part1(listOfElfs);
		Part2(listOfElfs);
	}

	private static void Part1(List<Elf> listOfElfs) {
		System.out.println("Part 1 -> " + listOfElfs.stream().map(Elf::totalCalories).reduce(0, Math::max));
	}

	private static void Part2(List<Elf> listOfElfs) {
		List<Integer> top3Elfs = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			top3Elfs.add(listOfElfs.stream().map(Elf::totalCalories).reduce(0, (x, y) -> {
				if (top3Elfs.contains(y))
					return x;
				else
					return Math.max(x, y);
			}));
		}
		System.out.println("Part 2 -> " + top3Elfs.stream().reduce(0, Integer::sum));
	}
}
