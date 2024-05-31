package com.open.ityizhan.wisdom.algorithm.select;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @ClassName: DC
 * @Auther: lin
 * @Date: 2024/3/26 14:00
 * @Version: 1.0
 */
public class DC2 {
    public static void main(String[] args) {
        System.out.println(split(1680, 640));
    }

    public static int split(int c, int k) {
        if (c % k == 0) {
            return k;
        }
        return split(Math.max(c % k, k), Math.min(c % k, k));
    }
}
