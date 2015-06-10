package fu.infb.ueb08;

//Namen Martin Voges, Rico Kötschau, Sven Willrich (UE08)
public class Teilsumme {

	public static void main(String[] args) {
		try {
			if (args.length != 1 && Integer.valueOf(args[0]) > 0) {
				new IllegalArgumentException();
			}
			PufferTest sI = new PufferTest();
			sI.generateString(Integer.valueOf(args[0]));
			sI.invertByString();
			sI.invertByStringBuilder();
			sI.invertByStringBuffer();
		} catch (Exception e) {
			new Exception("wrong number of arguments or not an integer", e);
		}
	}

	// berechnet die größte Teilsumme für die angegebenen Daten
	public int biggestPartialSum(int[] data) {
		// Variablen zur Speicherung des aktuell höchsten Wertes
		// (biggestPartialSum) und zur Speicherung des Zählers (tmpSum)
		int biggestPartialSum = 0, tmpSum = 0;
		// Durchfläuft solange, bis das Array durchlaufen ist
		for (int i = 0; i < data.length; i++) {
			// wenn der Zähler (tmpSum) sowie die aktuelle Zahl größer als null
			// ist, passiere die Schleife, andernfalls setze tmpSum auf 0. Der
			// Teilstring kann nicht mit einer negativen Zahl anfangen.
			if (tmpSum + data[i] > 0) {
				// summiere dann jeweils die aktuelle Zahl hinzu
				tmpSum += data[i];
				// wenn die aktuelle Teilsumme größer ist als die bisher größte,
				// setze sie neu
				if (tmpSum > biggestPartialSum) {
					biggestPartialSum = tmpSum;
				}
			} else {
				tmpSum = 0;
			}

		}
		return biggestPartialSum;
	}
}
