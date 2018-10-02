public class Program {

	public static void main(String[] args) {
		int anArray[] = {23, 45, 12, 34, 67, 2, -5647, 0, -7, 7, 7};
		int numOfLocMax = 0;
		for (int i = 1; i < anArray.length - 1; i++) {
			if (anArray[i - 1] < anArray[i] && anArray[i + 1] < anArray[i]) {
				numOfLocMax++;
				i++;
			}
		}
		System.out.println(numOfLocMax);
	}
}
