public class Program {
	
	public static void main(String[] args) {
		int number = 212;
		String answer = new String();
		answer = number % 2 + answer;
		number /= 2;
		answer = number % 2 + answer;
		number /= 2;
		answer = number % 2 + answer;
		number /= 2;
		answer = number % 2 + answer;
		number /= 2;
		answer = number % 2 + answer;
		number /= 2;
		answer = number % 2 + answer;
		number /= 2;
		answer = number % 2 + answer;
		number /= 2;
		answer = number % 2 + answer;
		number /= 2;
		System.out.println(answer);
	}
}