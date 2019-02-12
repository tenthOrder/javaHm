package ru.itis;

import java.util.Random;

public class Main {

    public static String generateRandomString() {
        final int MAX_STRING_LENGTH = 100;
        Random random = new Random();
        int length = random.nextInt(MAX_STRING_LENGTH) + 1;
        StringBuilder stringBuilder = new StringBuilder(length);
        int[] chars = random.ints(length, '!', Character.MAX_VALUE).toArray();
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) chars[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] randomStrings = new String[100];
        Map<String, Integer> map = new Map<>();
        for (int i = 0; i < randomStrings.length; i++) {
            randomStrings[i] = generateRandomString();
            map.put(randomStrings[i], 0);
        }
        System.out.println(map.getCollisionCount());
        map.put(randomStrings[40], 1);
        System.out.println(map.get(randomStrings[40]));
    }
}
