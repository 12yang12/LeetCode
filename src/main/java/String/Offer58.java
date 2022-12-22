package String;

public class Offer58 {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        reverseString(stringBuilder, 0, n - 1);
        reverseString(stringBuilder, n, len - 1);
        return stringBuilder.reverse().toString();
    }

    private void reverseString(StringBuilder stringBuilder, int start, int end) {
        while (start < end) {
            char c = stringBuilder.charAt(start);
            stringBuilder.setCharAt(start, stringBuilder.charAt(end));
            stringBuilder.setCharAt(end, c);
            start++;
            end--;
        }
    }
}
