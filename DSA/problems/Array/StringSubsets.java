package Array;
public class StringSubsets {

    static void findSubsets(String s, int i, String current) {
        if (i == s.length()) {
            System.out.println(current);
            return;
        }
        findSubsets(s, i + 1, current);
        findSubsets(s, i + 1, current + s.charAt(i));
    }

}
