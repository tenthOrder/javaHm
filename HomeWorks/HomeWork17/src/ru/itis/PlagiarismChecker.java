package ru.itis;

public class PlagiarismChecker {
    private String[] wordsFromFirstText;
    private String[] wordsFromSecondText;
    private double measure;
    private Dictionary dictionary;


    PlagiarismChecker(String firstText, String secondText) {
        wordsFromFirstText = firstText.split(" ");
        wordsFromSecondText = secondText.split(" ");
        cleanInput();
        dictionary = new Dictionary(wordsFromFirstText);
        dictionary.mergeWith(new Dictionary(wordsFromSecondText));
        IntVector firstTextVector =
                new IntVector(dictionary.countWordOccurrences(wordsFromFirstText));
        IntVector secondTextVector =
                new IntVector(dictionary.countWordOccurrences(wordsFromSecondText));
        measure = IntVector.cosBetween(firstTextVector, secondTextVector) * 100;
    }


    private void cleanInput() {
        for (int i = 0; i < wordsFromFirstText.length; i++) {
            wordsFromFirstText[i] =
                    toLowerCyrillic(removeNonCyrillicCharacters(wordsFromFirstText[i]));
        }
        for (int i = 0; i < wordsFromSecondText.length; i++) {
            wordsFromSecondText[i] =
                    toLowerCyrillic(removeNonCyrillicCharacters(wordsFromSecondText[i]));
        }
    }

    //leaves only cyrillic characters in string
    private String removeNonCyrillicCharacters(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char curChar = string.charAt(i);
            if ((curChar >= 'а' && curChar <= 'я')
                    || (curChar >= 'А' && curChar <= 'Я')
                    || (curChar == 'Ё') || (curChar == 'ё')) {
                stringBuilder.append(curChar);
            }
        }
        return stringBuilder.toString();
    }

    //toLower for a String consisting only of cyrillic characters
    private String toLowerCyrillic(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (curChar >= 'А' && curChar <= 'Я') {
                curChar += 0x20;
            } else if (curChar == 'Ё') {
                curChar = 'ё';
            }
            stringBuilder.append(curChar);
        }
        return stringBuilder.toString();
    }

    public double getMeasure() {
        return measure;
    }
}
