package com.open.ityizhan.wisdom.algorithm.select;

import java.util.Arrays;
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
public class DC {
    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
        System.out.println(sum(collect));
    }

    public static int sum(List<Integer> num) {
        if (num == null || num.size() == 0) {
            return 0;
        } else if (num.size() == 1) {
            return num.get(0);
        }
        return num.get(0) + sum(num.subList(1, num.size()));
    }
}
