package com.open.ityizhan.leetcode.level_2;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYP ALIS HIRI NG" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：
 * PAHNAPLSIIGYIR
 * 请你实现这个将字符串进行指定行数变换的函数：
 */
public class _0006Z字形变换 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {

        String res = "";
        int step = numRows <= 2 ? numRows : numRows + numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j = j + step) {
                res += s.charAt(j);
                if (i != 0 && i != numRows - 1 && j + (step - 2 * i) < s.length()) {
                    res += s.charAt(j + (step - 2 * i));
                }
            }
        }

        return res;
    }
}