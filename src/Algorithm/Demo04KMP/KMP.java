package Algorithm.Demo04KMP;

public class KMP {
    public static void main(String[] args) throws Exception {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
    }

    //获取一个子串的部分匹配值
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        //如果字符串长度为1，部分匹配值一定为0
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i)！=dest.charAt(j)时，需要从next[j-1]获取新j
            //直到我们发现有条件满足时才退出
            //kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //当这个条件满足时，部分匹配值就是要加一
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    //写出kmp搜索算法

    /**
     * @param str1 原字符串
     * @param str2 子串
     * @param next 部分匹配表
     * @return 如果是-1就没有匹配到
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //考虑不相等的情况
            // kmp算法的核心点
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {//找到了
                return i - j + 1;
            }
        }
        return -1;
    }
}
