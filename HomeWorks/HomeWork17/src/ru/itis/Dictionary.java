package ru.itis;

class Dictionary {
    private String[] elements;
    private int count;

    Dictionary() {
        elements = new String[0];
        count = 0;
    }

    Dictionary(String[] words) {
        this();
        ensureCapacity(words.length);
        count = words.length;
        for (int i = 0; i < words.length; i++) {
            elements[i] = words[i];
        }
        sort();
        removeDuplicates();
    }

    Dictionary(Dictionary anotherDictionary) {
        this();
        ensureCapacity(anotherDictionary.count);
        this.count = anotherDictionary.count;
        for (int i = 0; i < this.count; i++) {
            this.elements[i] = anotherDictionary.elements[i];
        }
    }

    /*
     *  checks that the underlying array can fit in n elements, if that's not
     *  the case creates a new array of n elements and copies all elements there
     */
    private void ensureCapacity(int n) {
        if (n > elements.length) {
            String[] newElements = new String[n];
            for (int i = 0; i < count; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    private void sort() {
        stringArraySort(elements);
    }

    // Bubble sort
    private void stringArraySort(String[] stringArray) {
        for (int i = stringArray.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (stringCompare(stringArray[j], stringArray[j - 1])) {
                    String tmp = stringArray[j];
                    stringArray[j] = stringArray[j - 1];
                    stringArray[j - 1] = tmp;
                }
            }
        }
    }

    //returns true if first is lexicographically smaller than second and false otherwise
    private static boolean stringCompare(String first, String second) {
        String shorterString = first.length() < second.length() ? first : second;
        for (int i = 0; i < shorterString.length(); i++) {
            if (first.charAt(i) > second.charAt(i)) {
                return false;
            } else if (first.charAt(i) < second.charAt(i)) {
                return true;
            }
        }
        return shorterString == first;
    }

    //removes duplicates from a sorted dictionary
    private void removeDuplicates() {
        int wordsRemoved = 0;
        for (int j = 1; j < count; j++) {
            if (elements[j].equals(elements[j - 1])) {
                wordsRemoved++;
            }
            elements[j - wordsRemoved] = elements[j];
        }
        count -= wordsRemoved;
    }

    public void mergeWith(Dictionary anotherDictionary) {
        String[] newElements = new String[this.count + anotherDictionary.count];
        int i = 0;
        int j = 0;
        int newCount = 0;
        while (i < this.count && j < anotherDictionary.count) {
            if (this.elements[i].equals(anotherDictionary.elements[j])) {
                newElements[newCount] = this.elements[i];
                i++;
                j++;
            } else if (stringCompare(this.elements[i], anotherDictionary.elements[j])) {
                newElements[newCount] = this.elements[i];
                i++;
            } else {
                newElements[newCount] = anotherDictionary.elements[j];
                j++;
            }
            newCount++;
        }
        for (; i < this.count; i++) {
            newElements[newCount++] = this.elements[i];
        }
        for (; j < anotherDictionary.count; j++, newCount++) {
            newElements[newCount++] = anotherDictionary.elements[j];
        }
        this.elements = newElements;
        this.count = newCount;
    }

    /*
     * returns the index of the word in dictionary if it's in the dictionary
     * and -1 otherwise
     */
    public int indexOf(String word) {
        int l = 0;
        int r = count;
        int answer = -1;
        while (l != r) {
            int m = l + (r - l) / 2;
            if (elements[m].equals(word)) {
                answer = m;
                l = r;
            } else if (stringCompare(word, elements[m])) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }

    /*
     * returns an array where the n-th element is the number of times
     * the n-th word of dictionary is encountered in words
     */
    public int[] countWordOccurrences(String[] words) {
        int[] numOfOccurrences = new int[count];
        for (int i = 0; i < words.length; i++) {
            int index = indexOf(words[i]);
            if (index != -1) {
                numOfOccurrences[index] += 1;
            }
        }
        return numOfOccurrences;
    }

}