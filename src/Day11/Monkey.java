package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Monkey {
	private final List<Long> itemList;
	private final Function<Long, Long> operation;
	private final Function<Long, Integer> trueOrFalseMonkeys;
	private long howManyInspections = 0;
	private int divisibleNumber;

	public Monkey(String s) {
		String[] lines = s.split("\n");
		itemList = getItemList(lines[1]);
		operation = getOperation(lines[2]);
		trueOrFalseMonkeys = getTrueOrFalseMonkeys(lines);
	}

	private Function<Long, Integer> getTrueOrFalseMonkeys(String[] lines) {
		Predicate<Long> predicate = getTest(lines[3]);
		return x -> predicate.test(x) ? parseString(lines[4]) : parseString(lines[5]);

	}

	private int parseString(String s) {
		return Integer.parseInt(s.substring(s.indexOf("y") + 1).trim());
	}

	private Predicate<Long> getTest(String line) {
		String number = line.substring(line.indexOf("by") + 2).trim();
		divisibleNumber = Integer.parseInt(number);
		return (old) -> old % Integer.parseInt(number) == 0;
	}

	private static List<Long> getItemList(String line) {
		return new ArrayList<>(Arrays.stream(line.substring(line.indexOf(':') + 1).split(",")).map(String::trim)
				.map(Long::parseLong).toList());
	}

	private Function<Long, Long> getOperation(String line) {
		line = line.substring(line.indexOf('=') + 1);
		if (line.contains("+")) {
			String[] parts = line.split("\\+");
			if (parts[1].trim().equals("old"))
				return (old) -> old + old;
			else
				return (old) -> old + Integer.parseInt(parts[1].trim());
		} else {
			String[] parts = line.split("\\*");
			if (parts[1].trim().equals("old"))
				return (old) -> old * old;
			else
				return (old) -> old * Integer.parseInt(parts[1].trim());
		}
	}

	public void processRound(List<Monkey> monkeyList, long module, Function<Long, Long> function) {
		while (!itemList.isEmpty()) {
			howManyInspections++;
			long firstItem = itemList.removeFirst();
			firstItem = operation.apply(firstItem);
			firstItem = function.apply(firstItem);
			monkeyList.get(trueOrFalseMonkeys.apply(firstItem)).addItem(firstItem % module);
		}
	}

	public void addItem(long l) {
		itemList.add(l);
	}

	public long getInspections() {
		return howManyInspections;
	}

	public int getDivisibleNumber() {
		return divisibleNumber;
	}
}
