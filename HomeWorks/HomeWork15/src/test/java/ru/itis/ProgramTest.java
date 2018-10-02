package ru.itis;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import static ru.itis.Program.*;

class ProgramTest {

    @Test
    public void spiralFill_SquareArrayWithOddSides_Fill() {
        int[][] anArray = new int[5][5];
        int[][] expected = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        spiralFill(anArray);

        assertTrue(Arrays.deepEquals(expected, anArray));
    }

    @Test
    public void spiralFill_SquareArrayWithEvenSides_Fill() {
        int[][] anArray = new int[4][4];
        int[][] expected = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        spiralFill(anArray);

        assertTrue(Arrays.deepEquals(expected, anArray));
    }

    @Test
    public void spiralFill_FirstSideIsLessThanSecondEvenSides_Fill() {
        int[][] anArray = new int[2][4];
        int[][] expected = {
                {1, 2, 3, 4},
                {8, 7, 6, 5}
        };

        spiralFill(anArray);

        assertTrue(Arrays.deepEquals(expected, anArray));
    }

    @Test
    public void spiralFill_FirstSideIsBiggerThanSecondOddSides_Fill() {
        int[][] anArray = new int[5][3];
        int[][] expected = {
                {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7}
        };

        spiralFill(anArray);

        assertTrue(Arrays.deepEquals(expected, anArray));
    }

    @Test
    public void sortEveryRow_RegularInput_Sort() {
        int[][] anArray = {
                {1, 2, 3, 4, 5},
                {0, 17, -214, 19, 6},
                {5, 224, 45, -1, 7},
                {14, 23, 22, 24, 8},
                {13, 12, 11, 10, 9}
        };
        int[][] expected = {
                {1, 2, 3, 4, 5},
                {-214, 0, 6, 17, 19},
                {-1, 5, 7, 45, 224},
                {8, 14, 22, 23, 24},
                {9, 10, 11, 12, 13}
        };

        sortEveryRow(anArray);

        assertTrue(Arrays.deepEquals(expected, anArray));
    }

    @Test
    public void sum_RegularInput_ReturnResult() {
        int[][] a = {
                {1, 2, 3},
                {0, 5, 6},
                {7, -48, 9}
        };
        int[][] b = {
                {9, 8, 7},
                {4, 5, 6},
                {0, 8, -124}
        };

        int[][] expected = {
                {10, 10, 10},
                {4, 10, 12},
                {7, -40, -115}
        };

        int[][] actual = sum(a, b);

        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void sub_RegularInput_ReturnResult() {
        int[][] a = {
                {1, 2, 3},
                {0, 5, 6},
                {7, -48, 9}
        };
        int[][] b = {
                {9, 8, 7},
                {4, 5, 6},
                {0, 8, -124}
        };

        int[][] expected = {
                {-8, -6, -4},
                {-4, 0, 0},
                {7, -56, 133}
        };

        int[][] actual = sub(a, b);

        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void mult_RegularInput_ReturnResult() {
        int[][] a = {
                {1, 5, -21, 25},
                {6, 2, 0, 7}
        };
        int[][] b = {
                {2, 4, 5},
                {24, 155, 6},
                {-10, 0, 2},
                {0, 43, 0}
        };

        int[][] expected = {
                {332, 1854, -7},
                {60, 635, 42}
        };

        int[][] actual = mult(a, b);

        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void fillAboveMainDiagonalWithZeroes_RegularInput_Fill() {
        int[][] anArray = {
                {1, 2, 3, 4, 5},
                {0, 17, -214, 19, 6},
                {5, 224, 45, -1, 7},
                {14, 23, 22, 24, 8},
                {13, 12, 11, 10, 9}
        };
        int[][] expected = {
                {1, 0, 0, 0, 0},
                {0, 17, 0, 0, 0},
                {5, 224, 45, 0, 0},
                {14, 23, 22, 24, 0},
                {13, 12, 11, 10, 9}
        };

        fillAboveMainDiagonalWithZeroes(anArray);

        assertTrue(Arrays.deepEquals(expected, anArray));
    }

    @Test
    public void fillBelowAntidiagonalwithOnes_RegularInput_Fill() {
        int[][] anArray = {
                {1, 2, 3, 4, 5},
                {0, 17, -214, 19, 6},
                {5, 224, 45, -1, 7},
                {14, 23, 22, 24, 8},
                {13, 12, 11, 10, 9}
        };
        int[][] expected = {
                {1, 2, 3, 4, 5},
                {0, 17, -214, 19, 1},
                {5, 224, 45, 1, 1},
                {14, 23, 1, 1, 1},
                {13, 1, 1, 1, 1}
        };

        fillBelowAntidiagonalwithOnes(anArray);

        assertTrue(Arrays.deepEquals(expected, anArray));
    }

}