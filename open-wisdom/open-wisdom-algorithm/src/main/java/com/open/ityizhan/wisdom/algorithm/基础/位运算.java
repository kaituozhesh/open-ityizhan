package com.open.ityizhan.wisdom.algorithm.基础;

/**
 * @Description:
 * @ClassName: 位运算
 * @Auther: lin
 * @Date: 2024/9/26 21:40
 * @Version: 1.0
 */
public class 位运算 {

    public static void main(String[] args) {
        printBits(1);
        printBits(1 << 2);
        // 最高位为符号位、剩余为数值位
        // 负数：符号位为1，数值位为反码（每一位取反，最后加一）
        // 正数：符号位为0，数值位为原码
        printBits(Integer.MAX_VALUE);
        printBits(Integer.MIN_VALUE);
        // 11111111111111111111111111111111 : 最高位为1 所以是负数
        // 具体是负几: 所有位取反变成 00000000000000000000000000000000 在加一 00000000000000000000000000000001
        // 所以是一个负号(-)和1 所以是 -1
        printBits(-1);
        printBits(~-1);
        printBits(~-1 + 1);
    }

    public static void printBits(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
        System.out.println();
    }

}
