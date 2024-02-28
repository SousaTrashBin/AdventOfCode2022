package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import AuxiliarClasses.Day;

public class Day3 extends Day {
	private final List<RuckSack> ruckSackList;

	public Day3() throws IOException {
		super(3);
		ruckSackList = Files.readString(Path.of(super.getFile())).lines().map(RuckSack::new).toList();
	}

	@Override
	public String Part1() {
		return ruckSackList.stream().map(RuckSack::getRuckSackPriorityNumber).reduce(0, Integer::sum).toString();
	}

	@Override
	public String Part2() {
		List<RuckSackGroup> ruckSackGroupList = new ArrayList<>();
		for (int i = 0; i < ruckSackList.size() / 3; i++) {
			ruckSackGroupList
					.add(new RuckSackGroup(ruckSackList.get(i), ruckSackList.get(i + 1), ruckSackList.get(i + 2)));
		}
		return ruckSackGroupList.stream().map(RuckSackGroup::getRuckSackPriorityNumber).reduce(0, Integer::sum)
				.toString();
	}

}
