package com.algoritmi.algoritmi_6;

import java.util.ArrayList;
import java.util.List;

public class RangeStringCreator {

    public static String createRangeString(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        List<String> result = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "-" + end);
                }
                start = end = nums[i];
            }
        }

        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "-" + end);
        }

        return String.join(",", result);
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 9, 11, 12};
        String rangeString = createRangeString(numbers);
        System.out.println(rangeString);
    }
}