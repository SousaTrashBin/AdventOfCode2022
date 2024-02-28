package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AuxiliarClasses.Day;

public class Day1 extends Day {
	private final List<Elf> listOfElfs;

	public Day1() throws IOException {
		super(1);
		listOfElfs = Arrays.stream(Files.readString(Path.of(super.getFile())).split("\n\n")).map(Elf::new).toList();
	}

	@Override
	public String Part1() {
		return listOfElfs.stream().map(Elf::totalCalories).reduce(0, Math::max).toString();
	}

	@Override
	public String Part2() {
		List<Integer> top3Elfs = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			top3Elfs.add(listOfElfs.stream().map(Elf::totalCalories).reduce(0,
					(x, y) -> top3Elfs.contains(y) ? x : Math.max(x, y)));
		}
		return top3Elfs.stream().reduce(0, Integer::sum).toString();
	}
}
