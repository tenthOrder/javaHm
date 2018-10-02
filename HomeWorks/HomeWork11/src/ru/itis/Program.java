package ru.itis;

public class Program {

    private static int parse(char[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            answer = answer * 10 + (number[i] - '0');
        }
        return answer;
    }

    public static void main(String[] args) {
        char anArray[] = {'0', '3', '5', '1', '7', '0', '2', '0'};
        System.out.println(parse(anArray));
    }
}
