package recursion;
public class StringPalindrome {
    // to find if a string is palindrome
    // video no #10.

    static boolean isPalin(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalin(s, left + 1, right - 1);
    }
}