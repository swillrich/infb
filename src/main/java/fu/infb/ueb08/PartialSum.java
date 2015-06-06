package fu.infb.ueb08;

public class PartialSum {

	public static int biggestPartialSum(int[] data) {
		int biggestPartialSum = 0, tmpSum = 0;
		for (int i = 0; i < data.length; i++) {
			if (tmpSum + data[i] > 0) {
				tmpSum += data[i];
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
