package com.open.ityizhan.wisdom.algorithm.基础;

/**
 * @Description: 1 + (1 * 2) + (1 * 2 * 3) + (1 * 2 * 3 * 4)
 * @ClassName: 练习01_阶乘
 * @Auther: lin
 * @Date: 2024/9/28 10:22
 * @Version: 1.0
 */
public class 练习01_阶乘 {

    public static void main(String[] args) {
        int N = 4;
        System.out.println(f1(N));
        System.out.println(f2(N));
    }

    public static long f2(int N) {
        int abs = 0;
        int temp = 1;
        for (int i = 1; i <= N; i++) {
            temp *= i;
            abs += temp;
        }
        return abs;
    }

    public static long f1(int N) {
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    public static long factorial(int N) {
        int ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        return ans;
    }

}
