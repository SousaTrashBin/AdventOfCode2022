package Day2;

import java.util.HashMap;
import java.util.Map;

public class Round {
	char opponentPlay;
	char myPlay;

	public Round(String s) {
		opponentPlay = s.charAt(0);
		myPlay = s.charAt(2);
	}

	public int getPart1Score() {
		int score = 0;
		switch (myPlay) {
		case 'X' -> score++;
		case 'Y' -> score += 2;
		case 'Z' -> score += 3;
		}
		return switch (opponentPlay) {
		case 'A' -> {
			if (myPlay == 'Y')
				yield score + 6;
			else if (myPlay == 'X')
				yield score + 3;
			else
				yield score;
		}
		case 'B' -> {
			if (myPlay == 'Z')
				yield score + 6;
			else if (myPlay == 'Y')
				yield score + 3;
			else
				yield score;
		}
		case 'C' -> {
			if (myPlay == 'X')
				yield score + 6;
			else if (myPlay == 'Z')
				yield score + 3;
			else
				yield score;
		}
		default -> throw new IllegalStateException("Unexpected value: " + opponentPlay);
		};
	}

	public int getPart2Score() {
		int score = 0;
		switch (myPlay) {
		case 'X' -> score += 0; // Perder
		case 'Y' -> score += 3; // Empatar
		case 'Z' -> score += 6; // Ganhar
		}
		Map<Character, Integer> shapeValue = new HashMap<>();
		shapeValue.put('A', 1); // Pedra
		shapeValue.put('B', 2); // Papel
		shapeValue.put('C', 3); // Tesoura
		return switch (opponentPlay) {
		case 'A' -> {
			if (myPlay == 'Z')
				yield score + shapeValue.get('B');
			else if (myPlay == 'Y')
				yield score + shapeValue.get('A');
			else
				yield score + shapeValue.get('C');
		}
		case 'B' -> {
			if (myPlay == 'Z')
				yield score + shapeValue.get('C');
			else if (myPlay == 'Y')
				yield score + shapeValue.get('B');
			else
				yield score + shapeValue.get('A');
		}
		case 'C' -> {
			if (myPlay == 'Z')
				yield score + shapeValue.get('A');
			else if (myPlay == 'Y')
				yield score + shapeValue.get('C');
			else
				yield score + shapeValue.get('B');
		}
		default -> throw new IllegalStateException("Unexpected value: " + opponentPlay);
		};
	}
}
