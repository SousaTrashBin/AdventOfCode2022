package Day1;

import java.util.List;

public class Elf {
	List<Integer> foodItemCalories;

	public Elf(String s) {
		foodItemCalories = s.lines().map(Integer::parseInt).toList();
	}

	public int totalCalories() {
		return foodItemCalories.stream().reduce(0, Integer::sum);
	}
}
