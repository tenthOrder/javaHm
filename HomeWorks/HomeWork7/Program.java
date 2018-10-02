public class Program {

	//returns 10 ** n, where n = number of digits in num
	private static int calcDecimalMultiplier(int num) {
		int result = 10;
		while (num >= 10) {
			num /= 10;
			result *= 10;
		}
		return result;
	}

	public static void main(String[] args) {
		int anArray[] = {13, 357, 0, 10, 1, 2};
		int result = 0;
		for (int i = 0; i < anArray.length; i++) {
			result *= Program.calcDecimalMultiplier(anArray[i]);
			result += anArray[i];
		}
		System.out.println(result);
	}
}
