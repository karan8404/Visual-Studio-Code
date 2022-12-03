package playground;

import java.util.*;

class CountLetters {
    public static void main(String[] args) {
        // taking inputs and declaring objects.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string whose letters are to be counted");
        String s = sc.nextLine().toLowerCase();
        s = s.replaceAll(" ", "");// to remove all spaces in the string given.
        // declaring the HashMap.
        Map<Character, Integer> letterCount = new HashMap<>();

        letterCount = countLetters(s);
        // displaying the hashmap.
        System.out.println("Number of times each letter appreared:");
        for (Map.Entry<Character, Integer> pair : letterCount.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        sc.close();
    }

    // method to count the number of times each letter appears.
    public static Map<Character, Integer> countLetters(String s) {
        Map<Character, Integer> letterCount = new HashMap<>();
        char[] charArray = s.toCharArray();// character array storing characters of string s.
        Integer count;// contains the number of times the current character has appeared in string s.

        for (Character c : charArray) {
            count = letterCount.get(c);
            if (letterCount.containsKey(c)) {// increase count by one if letter present in map.
                letterCount.put(c, count + 1);
            }

            else {// make a new key:value pair if letter not present in map.
                letterCount.put(c, 1);
            }
        }

        return letterCount;
    }
}