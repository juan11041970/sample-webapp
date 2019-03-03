package com.jda.sort;

public class NumberSort {

    public static void main(String ... args) {

        int[] nums = {7,2,9, 8, 4, 3, 10};
        bubbleSort(nums);
    }

    private static void bubbleSort(int[] nums) {

        //7,2,9, 8, 4, 3

        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < (nums.length - 1); j++) {

                if (nums[j-1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1]  = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int y = 0; y < nums.length; y++) {

            System.out.println(nums[y]);
        }
    }
}
