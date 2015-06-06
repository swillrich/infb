package fu.infb.ueb08;

public class PartialSum {

	// berechnet die gr��te Teilsumme f�r die angegebenen Daten
	public static int biggestPartialSum(int[] data) {
		// Variablen zur Speicherung des aktuell h�chsten Wertes
		// (biggestPartialSum) und zur Speicherung des Z�hlers (tmpSum)
		int biggestPartialSum = 0, tmpSum = 0;
		// Durchfl�uft solange, bis das Array durchlaufen ist
		for (int i = 0; i < data.length; i++) {
			// wenn der Z�hler (tmpSum) sowie die aktuelle Zahl gr��er als null
			// ist, passiere die Schleife, andernfalls setze tmpSum auf 0. Der
			// Teilstring kann nicht mit einer negativen Zahl anfangen.
			if (tmpSum + data[i] > 0) {
				// summiere dann jeweils die aktuelle Zahl hinzu
				tmpSum += data[i];
				// wenn die aktuelle Teilsumme gr��er ist als die bisher gr��te,
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
