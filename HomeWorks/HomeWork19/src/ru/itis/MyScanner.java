package ru.itis;

import java.io.IOException;
import java.io.InputStream;

public class MyScanner {
    private InputStream inputStream;

    public MyScanner(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String nextString() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int character = readNextNonWhitespaceCharacter();
        while (character != -1 && !Character.isWhitespace(character)) {
            stringBuilder.append((char) character);
            character = inputStream.read();
        }
        return stringBuilder.toString();
    }

    /*
     * keeps reading bytes from inputStream until a byte representing
     * a non-whitespace character is encountered then returns it
     */
    private int readNextNonWhitespaceCharacter() throws IOException {
        int character;
        do {
            character = inputStream.read();
        } while (character != -1 && Character.isWhitespace(character));
        return character;
    }

	//неверно, нужно переписать самому, не используя Integer.parseInt()
    public int nextInt() throws IOException {
        String intAsString = nextString();
        return Integer.parseInt(intAsString);
    }
	
	//неверно, нужно переписать самому, не используя Double.parseDouble()
    public double nextDouble() throws IOException {
        String doubleAsString = nextString();
        return Double.parseDouble(doubleAsString);
    }
}

