package fu.infb;

import fu.infb.ueb08.Teilsumme;
import fu.infb.ueb08.Pi;
import fu.infb.ueb08.PufferTest;

public class Main {
	public static void main(String[] args) {
		uebung8aufgabe1();
		uebung8aufgabe2();
		uebung8aufgabe3();
	}

	private static void uebung8aufgabe3() {
		int[] test = new int[] { -3, 11, -4, 13, -5, 2 };
		int biggestPartialSum = new Teilsumme().biggestPartialSum(test);
		System.out.println(biggestPartialSum);
	}

	private static void uebung8aufgabe2() {
		System.out.printf("%-15s%-10s%n", "iterations", "result");
		for (int integer : new int[] { 100, 200, 1000, 10000, 500, 5 }) {
			double approximiere = new Pi().approximiere(integer);
			System.out.printf("%-15d%-10s%n", integer, approximiere);
		}

	}

	private static void uebung8aufgabe1() {
		PufferTest sI = new PufferTest();
		sI.generateString(200);
		sI.invertByString();
		sI.invertByStringBuilder();
		sI.invertByStringBuffer();
	}
}
