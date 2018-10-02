public class Program {
	
	public static void main(String[] args) {
		int anArray[] = {2, 5, 10, 35, -245, 65, 32, 105, 3};
		/*for (int i = 0; i < anArray.length; i++) {
			System.out.print(anArray[i] + " ");
		}*/
		for (int i = 0; i < anArray.length / 2; i++ ) {
			int tmp = anArray[i];
			anArray[i] = anArray[anArray.length - 1 - i];
			anArray[anArray.length - 1 - i] = tmp;
		}
		System.out.println();
		/*for (int i = 0; i < anArray.length; i++) {
			System.out.print(anArray[i] + " ");
		}*/
	}
}