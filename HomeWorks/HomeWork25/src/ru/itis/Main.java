package ru.itis;

import java.util.*;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {
        char[] charArray = {'a', 'b', 'c', 'd', 'e'};
        List<String> lst = Framework.getObjects(10, String.class, charArray, 1, 3);
        System.out.println(lst);

        List<String> lst1 = Framework.getObjects(1, String.class, Arrays.toString(charArray));
        System.out.println(lst1);
    }
}
