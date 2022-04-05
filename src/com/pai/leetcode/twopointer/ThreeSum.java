package com.pai.leetcode.twopointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: zhp
 * @date: 2022/4/5 12:01
 * @description: ${}
 * @version: 1.0
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0 ; i < nums.length; i++) {
            while (i>0 && i<nums.length && nums[i]==nums[i-1]) {
                i++;
            }
            int first = nums[i];
            twoSum(result, nums, first, i+1);
        }
        return result;
    }

    public void twoSum(List<List<Integer>> result, int[] nums, int target, int start) {
        int end = nums.length-1;
        while(start<end) {
            int sum = nums[start] + nums[end];
            if(sum == -target) {
                // 压入结果
                List<Integer> temp = new LinkedList<>();
                temp.add(target);
                temp.add(nums[start]);
                temp.add(nums[end]);
                result.add(temp);
                // 寻找下一个
                start++;
                while(start<end && nums[start]==nums[start-1]) {
                    start++;
                }
                end--;
                while(start<end && nums[end]==nums[end+1]) {
                    end--;
                }
            } else if(sum > -target) {
                end--;
            } else if(sum<-target) {
                start++;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{0,0,0,0,0,0,0});
        lists.forEach(item->{
            item.forEach(System.out::print);
            System.out.println("---");
        });
    }
}
