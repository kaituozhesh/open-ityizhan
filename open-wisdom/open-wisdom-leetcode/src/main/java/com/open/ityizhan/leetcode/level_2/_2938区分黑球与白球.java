package com.open.ityizhan.leetcode.level_2;

/**
 * <pre>
 *     2938. 区分黑球与白球
 * 桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
 * 给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
 * 在每一步中，你可以选择两个相邻的球并交换它们。
 * 返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
 *
 * 示例 1：
 * 输入：s = "101"
 * 输出：1
 * 解释：我们可以按以下方式将所有黑色球移到右侧：
 *  - 交换 s[0] 和 s[1]，s = "011"。
 *  最开始，1 没有都在右侧，需要至少 1 步将其移到右侧。
 *
 * 示例 2：
 * 输入：s = "100"
 * 输出：2
 * 解释：我们可以按以下方式将所有黑色球移到右侧：
 * - 交换 s[0] 和 s[1]，s = "010"。
 * - 交换 s[1] 和 s[2]，s = "001"。
 * 可以证明所需的最小步数为 2 。
 * </pre>
 */
class _2938区分黑球与白球 {

    public static void main(String[] args) {
        System.out.println(minimumSteps3("111111111100100010"));
    }

    public static long minimumSteps(String s) {

        char[] chars = s.toCharArray();
        int l = 0;
        int len = chars.length;
        int step = 0;
        while (l < len && chars[l] == '0') {
            l++;
        }
        int r = l + 1;

        boolean black = false;
        while (r < len) {
            // 1000111
            black = false;
            for (; r < len; r++) {
                // 再次之前遇到过黑色的
                if (black) {
                    if (chars[r] == '0') { // 1111110
                        chars[r] = '1';
                        chars[l] = '0';
                        step += r - l;
                        r++;
                        l++;
                        break;
                    }
                } else {
                    if (l != r - 1 && chars[r] == '1') {  // 10000001
//                    if (chars[r] == '1') {  // 10000001
                        int tmp = r;
                        while (l < tmp && chars[tmp - 1] == '0' && chars[l] == '1') {
                            chars[tmp - 1] = '1';
                            chars[l] = '0';
                            step += tmp - 1 - l;
                            tmp--;
                            l++;
                        }
//                        chars[r - 1] = '1';
//                        chars[l] = '0';
//                        step += r - 1 - l;
                        r++;
                        l = tmp;
                        black = true;
                        break;
                    }
                }
                if (chars[r] == '1') {
                    black = true;
                }
            }
        }
        if (!black) {
            step += r - 1 - l;
        }

        return step;
    }

    public static long minimumSteps2(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        int step = 0;
        int i = 0;
        int j = 0;

        // 第一个1
        while (j < len && chars[j] == '0') {
            j++;
        }
        while (j < len) {
            i = j;
            // 第一个0
            while (i < len && chars[i] == '1') {
                i++;
            }
            if (i < len) {
                chars[i] = '1';
            }
            step += i - j;
            j++;
        }

        return step;
    }

    public static long minimumSteps3(String s) {
        long ans = 0;
        int sum = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                sum++;
            } else {
                ans += sum;
            }
        }
        return ans;
    }
    // 01 11 11 11 11 1 0100010
}