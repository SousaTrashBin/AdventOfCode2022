package Day3;

import java.util.ArrayList;
import java.util.List;

public class RuckSackGroup {
	List<String> ruckSacks = new ArrayList<>();

	public RuckSackGroup(String r1, String r2, String r3) {
		ruckSacks.add(r1);
		ruckSacks.add(r2);
		ruckSacks.add(r3);
	}

	public int getRuckSackPriorityNumber() {
		for (char c : ruckSacks.get(0).toCharArray()) {
			boolean hasCharacter = true;
			for (int i = 1; i < ruckSacks.size(); i++) {
				if (!ruckSacks.get(i).contains(String.valueOf(c))) {
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
