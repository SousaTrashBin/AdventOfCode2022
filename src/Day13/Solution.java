package Day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		String file = Files.readString(Path.of("inputFiles/Day13.txt"));
		List<Pair> pairList = getPairList(file);
		System.out.println("Part 1 -> " + getPart1(pairList));
		List<Packet> packetList = getSortedPacketList(file);
		System.out.println("Part 2 -> " + getPart2(packetList));
	}

	private static List<Pair> getPairList(String file) {
		return Arrays.stream(file.split("\n\n")).map(Pair::new).toList();
	}

	private static List<Packet> getSortedPacketList(String file) {
		List<Packet> packetList = new java.util.ArrayList<>(
				Arrays.stream(file.replace("\n\n", "\n").split("\n")).map(Packet::new).toList());
		packetList.add(new Packet("[[2]]"));
		packetList.add(new Packet("[[6]]"));
		packetList.sort(Packet::compareTo);
		return packetList;
	}

	public static int getPart1(List<Pair> pairList) {
		int count = 0;
		for (int i = 0; i < pairList.size(); i++) {
			if (pairList.get(i).isInRightOrder()) {
				count += i + 1;
			}
		}
		return count;
	}

	public static int getPart2(List<Packet> packetList) {
		int indexMult = 1;
		for (int i = 0; i < packetList.size(); i++) {
			if (packetList.get(i).equals(new Packet("[[2]]")) || packetList.get(i).equals(new Packet("[[6]]")))
				indexMult *= i + 1;
		}
		return indexMult;
	}
}
