import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		int anArray[] = {-24, -3, 0, 2, 56, 1031, 35573};
		int l = 0;
		int r = anArray.length;
		int answer = -1;
		while (l != r) {
			int m = l + (r - l) / 2;
			if (anArray[m] == target) {
				answer = m;
				l = r;
			} else if (target < anArray[m]) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		if (answer == -1) {
			System.out.println("Number not found");
		} else {
			System.out.println(answer);
		}
	} 
}