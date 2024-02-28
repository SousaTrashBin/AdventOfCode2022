package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import AuxiliarClasses.Day;

public class Day4 extends Day {
	private final List<Assignment> assignmentList;

	public Day4() throws IOException {
		super(4);
		assignmentList = Files.readString(Path.of(super.getFile())).lines().map(Assignment::new).toList();
	}

	@Override
	public String Part1() {
		return String.valueOf(assignmentList.stream().filter(Assignment::containsAnother).count());
	}

	@Override
	public String Part2() {
		return String.valueOf(assignmentList.stream().filter(Assignment::isOverLapped).count());
	}
}
