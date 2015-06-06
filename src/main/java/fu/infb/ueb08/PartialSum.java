package fu.infb.ueb08;

public class PartialSum {

	// berechnet die größte Teilsumme für die angegebenen Daten
	public static int biggestPartialSum(int[] data) {
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
