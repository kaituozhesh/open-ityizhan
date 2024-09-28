package com.open.ityizhan.wisdom.algorithm.基础;

/**
 * @Description:
 * @ClassName: 练习03_冒泡排序
 * @Auther: lin
 * @Date: 2024/9/28 10:48
 * @Version: 1.0
 */
public class 练习04_插入排序 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 4};
        print(arr);
//        insertSort1(arr);
        insertSort2(arr);
        print(arr);
    }

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int pre = i - 1;
            int tmp = arr[i];
            for (; pre >= 0 && arr[pre] > tmp; pre--) {
                arr[pre + 1] = arr[pre];
            }
            arr[pre + 1] = tmp;
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
