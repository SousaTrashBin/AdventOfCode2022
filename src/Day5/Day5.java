package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import AuxiliarClasses.Day;

public class Day5 extends Day {
	private final CrateStack crateStack;
	private final List<Action> actionList;

	public Day5() throws IOException {
		super(5);
		crateStack = new CrateStack(Files.readString(Path.of(super.getFile())).split("\n\n")[0]);
		actionList = Files.readString(Path.of(super.getFile())).split("\n\n")[1].lines().map(Action::new).toList();
	}

	@Override
	public String Part1() {
		CrateStack copy = crateStack.copy();
		actionList.forEach(copy::applyPart1);
		return copy.getSecretMessage();
	}

	@Override
	public String Part2() {
		CrateStack copy = crateStack.copy();
		actionList.forEach(copy::applyPart1);
		return copy.getSecretMessage();
	}
}
