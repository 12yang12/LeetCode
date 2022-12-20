package String;

public class LC541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        // 每隔2k个反转前k个，尾数不够k个的时候全部反转
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            // 尾数够不够k个来取决end指针的位置
            while (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;

                start++;
                end--;
            }
        }
        return new String(chars);
    }

}
