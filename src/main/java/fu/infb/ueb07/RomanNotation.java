package fu.infb.ueb07;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class RomanNotation {

	// Enth�lt die Notation der r�mischen Zahlen
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

	// konvertiert einen Integer in eine r�mische Zahl
	public static void convert(int integer) {
		int original = integer;
		// wenn die Zahl au�erhalb des zul�ssigen Ranges liegt, Fehlermeldung!
		if (integer < 1 || integer > 2015) {
			System.out
					.println("invalid year range, year must be within 1 and 2015");
			return;
		}
		// speichert die Zeichenkette, die die r�mische Zahl repr�sentiert
		String romanNumber = new String();

		// durchl�uft, solange integer gr��er als null ist
		while (integer > 0) {
			// durchl�uft die r�mischen Zahlen in fallender Reihenfolge, gr��er
			// Index zuerst, also das r�mische M, danach das D
			for (int i = signs.size() - 1; i >= 0; i--) {
				SimpleEntry<Integer, String> toCompare = signs.get(i);
				// ist wahr, wenn in absteigender Reihenfolge eine Zahl gefunden
				// wurde, die kleiner ist als "integer".
				if (integer >= toCompare.getKey()) {
					// subtraction rule
					// f�ngt die Zahl mit 9 an, wende Subtraktions-Regel an
					if (String.valueOf(integer).startsWith("9")
							&& i < signs.size() - 1) {
						romanNumber += signs.get(i - 1).getValue()
								+ signs.get(i + 1).getValue();
						integer -= signs.get(i + 1).getKey()
								- signs.get(i - 1).getKey();
						// f�ngt die Zahl mit 5 an, wende Subtraktions-Regel an
					} else if (String.valueOf(integer).startsWith("4")
							&& i < signs.size() - 1) {
						romanNumber += signs.get(i).getValue()
								+ signs.get(i + 1).getValue();
						integer -= signs.get(i + 1).getKey()
								- signs.get(i).getKey();
					} else {
						// f�ge das r�mische Zeichen hinzu
						romanNumber += toCompare.getValue();
						// reduziere "integer" um den Wert, der dem
						// hinzugef�gten r�mischen Zeichen entspricht
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
