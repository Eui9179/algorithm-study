package y25.leetcode.week4;

class P443 {
    public static void main(String[] args) {
        char[] chars = {'a','b','c'};
        System.out.println(new P443().compress(chars));
        System.out.println(chars);
    }

    public int compress(char[] chars) {
        int p1 = 0;
        int p2 = 0;
        int write = 0;

        if (chars.length == 1) {
            return 1;
        }

        while (p2 < chars.length) {
            if (chars[p1] != chars[p2]) {
                chars[write++] = chars[p1];
                if (p2 - p1 > 1) {
                    for (char c : String.valueOf(p2 - p1).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                p1 = p2;
            }
            p2++;
        }

        if (p1 < p2) {
            if (p2 - p1 > 1) {
                chars[write++] = chars[p1];
                for (char c : String.valueOf(p2 - p1).toCharArray()) {
                    chars[write++] = c;
                }
            } else if (p2 - p1 == 1) {
                chars[write++] = chars[p1];
            }
        }

        return write;
    }

}
