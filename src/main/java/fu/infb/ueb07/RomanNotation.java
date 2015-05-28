package fu.infb.ueb07;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class RomanNotation {

	private static List<SimpleEntry<Integer, String>> signs = new ArrayList<SimpleEntry<Integer, String>>();

	static {
		signs.add(new SimpleEntry<Integer, String>(1, "I"));
		signs.add(new SimpleEntry<Integer, String>(5, "V"));
		signs.add(new SimpleEntry<Integer, String>(10, "X"));
		signs.add(new SimpleEntry<Integer, String>(50, "L"));
		signs.add(new SimpleEntry<Integer, String>(100, "C"));
		signs.add(new SimpleEntry<Integer, String>(500, "D"));
		signs.add(new SimpleEntry<Integer, String>(1000, "M"));
	}

	public static void convert(int integer) {
		int original = integer;
		if (integer < 1 || integer > 2015) {
			System.out
					.println("invalid year range, year must be within 1 and 2015");
			return;
		}

		String romanNumber = new String();

		while (integer > 0) {
			for (int i = signs.size() - 1; i >= 0; i--) {
				SimpleEntry<Integer, String> toCompare = signs.get(i);
				if (integer >= toCompare.getKey()) {
					// subtraction rule
					if (String.valueOf(integer).startsWith("9")
							&& i < signs.size() - 1) {
						romanNumber += signs.get(i - 1).getValue()
								+ signs.get(i + 1).getValue();
						integer -= signs.get(i + 1).getKey()
								- signs.get(i - 1).getKey();
					} else if (String.valueOf(integer).startsWith("4")
							&& i < signs.size() - 1) {
						romanNumber += signs.get(i).getValue()
								+ signs.get(i + 1).getValue();
						integer -= signs.get(i + 1).getKey()
								- signs.get(i).getKey();
					} else {
						romanNumber += toCompare.getValue();
						integer -= toCompare.getKey();
					}
					break;
				}
			}
		}
		System.out.println("roman number for " + original + " is:\t"
				+ romanNumber);
	}
}
