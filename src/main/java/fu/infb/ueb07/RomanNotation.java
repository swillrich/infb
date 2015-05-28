package fu.infb.ueb07;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class RomanNotation {

	// Enthält die Notation der römischen Zahlen
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

	// konvertiert einen Integer in eine römische Zahl
	public static void convert(int integer) {
		int original = integer;
		// wenn die Zahl außerhalb des zulässigen Ranges liegt, Fehlermeldung!
		if (integer < 1 || integer > 2015) {
			System.out
					.println("invalid year range, year must be within 1 and 2015");
			return;
		}
		// speichert die Zeichenkette, die die römische Zahl repräsentiert
		String romanNumber = new String();

		// durchläuft, solange integer größer als null ist
		while (integer > 0) {
			// durchläuft die römischen Zahlen in fallender Reihenfolge, größer
			// Index zuerst, also das römische M, danach das D
			for (int i = signs.size() - 1; i >= 0; i--) {
				SimpleEntry<Integer, String> toCompare = signs.get(i);
				// ist wahr, wenn in absteigender Reihenfolge eine Zahl gefunden
				// wurde, die kleiner ist als "integer".
				if (integer >= toCompare.getKey()) {
					// subtraction rule
					// fängt die Zahl mit 9 an, wende Subtraktions-Regel an
					if (String.valueOf(integer).startsWith("9")
							&& i < signs.size() - 1) {
						romanNumber += signs.get(i - 1).getValue()
								+ signs.get(i + 1).getValue();
						integer -= signs.get(i + 1).getKey()
								- signs.get(i - 1).getKey();
						// fängt die Zahl mit 5 an, wende Subtraktions-Regel an
					} else if (String.valueOf(integer).startsWith("4")
							&& i < signs.size() - 1) {
						romanNumber += signs.get(i).getValue()
								+ signs.get(i + 1).getValue();
						integer -= signs.get(i + 1).getKey()
								- signs.get(i).getKey();
					} else {
						// füge das römische Zeichen hinzu
						romanNumber += toCompare.getValue();
						// reduziere "integer" um den Wert, der dem
						// hinzugefügten römischen Zeichen entspricht
						integer -= toCompare.getKey();
					}
					break;
				}
			}
		}
		// gebe das Ergebnis aus
		System.out.println("roman number for " + original + " is:\t"
				+ romanNumber);
	}
}
