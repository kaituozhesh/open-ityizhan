package com.open.ityizhan.wisdom.algorithm.基础;

/**
 * @Description:
 * @ClassName: 练习02_选择排序1
 * @Auther: lin
 * @Date: 2024/9/28 10:41
 * @Version: 1.0
 */
public class 练习02_选择排序1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 4};
        print(arr);
        selectSort(arr);
        print(arr);
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
