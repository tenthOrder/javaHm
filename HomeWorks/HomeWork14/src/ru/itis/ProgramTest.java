package ru.itis;

import static org.junit.jupiter.api.Assertions.*;

import static ru.itis.Program.*;

import org.junit.jupiter.api.*;

import java.io.*;

public class ProgramTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;


    @BeforeEach
    public void setUpTestOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideTestInput(String input) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }


    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void A_RegularInput_PrintOutput() {
        final int param = 5;
        final String expectedOutput = "1 2 3 4 5 ";

        A(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void A_ParamEqualsOne_Print1() {
        final int param = 1;
        final String expectedOutput = "1 ";


        A(1);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void B_FirstParamLessThanSecond_PrintOutput() {
        final int firstParam = 15;
        final int secondParam = 25;
        final String expectedOutput =  "15 16 17 18 19 20 21 22 23 24 25 ";

        B(firstParam, secondParam);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void B_FirstParamBiggerThanSecond_PrintOutput() {
        final int firstParam = 5;
        final int secondParam = -3;
        final String expectedOutput = "5 4 3 2 1 0 -1 -2 -3 ";

        B(firstParam, secondParam);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void B_ParamsAreEqual_PrintParam() {
        final int firstParam = 1;
        final int secondParam = 1;
        final String expectedOutput = "1 ";

        B(firstParam, secondParam);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void C_RegularInput_Calculated() {
        final int firstParam = 3;
        final int secondParam = 5;
        final int expected = 253;

        int actual = C(firstParam, secondParam);

        assertEquals(expected, actual);
    }

    @Test
    public void C_FirstParamEqualToZero_ReturnSecondParamPlus1() {
        final int firstParam = 0;
        final int secondParam = 5;
        final int expected = secondParam + 1;

        int actual = C(firstParam, secondParam);

        assertEquals(expected, actual);
    }


    @Test
    public void D_ParamIsAPowerOf2_PrintYES() {
        final int param = 32;
        final String expectedOutput = "YES";

        D(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void D_ParamIsNotAPowerOf2_PrintNO() {
        final int param = 31;
        final String expectedOutput = "NO";

        D(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void D_ParamIsEqualTo1_PrintNO() {
        final int param = 1;
        final String expectedOutput = "NO";

        D(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void E_RegularInput_Calculated() {
        final int param = 2041;
        final int expected = 7;

        int actual = E(param);

        assertEquals(expected, actual);
    }

    @Test
    public void E_ParamIsEqualToZero_ReturnZero() {
        final int param = 0;
        final int expected = 0;

        int actual = E(param);

        assertEquals(expected, actual);
    }

    @Test
    public void F_RegularInput_PrintOutput() {
        final int param = 12454;
        final String expectedOutput = "4 5 4 2 1 ";

        F(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void F_ParamEndsOnZero_PrintOutput() {
        final int param = 124540;
        final String expectedOutput = "0 4 5 4 2 1 ";

        F(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void F_ParamHasAZeroInBetweenOtherDigits_PrintOutput() {
        final int param = 102422222;
        final String expectedOutput = "2 2 2 2 2 4 2 0 1 ";

        F(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void G_RegularInput_PrintOutput() {
        final int param = 124512444;
        final String expectedOutput = "1 2 4 5 1 2 4 4 4 ";

        G(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void G_ParamEndsZeroes_PrintOutput() {
        final int param = 124500;
        final String expectedOutput = "1 2 4 5 0 0 ";

        G(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void G_ParamHasAZeroInBetweenOtherDigits_PrintOutput() {
        final int param = 102422222;
        final String expectedOutput = "1 0 2 4 2 2 2 2 2 ";

        G(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void H_ParamIsPrime_PrintYES() {
        final int param = 13;
        final String expectedOutput = "YES";

        H(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void H_ParamIsNotPrime_PrintNO() {
        final int param = 130;
        final String expectedOutput = "NO";

        H(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void I_RegularInput_PrintOutput() {
        final int param = 1300;
        final String expectedOutput = "2 2 5 5 13 ";

        I(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void J_ParamIsAPalindrome_PrintYES() {
        final char param[] = {'a', 'b', 'c', 'b', 'a'};
        final String expectedOutput = "YES";

        J(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void J_ParamIsNotAPalindrome_PrintNO() {
        final char param[] = {'a', 'b', 'c', 'b'};
        final String expectedOutput = "NO";

        J(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void J_ParamIsOneCharacterLong_PrintYES() {
        final char param[] = {'a'};
        final String expectedOutput = "YES";

        J(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void K_RegularInput_PrintOutput() {
        final String testInput = "2\n4\n123\n1\n40\n0\n";
        provideTestInput(testInput);
        final String expectedOutput = "123\r\n1\r\n";

        K();

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void K_EmptySequence_DoNothing() {
        final String testInput = "0\n";
        provideTestInput(testInput);
        final String expectedOutput = "";

        K();

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void L_RegularInput_PrintOutput() {
        final String testInput = "1\n2\n3\n4\n5\n0\n";
        provideTestInput(testInput);
        final String expectedOutput = "1\r\n3\r\n5\r\n";

        L();

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void L_EmptySequence_DoNothing() {
        final String testInput = "0\n";
        provideTestInput(testInput);
        final String expectedOutput = "";

        L();

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void M_RegularInput_ReturnValue() {
        final String testInput = "10\n22\n13\n44\n5\n0\n";
        provideTestInput(testInput);
        final int expected = 44;

        int actual = M();

        assertEquals(expected, actual);
    }

    @Test
    public void N_RegularInput_ReturnValue() {
        final String testInput = "10\n22\n13\n44\n5\n0\n";
        provideTestInput(testInput);
        final double expected = 18.8;
        final double delta = 10e-12;

        double actual = N();

        assertEquals(expected, actual, delta);
    }

    @Test
    public void O_RegularInput_ReturnValue() {
        final String testInput = "10\n22\n13\n44\n5\n0\n";
        provideTestInput(testInput);
        final int expected = 22;

        int actual = O();

        assertEquals(expected, actual);
    }

    @Test
    public void O_MaximumNumbersAreEqual_ReturnValue() {
        final String testInput = "10\n22\n13\n22\n5\n0\n";
        provideTestInput(testInput);
        final int expected = 22;

        int actual = O();

        assertEquals(expected, actual);
    }

    @Test
    public void P_RegularInput_ReturnValue() {
        final String testInput = "10\n22\n13\n22\n44\n44\n5\n44\n0\n";
        provideTestInput(testInput);
        final int expected = 3;

        int actual = P();

        assertEquals(expected, actual);
    }

    @Test
    public void Q_RegularInput_ReturnValue() {
        final String testInput = "1\n22\n13\n1\n22\n44\n44\n5\n44\n0\n0";
        provideTestInput(testInput);
        final int expected = 2;

        int actual = Q();

        assertEquals(expected, actual);
    }

    @Test
    public void Q_InputSequenceContainsAZero_ReturnValue() {
        final String testInput = "1\n22\n0\n13\n1\n22\n44\n44\n5\n44\n0\n0";
        provideTestInput(testInput);
        final int expected = 2;

        int actual = Q();

        assertEquals(expected, actual);
    }

    @Test
    public void Q_InputContinuesAfterTwoZeroes_ReturnValue() {
        final String testInput = "1\n22\n13\n1\n22\n44\n44\n5\n44\n0\n0\n2\n1\n3";
        provideTestInput(testInput);
        final int expected = 2;

        int actual = Q();

        assertEquals(expected, actual);
    }

    @Test
    public void R_RegularInput_PrintOutput() {
        final int param = 8;
        final String expectedOutput = "1 2 2 3 3 3 4 4 ";

        R(param);

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void S_RegularInput_ReturnValue() {
        final int firstParam = 4;
        final int secondParam = 9;
        final int expected = 165;

        int actual = S(firstParam, secondParam);

        assertEquals(expected, actual);
    }

    @Test
    public void S_SumIsTooBig_ReturnZero() {
        final int firstParam = 3;
        final int secondParam = 28;
        final int expected = 0;

        int actual = S(firstParam, secondParam);

        assertEquals(expected, actual);
    }

    @Test
    public void T_RegularInput_ReturnValue() {
        final int firstParam = 4;
        final int secondParam = 6;
        final int expected = 35;

        int actual = T(firstParam, secondParam);

        assertEquals(expected, actual);
    }

    @Test
    public void T_TooManyZeroesForASequence_ReturnZero() {
            final int firstParam = 8;
        final int secondParam = 6;
        final int expected = 0;

        int actual = T(firstParam, secondParam);

        assertEquals(expected, actual);
    }

    @Test
    public void T_NoZeroes_ReturnOne() {
        final int firstParam = 0;
        final int secondParam = 6;
        final int expected = 1;

        int actual = T(firstParam, secondParam);

        assertEquals(expected, actual);
    }

    @Test
    public void T_ASingleZero_ReturnSecondParamPlus1() {
        final int firstParam = 1;
        final int secondParam = 6;
        final int expected = 7;

        int actual = T(firstParam, secondParam);

        assertEquals(expected, actual);
    }

    @Test
    public void U_RegularInput_ReturnValue() {
        final int param = 214151539;
        final int expected = 935151412;

        int actual = U(param);

        assertEquals(expected, actual);
    }

    @Test
    public void U_SingleDigitInput_ReturnValue() {
        final int param = 3;
        final int expected = 3;

        int actual = U(param);

        assertEquals(expected, actual);
    }
}