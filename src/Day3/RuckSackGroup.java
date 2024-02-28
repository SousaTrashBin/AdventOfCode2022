package Day3;

import java.util.ArrayList;
import java.util.List;

public class RuckSackGroup {
	private final List<RuckSack> ruckSacks = new ArrayList<>();

	public RuckSackGroup(RuckSack r1, RuckSack r2, RuckSack r3) {
		ruckSacks.add(r1);
		ruckSacks.add(r2);
		ruckSacks.add(r3);
	}

	public int getRuckSackPriorityNumber() {
		for (char c : ruckSacks.getFirst().getItems().toCharArray()) {
			boolean hasCharacter = true;
			for (int i = 1; i < ruckSacks.size(); i++) {
				if (!ruckSacks.get(i).getItems().contains(String.valueOf(c))) {
					hasCharacter = false;
					break;
				}
			}
			if (hasCharacter)
				return RuckSack.getPriorityNumber(c);
		}
		return 0;
	}

}
