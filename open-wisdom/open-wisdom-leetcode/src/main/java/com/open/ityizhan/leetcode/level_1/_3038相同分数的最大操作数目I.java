package com.open.ityizhan.leetcode.level_1;

/**
 * <pre>
 * 3038. 相同分数的最大操作数目 I
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：
 * 选择 nums 中的前两个元素并将它们删除。
 * 一次操作的 分数 是被删除元素的和。
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 *
 * 示例 1：
 * 输入：nums = [3,2,1,4,5]
 * 输出：2
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,4,5] 。
 * - 删除前两个元素，分数为 1 + 4 = 5 ，nums = [5] 。
 * 由于只剩下 1 个元素，我们无法继续进行任何操作。
 * 示例 2：
 *
 * 输入：nums = [3,2,6,1,4]
 * 输出：1
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * 由于下一次操作的分数与前一次不相等，我们无法继续进行任何操作。
 * </pre>
 */
public class _3038相同分数的最大操作数目I {


    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3, 2, 1, 4, 5}));
    }

    public static int maxOperations(int[] nums) {

        int sum = nums[0] + nums[1];
        int count = 1;
        for (int i = 2; i < nums.length - 1; i = i + 2) {

            if (sum == nums[i] + nums[i + 1]) {
                count++;
            } else {
                break;
            }

        }

        return count;
    }


}
