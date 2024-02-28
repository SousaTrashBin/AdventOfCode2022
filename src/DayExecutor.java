import java.io.IOException;
import java.util.List;

import AuxiliarClasses.Day;
import Day1.Day1;
import Day10.Day10;
import Day11.Day11;
import Day12.Day12;
import Day13.Day13;
import Day2.Day2;
import Day3.Day3;
import Day4.Day4;
import Day5.Day5;
import Day6.Day6;
import Day7.Day7;
import Day8.Day8;
import Day9.Day9;

public class DayExecutor {
	public static void main(String[] args) throws IOException {
		List<Day> dayList = List.of(new Day1(), new Day2(), new Day3(), new Day4(), new Day5(), new Day6(), new Day7(),
				new Day8(), new Day9(), new Day10(), new Day11(), new Day12(), new Day13());
		dayList.forEach(Day::getResult);
	}
}
