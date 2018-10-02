package ru.itis;

import java.util.Scanner;

public class Program {

    private static void A(int n, int cur) {
        if (cur > n) {
            return;
        }
        System.out.print(cur + " ");
        A(n, ++cur);
    }

    // prints numbers from 1 to n
    public static void A(int n) {
        A(n, 1);
    }

    private static void B(int last, int cur, boolean isAscending) {
        if ((isAscending && (cur > last)) || (!isAscending && (cur < last))) {
            return;
        }
        System.out.print(cur + " ");
        if (isAscending) {
            B(last, ++cur, isAscending);
        } else {
            B(last, --cur, isAscending);
        }

    }

    // prints numbers in [l, r]
    public static void B(int l, int r) {
        boolean isAscending = r > l;
        if (isAscending) {
            B(r, l, isAscending);
        } else {
            B(r, l, isAscending);
        }
    }

    // Ackermann function
    public static int C(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return C(m - 1, 1);
        } else {
            return C(m - 1, C(m, n - 1));
        }
    }

    // prints YES if n > 0 is a power of 2 and NO otherwise
    public static void D(int n) {
        if (n < 3) {
            if (n == 2) {
                System.out.print("YES");
            } else {
                System.out.print("NO");
            }
        } else {
            D(n / 2);
        }
    }

    private static int E(int n, int sum) {
        if (n == 0) {
            return sum;
        } else {
            return E(n / 10, sum + n % 10);
        }
    }

    //returns the sum of digits in n
    public static int E(int n) {
        return E(n, 0);
    }

    // prints digits of n in reverse order separated by spaces
    public static void F(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n % 10 + " ");
        F(n / 10);
    }

    private static int findDecMult(int n, int mult) {
        return n < 10 ? mult : findDecMult(n / 10, mult * 10);
    }

    private static int findNumOfTrailingZeroes(int n, int numOfTrailingZeroes) {
        return n % 10 == 0 ? findNumOfTrailingZeroes(n / 10, ++numOfTrailingZeroes)
                : numOfTrailingZeroes;
    }

    private static void G(int n, int mult, int numOfTrailingZeroes) {
        if (n == 0) {
            if (numOfTrailingZeroes != 0) {
                System.out.print("0 ");
                G(n, mult, --numOfTrailingZeroes);
            } else {
                return;
            }
        } else {
            System.out.print(n / mult + " ");
            G(n % mult, mult / 10, numOfTrailingZeroes);
        }
    }

    // prints digits of n separated by spaces
    public static void G(int n) {
        int mult = findDecMult(n, 1);
        int numOfTrailingZeroes = findNumOfTrailingZeroes(n, 0);
        G(n, mult, numOfTrailingZeroes);
    }

    private static void H(int n, int cur) {
        if (cur * cur > n) {
            System.out.print("YES");
            return;
        }
        if (n % cur == 0) {
            System.out.print("NO");
            return;
        }
        H(n, cur + 2);
    }


    // prints YES if n is a prime, and NO otherwise
    public static void H(int n) {
        if (n == 2) {
            System.out.print("YES");
            return;
        }
        if (n % 2 == 0) {
            System.out.print("NO");
            return;
        }
        H(n, 3);
    }

    private static void I(int n, int cur) {
        if (n == 1) {
            return;
        }
        if (n % cur == 0) {
            System.out.print(cur + " ");
            I(n / cur, cur);
            return;
        }
        I(n, cur + 2);
    }

    /*
     * prints out all prime divisors of n as many times as
     * n can be divided by them
     */
    public static void I(int n) {
        if (n % 2 == 0 && n != 0) {
            System.out.print("2 ");
            I(n / 2);
            return;
        }
        I(n, 3);
    }

    private static void J(char[] word, int cur) {
        if (cur > word.length / 2) {
            System.out.print("YES");
            return;
        }
        if (word[cur] != word[word.length - 1 - cur]) {
            System.out.print("NO");
            return;
        }
        J(word, ++cur);
    }

    // prints out YES if word is a palindrome and NO otherwise
    public static void J(char[] word) {
        J(word, 0);
    }


    private static void  K(Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            return;
        }
        if (num % 2 == 1) {
            System.out.println(num);
        }
        K(scanner);
    }
    // prints out all odd numbers from System.in until a 0 is encountered
    public static void K() {
        Scanner scanner = new Scanner(System.in);
        K(scanner);
    }

    /*
     * Prints out numbers from System.in, skipping every second one,
     * until a 0 is encountered
     */
    private static void L(Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            return;
        }
        System.out.println(num);
        if (scanner.nextInt() != 0) {
            L(scanner);
        }
    }

    public static void L() {
        Scanner scanner = new Scanner(System.in);
        L(scanner);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    /*
     * Reads positive integers from System.in until a 0 is encountered,
     * returns the maximum
     */
    private static int M(Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            return -1;
        }
        return max(num, M(scanner));
    }

    public static int M() {
        Scanner scanner = new Scanner(System.in);
        return M(scanner);
    }

    private static double N(int sum, int count, Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            return (double) sum / count;
        }
        return N(sum + num, ++count, scanner);
    }

    /*
     *Reads numbers from System.in until a 0 is encountered,
     * then returns the average
     */
    public static double N() {
        Scanner scanner = new Scanner(System.in);
        return N(0, 0, scanner);
    }

    private static int O(int max0, int max1, Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            return max1;
        }
        if (num > max0) {
            return O(num, max0, scanner);
        }
        if (num > max1) {
            return O(max0, num, scanner);
        }
        return O(max0, max1, scanner);
    }

    /*
     * Reads numbers from System.in until a 0 is encountered,
     * then returns the second largest number
     */
    public static int O() {
        Scanner scanner = new Scanner(System.in);
        return O(-1, -1, scanner);
    }

    private static int P(int max, int count, Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            return count;
        }
        if (num == max) {
            return P(max, ++count, scanner);
        }
        if (num > max) {
            return P(num, 1, scanner);
        }
        return P(max, count, scanner);
    }

    /*
     * Reads numbers(>0) from System.in until a 0 is encountered,
     * then returns number of elements = max
     */
    public static int P() {
        Scanner scanner = new Scanner(System.in);
        return P(-1, 0, scanner);
    }

    private static int Q(int count, boolean isTheLastNumberZero, Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            if (isTheLastNumberZero) {
                return count;
            } else {
                return Q(count, true, scanner);
            }
        }
        if (num == 1) {
            return Q(++count, false, scanner);
        }
        return Q(count, false, scanner);
    }

    /*
     * Reads numbers(>0) from System.in until two zeroes in a row are encountered,
     * then returns number of elements = 1
     */
    public static int Q() {
        Scanner scanner = new Scanner(System.in);
        return Q(0, false, scanner);
    }

    private static void R(int n, int total, int current, int curCount) {
        if (total == n) {
            return;
        }
        if (curCount == current) {
            System.out.print(current + 1 + " ");
            R(n, ++total, ++current, 1);
            return;
        }
        System.out.print(current + " ");
        R(n, ++total, current, ++curCount);
    }

    public static void R(int n) {
        R(n, 0, 1, 0);
    }


    public static int S(int len, int sum) {
        if (sum < 0) {
            return 0;
        }
        if (sum > 9 * len) {
            return 0;
        }
        if (len > 0 && sum == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += S(len - 1, sum - i);
        }
        return res;
    }


    public static int T(int numberOfZeroes, int numberOfOnes) {
        if (numberOfZeroes > numberOfOnes + 1) {
            return 0;
        }
        if (numberOfZeroes == 0) {
            return 1;
        }
        if (numberOfZeroes == 1 && numberOfOnes == 0) {
            return 1;
        }
        return T(numberOfZeroes - 1, numberOfOnes - 1) +
                T(numberOfZeroes, numberOfOnes - 1);
    }

    private static int U(int n, int answ) {
        return n < 10 ? answ + n : U(n / 10, (answ + n % 10) * 10);
    }

    public static int U(int n) {
        return U(n, 0);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                A(scanner.nextInt());
                break;
            case 2:
                B(scanner.nextInt(), scanner.nextInt());
                break;
            case 3:
                System.out.println(C(scanner.nextInt(), scanner.nextInt()));
                break;
            case 4:
                D(scanner.nextInt());
                break;
            case 5:
                System.out.println(E(scanner.nextInt()));
                break;
            case 6:
                F(scanner.nextInt());
                break;
            case 7:
                G(scanner.nextInt());
                break;
            case 8:
                H(scanner.nextInt());
                break;
            case 9:
                I(scanner.nextInt());
                break;
            case 10:
                scanner.skip("\n"); //skips the \n left untouched by scanner.nextInt()
                J(scanner.nextLine().toCharArray());
                break;
            case 11:
                K();
                break;
            case 12:
                L();
                break;
            case 13:
                System.out.println(M());
                break;
            case 14:
                System.out.println(N());
                break;
            case 15:
                System.out.println(O());
                break;
            case 16:
                System.out.println(P());
                break;
            case 17:
                System.out.println(Q());
                break;
            case 18:
                R(scanner.nextInt());
                break;
            case 19:
                //System.out.println(S(scanner.nextInt(), scanner.nextInt()));
                break;
            case 20:
                System.out.println(T(scanner.nextInt(), scanner.nextInt()));
                break;
            case 21:
                System.out.println(U(scanner.nextInt()));
                break;
            default:
                System.err.println("Invalid input");
                break;
        }
    }
}
