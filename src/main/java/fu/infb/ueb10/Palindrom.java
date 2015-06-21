package fu.infb.ueb10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE10)
public class Palindrom {
	// Starts the program through main method. As input also test data
	// applicable, even use test() instead of args in for loop
	public static void main(String[] args) {
		// checks for each array entry whether it is a Polindrom
		for (String s : test()) {
			System.out.println(s + " ist" + (check(s) ? "" : " kein")
					+ " Polindrom");

		}
	}

	// checks for the test input whether the given input is a Polindrom
	private static boolean check(String s) {
		// focus is on kind of latter, without consider case-sensitivity
		s = s.toLowerCase();
		Queue<Character> queue = new LinkedList<Character>();
		// first store all chars in queue, then take out step-by-step
		for (char character : s.toCharArray()) {
			queue.add(character);
		}
		Stack<Character> stack = new Stack<Character>();
		// as long as size of queue is > 0, extract elements
		while (!queue.isEmpty()) {
			// first load the half of the given string in stack
			if (queue.size() > s.length() / 2) {
				stack.push(queue.poll());
				// if the size of the string is uneven, discard the
				// element who is in the middle of string - it has no relevance
				// for being a Polindrom
				if (s.length() % 2 != 0 && queue.size() == s.length() / 2) {
					stack.pop();
				}
				// in the second step, retrieve elements of stack step-by-step
				// and compare with the remaining queue elements. If there occur
				// differences, the string could could be a Palindrom
			} else {
				char first = queue.poll();
				char second = stack.pop();
				if (first != second) {
					return false;
				}
			}
		}
		return true;
	}

	// sample
	private static String[] test() {
		return new String[] { "Lagerregal", "helloworld", "isPolindrom",
				"Otto", "Rotor" };
	}
}
