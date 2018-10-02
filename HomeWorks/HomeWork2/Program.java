import java.util.Scanner;

public class Program {
	
	private static int digitSum(int number) {
		int digitSum = 0;
		while (number != 0) {
			digitSum += number % 10;
			number /= 10;
		}
		return digitSum;
	}
	
	public static void main(String[] args) {
		int multiple = 1;
		Scanner scanner = new Scanner(System.in);
		int curNumber = scanner.nextInt();
		while (curNumber != -1) {
			if (Program.digitSum(curNumber) % 2 != 0) {
				multiple *= curNumber;
			}
			curNumber = scanner.nextInt();
		}
		System.out.println(multiple);
	}
}