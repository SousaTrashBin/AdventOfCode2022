package Day10;

import java.util.ArrayList;
import java.util.List;

public class Cpu {
	private int registerX = 1;
	private final List<Integer> listOfRegisterXValues = new ArrayList<>();
	private final List<Integer> listOfWantedValues = List.of(20, 60, 100, 140, 180, 220);
	private final List<Integer> listOfLowerBound = new ArrayList<>();

	public void addX(int v) {
		listOfRegisterXValues.add(registerX);
		listOfLowerBound.add(registerX);
		listOfLowerBound.add(registerX);
		registerX += v;
		listOfRegisterXValues.add(registerX);
	}

	public void noop() {
		listOfRegisterXValues.add(registerX);
		listOfLowerBound.add(registerX);
	}

	public int getSignalStrength() {
		// listOfRegisterXValues.get(x - 2) because we want to get the value of the X
		// register
		// at the start of the x-1 tick which, is equal to the value at the end of the
		// x-2 tick
		return listOfWantedValues.stream().mapToInt(x -> listOfRegisterXValues.get(x - 2) * x).sum();
	}

	public void processLine(String s) {
		if (s.equals("noop"))
			noop();
		else if (s.split(" ")[0].equals("addx"))
			addX(Integer.parseInt(s.split(" ")[1]));
	}

	public String drawSprite() {
		StringBuilder sb = new StringBuilder();
		int NUMBER_OF_ROWS = 6;
		int PIXELS_PER_ROW = 40;

		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			for (int j = 1; j <= PIXELS_PER_ROW; j++) {
				int index = i * PIXELS_PER_ROW + j - 1;
				int spriteLocation = listOfLowerBound.get(index);
				sb.append((j >= spriteLocation && j <= spriteLocation + 2) ? "█" : " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
