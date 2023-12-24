package Day5;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Action {
	List<Integer> moveFromWhere;

	public Action(String s) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s);
		moveFromWhere = m.results().map(x -> Integer.parseInt(x.group())).toList();
	}

	public int getMove() {
		return moveFromWhere.get(0);
	}

	public int getFrom() {
		return moveFromWhere.get(1);
	}

	public int getTo() {
		return moveFromWhere.get(2);
	}

	@Override
	public String toString() {
		return "move " + moveFromWhere.get(0) + " from " + moveFromWhere.get(1) + " to " + moveFromWhere.get(2);
	}
}
