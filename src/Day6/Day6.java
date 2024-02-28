package Day6;

import AuxiliarClasses.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day6 extends Day {
	private final String signal;

	public Day6() throws IOException {
		super(6);
		signal = Files.readString(Path.of(super.getFile()));
	}

	@Override
	public String Part1() {
		return String.valueOf(getStartOfPacketMarker(4));
	}

	@Override
	public String Part2() {
		return String.valueOf(getStartOfPacketMarker(14));
	}

	private int getStartOfPacketMarker(int distinctCharacters) {
		int i = 0;
		Deque<Character> characterDeque = new LinkedList<>();
		while (characterDeque.size() != distinctCharacters) {
			if (!characterDeque.contains(signal.charAt(i)))
				characterDeque.add(signal.charAt(i++));
			else
				while (characterDeque.contains(signal.charAt(i)))
					characterDeque.removeFirst();
		}
		return i;
	}
}
