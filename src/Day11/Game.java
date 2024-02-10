package Day11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Game {
	private final List<Monkey> monkeyList;
	private final int module;

	public Game(String s) {
		monkeyList = Arrays.stream(s.split("\n\n")).map(Monkey::new).toList();
		module = getModule();
	}

	public Integer getModule() {
		return monkeyList.stream().map(Monkey::getDivisibleNumber).reduce(1, (x, y) -> x * y);
	}

	public long getPart1() {
		processRounds(20, x -> (long) Math.round(x / 3));
		return getMonkeyBusinessLevel();
	}

	public long getPart2() {
		processRounds(10000, Function.identity());
		return getMonkeyBusinessLevel();
	}

	public void processRounds(int howManyRounds, Function<Long, Long> function) {
		for (int i = 0; i < howManyRounds; i++) {
			for (Monkey monkey : monkeyList) {
				monkey.processRound(monkeyList, module, function);
			}
		}
	}

	public long getMonkeyBusinessLevel() {
		return monkeyList.stream().map(Monkey::getInspections).sorted((x, y) -> Math.toIntExact(y - x)).limit(2)
				.reduce(1L, (x, y) -> x * y);
	}
}
