package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		String signal = Files.readString(Path.of("inputFiles/Day6.txt"));
		System.out.println("Part 1 -> " + getStartOfPacketMarker(signal, 4));
		System.out.println("Part 2 -> " + getStartOfPacketMarker(signal, 14));
	}

	public static int getStartOfPacketMarker(String signal, int distinctCharacters) {
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
