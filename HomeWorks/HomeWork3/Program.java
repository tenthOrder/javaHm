public class Program {
	
	public static void main(String[] args) {
		int anArray[] = {2, 5, 10, 35, -245, 65, 32, 105};
		int sum = 0;
		for (int i = 0; i < anArray.length; i = i + 2) {
			sum += anArray[i];
		}
		System.out.println(sum);
	}
}