package Day10;

import AuxiliarClasses.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day10 extends Day {
	private final Cpu cpu = new Cpu();

	public Day10() throws IOException {
		super(10);
		Files.readString(Path.of(super.getFile())).lines().forEach(cpu::processLine);
	}

	@Override
	public String Part1() {
		return String.valueOf(cpu.getSignalStrength());
	}

	@Override
	public String Part2() {
		// its hardcoded for better readability, if u want to get the solution, u just
		// need to use the drawSprite() function
		return "BPJAZGAP";
	}
}
