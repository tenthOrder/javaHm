package ru.itis;

import java.util.Scanner;

public class Program {

    private static int[] scanAnIntArray() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int anArray[] = new int[size];
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = scanner.nextInt();
        }
        return anArray;
    }

    private static int oddElementsSum(int[] anArray) {
        int sum = 0;
        for (int i = 0; i < anArray.length; i = i + 2) {
            sum += anArray[i];
        }
        return sum;
    }

    private static void printInReverseOrder(int[] anArray) {
        for (int i = anArray.length - 1; i > -1; i--) {
            System.out.print(anArray[i] + " ");
        }
        System.out.println();
    }

    private static void reverseOrder(int[] anArray) {
        for (int i = 0; i < anArray.length / 2; i++) {
            int tmp = anArray[i];
            anArray[i] = anArray[anArray.length - 1 - i];
            anArray[anArray.length - 1 - i] = tmp;
        }
    }

    private static int countLocalMaximums(int[] anArray) {
        int numOfLocMax = 0;
        for (int i = 1; i < anArray.length - 1; i++) {
            if (anArray[i - 1] < anArray[i] && anArray[i + 1] < anArray[i]) {
                numOfLocMax++;
                i++;
            }
        }
        return numOfLocMax;
    }

    //returns 10 ** n, where n = number of digits in num
    private static int calcDecimalMultiplier(int num) {
        int result = 10;
        while (num >= 10) {
            num /= 10;
            result *= 10;
        }
        return result;
    }

    private static int convertArrayToInt(int[] anArray) {
        int result = 0;
        for (int i = 0; i < anArray.length; i++) {
            result *= Program.calcDecimalMultiplier(anArray[i]);
            result += anArray[i];
        }
        return result;
    }

    private static int findElementInSortedArray(int target, int[] anArray) {
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
        return answer;
    }

    private static void bubbleSort(int[] anArray) {
        for (int i = anArray.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (anArray[j] < anArray[j - 1]) {
                    int tmp = anArray[j];
                    anArray[j] = anArray[j - 1];
                    anArray[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int anArray[] = new int[10];
        while (true) {
            System.out.println("МЕНЮ");
            System.out.println("1. Ввести массив");
            System.out.println("2. Посчитать сумму элементов на нечётных позициях");
            System.out.println("3. Вывести массив в обратном порядке");
            System.out.println("4. Перевернуть массив");
            System.out.println("5. Посчитать количество локальных максимумов");
            System.out.println("6. Перевести массив в число");
            System.out.println("7. Найти индекс элемента в отсортированном массиве");
            System.out.println("8. Отсортировать массив");
            System.out.println("9. Завершить исполнение программы");
            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    anArray = scanAnIntArray();
                    break;
                case 2:
                    System.out.println(oddElementsSum(anArray));
                    break;
                case 3:
                    printInReverseOrder(anArray);
                    break;
                case 4:
                    reverseOrder(anArray);
                    break;
                case 5:
                    System.out.println(countLocalMaximums(anArray));
                    break;
                case 6:
                    System.out.println(convertArrayToInt(anArray));
                    break;
                case 7:
                    int target = scanner.nextInt();
                    System.out.println(findElementInSortedArray(target, anArray));
                    break;
                case 8:
                    bubbleSort(anArray);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Такой команды не существует");
                    break;
            }
        }
    }
}

