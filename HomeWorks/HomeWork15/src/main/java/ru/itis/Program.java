package ru.itis;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static void spiralFill(int[][] anArray) {
        int horLength = anArray[0].length;
        int vertLength = anArray.length;
        int curColumn = 0;
        int curRow = 0;
        int curNumber = 1;
        /*
         * each iteration of while loop fills elements in the outer layer
         * of unfilled part of the array in specified order
         * until the unfilled part of the array
         * is one element wide or one element long
         * [1 ][2][3][4]
         * [12][ ][ ][5]
         * [11][ ][ ][6]
         * [10][9][8][7]
         */
        while (horLength > 1 && vertLength > 1) {
            //fills the top row
            int layerBoundary = curColumn + horLength;
            for (; curColumn < layerBoundary; curColumn++) {
                anArray[curRow][curColumn] = curNumber++;
            }
            curColumn--;
            //fills the rightmost column
            layerBoundary = curRow + vertLength;
            for (curRow++; curRow < layerBoundary; curRow++) {
                anArray[curRow][curColumn] = curNumber++;
            }
            curRow--;
            vertLength--;
            //fills the bottom row
            layerBoundary = curColumn - horLength;
            for (curColumn--; curColumn > layerBoundary; curColumn--) {
                anArray[curRow][curColumn] = curNumber++;
            }
            curColumn++;
            horLength -= 2;
            //fills the leftmost column
            layerBoundary = curRow - vertLength;
            for (curRow--; curRow > layerBoundary; curRow--) {
                anArray[curRow][curColumn] = curNumber++;
            }
            curRow++;
            vertLength--;
            curColumn++; //move on to the next layer
        }
        // fill the left-over elements
        if (vertLength == 1) {
            int layerBoundary = curColumn + horLength;
            for (; curColumn < layerBoundary; curColumn++) {
                anArray[curRow][curColumn] = curNumber++;
            }
        } else if (horLength == 1) {
            int layerBoundary = curRow + vertLength;
            for (; curRow < layerBoundary; curRow++) {
                anArray[curRow][curColumn] = curNumber++;
            }
        }
    }

    public static void fillAnArrayFromConsole(int[][] anArray) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < anArray.length; i++) {
            for (int j = 0; j < anArray[i].length; j++) {
                anArray[i][j] = scanner.nextInt();
            }
        }
    }

    public static void sortEveryRow(int[][] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            Arrays.sort(anArray[i]);
        }
    }

    public static int[][] sum(int a[][], int b[][]) {
        int[][] c = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public static int[][] sub(int a[][], int b[][]) {
        int[][] c = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    public static int[][] mult(int a[][], int b[][]) {
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void fillAboveMainDiagonalWithZeroes(int[][] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            for (int j = i + 1; j < anArray[i].length; j++) {
                anArray[i][j] = 0;
            }
        }
    }

    public static void fillBelowAntidiagonalwithOnes(int[][] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            for (int j = anArray.length - i; j < anArray[i].length; j++) {
                anArray[i][j] = 1;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] anArray = new int[scanner.nextInt()][scanner.nextInt()];
        switch (scanner.nextInt()) {
            case 1:
                spiralFill(anArray);
                for (int[] row : anArray) {
                    System.out.println(Arrays.toString(row));
                }
                break;
            case 2:
                fillAnArrayFromConsole(anArray);
                sortEveryRow(anArray);
                for (int[] row : anArray) {
                    System.out.println(Arrays.toString(row));
                }
                break;
            case 3:
                for (int[] row : anArray) {
                    Arrays.fill(row, -1);
                }
                fillAboveMainDiagonalWithZeroes(anArray);
                for (int[] row : anArray) {
                    System.out.println(Arrays.toString(row));
                }
                break;
            case 4:
                fillBelowAntidiagonalwithOnes(anArray);
                for (int[] row : anArray) {
                    System.out.println(Arrays.toString(row));
                }
                break;
            default:
                System.err.println("Invalid Input");
        }
    }
}
