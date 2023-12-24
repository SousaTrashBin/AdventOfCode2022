package Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CrateStack {
	private final List<Stack<Character>> stackList;

	public CrateStack(String s) {
		char[][] charArray = s.lines().map(String::toCharArray).toArray(char[][]::new);
		stackList = new ArrayList<>();
		for (int i = 0; i < charArray[0].length; i++) {
			if (Character.isDigit(charArray[charArray.length - 1][i])) {
				Stack<Character> tempStack = new Stack<>();
				for (int j = charArray.length - 2; j >= 0; j--) {
					if (charArray[j][i] != ' ')
						tempStack.push(charArray[j][i]);
				}
				stackList.add(tempStack);
			}
		}
	}

	public CrateStack() {
		stackList = new ArrayList<>();
	}

	public void applyPart1(Action action) {
		int from = action.getFrom() - 1;
		int to = action.getTo() - 1;
		Stack<Character> fromStack = stackList.get(from);
		Stack<Character> toStack = stackList.get(to);
		for (int i = 0; i < action.getMove(); i++) {
			char tempChar = fromStack.pop();
			toStack.push(tempChar);
		}
	}

	public void applyPart2(Action action) {
		int from = action.getFrom() - 1;
		int to = action.getTo() - 1;
		Stack<Character> fromStack = stackList.get(from);
		Stack<Character> toStack = stackList.get(to);
		Stack<Character> tempStack = new Stack<>();
		for (int i = 0; i < action.getMove(); i++) {
			char tempChar = fromStack.pop();
			tempStack.push(tempChar);
		}
		while (!tempStack.isEmpty()) {
			toStack.push(tempStack.pop());
		}
	}

	public String getSecretMessage() {
		StringBuilder sb = new StringBuilder();
		for (Stack<Character> characters : stackList) {
			if (!characters.isEmpty())
				sb.append(characters.peek());
		}
		return sb.toString();
	}

	public CrateStack copy() {
		CrateStack copy = new CrateStack();
		for (Stack<Character> characters : stackList) {
			Stack<Character> tempStack = new Stack<>();
			characters.forEach(tempStack::push);
			copy.stackList.add(tempStack);
		}
		return copy;
	}
}
