package com.open.ityizhan.wisdom.algorithm.select;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @ClassName: QuickSelect01
 * @Auther: lin
 * @Date: 2024/3/26 15:03
 * @Version: 1.0
 */
public class QuickSelect01 {
    public static void main(String[] args) {
        List<Integer> num = Stream.of(5, 7, 2, 10, 9).collect(Collectors.toList());
        quick(num, 0, num.size() -1);
        System.out.println(num);
    }

    public static void quick(List<Integer> num, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = left;
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (num.get(l).compareTo(num.get(p)) <= 0) {
                l++;
            } else if (num.get(l).compareTo(num.get(p)) > 0) {
                int temp = num.get(l);
                num.set(l, num.get(r));
                num.set(r, temp);
                r--;
            }
        }
        int temp = num.get(r);
        num.set(r, num.get(p));
        num.set(p, temp);

        quick(num, left, p - 1);
        quick(num, p + 1, right);

    }
}
