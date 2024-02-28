package Day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import AuxiliarClasses.Day;

public class Day13 extends Day {
	private final List<Pair> packetPairList;
	private List<Packet> packetList;

	public Day13() throws IOException {
		super(13);
		packetPairList = Arrays.stream(Files.readString(Path.of(super.getFile())).split("\n\n")).map(Pair::new)
				.toList();
		getSortedPacketList();
	}

	@Override
	public String Part1() {
		int count = 0;
		for (int i = 0; i < packetPairList.size(); i++) {
			if (packetPairList.get(i).isInRightOrder()) {
				count += i + 1;
			}
		}
		return String.valueOf(count);
	}

	@Override
	public String Part2() {
		int indexMult = 1;
		for (int i = 0; i < packetList.size(); i++) {
			if (packetList.get(i).equals(new Packet("[[2]]")) || packetList.get(i).equals(new Packet("[[6]]")))
				indexMult *= i + 1;
		}
		return String.valueOf(indexMult);
	}

	private void getSortedPacketList() throws IOException {
		packetList = new java.util.ArrayList<>(
				Arrays.stream(Files.readString(Path.of(super.getFile())).replace("\n\n", "\n").split("\n"))
						.map(Packet::new).toList());
		packetList.add(new Packet("[[2]]"));
		packetList.add(new Packet("[[6]]"));
		packetList.sort(Packet::compareTo);
	}
}
