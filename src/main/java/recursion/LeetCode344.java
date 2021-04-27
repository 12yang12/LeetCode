package recursion;

public class LeetCode344 {

    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            if (s[i] != s[j]) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
            i++;
            j--;
        }
    }

    public void reverseString2(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        recuision(s, 0, s.length - 1);
    }

    private void recuision(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        recuision(s, left + 1, right - 1);
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

}
