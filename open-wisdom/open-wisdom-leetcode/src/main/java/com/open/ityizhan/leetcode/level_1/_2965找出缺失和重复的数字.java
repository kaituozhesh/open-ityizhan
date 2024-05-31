package com.open.ityizhan.leetcode.level_1;

/**
 * <pre class="code">
 * 2965. 找出缺失和重复的数字
 *
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 *
 * 示例 1：
 *  输入：grid = [[1,3],[2,2]]
 *  输出：[2,4]
 *  解释：数字 2 重复，数字 4 缺失，所以答案是 [2,4] 。
 *
 * 示例 2：
 *  输入：grid = [[9,1,7],[8,9,2],[3,4,6]]
 *  输出：[9,5]
 *  解释：数字 9 重复，数字 5 缺失，所以答案是 [9,5] 。
 *
 * 提示：
 *  2 <= n == grid.length == grid[i].length <= 50
 *  1 <= grid[i][j] <= n * n
 *  对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的任何成员都不相等。
 *  对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的两个成员相等。
 *  除上述的两个之外，对于所有满足1 <= x <= n * n 的 x ，都恰好存在一对 i, j 满足 0 <= i, j <= n - 1 且 grid[i][j] == x 。
 * </pre>
 */
public class _2965找出缺失和重复的数字 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] tmp = new int[h][w];

        int[] res = new int[2];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int d = grid[i][j];
                int jj = d % w == 0 ? w - 1 : d % w - 1;
                int ii = d % w == 0 ? d / w - 1 : d / w;
                if (tmp[ii][jj] == 0) {
                    tmp[ii][jj] = d;
                } else {
                    res[0] = d;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tmp[i][j] == 0) {
                    res[1] = i * h + j + 1;
                }
            }
        }

        return res;
    }
}