package com.pai.leetcode.sort;

import java.util.*;

/*
 * @author: zhp
 * @date: 2022/4/5 13:27
 * @description: ${}
 * @version: 1.0
 */
public class TopKFrequent {
    /*
    *    桶排序法
    *   1. 遍历nums，数字对应下标，值对应频率
    *   2. 遍历频率表，下标代表频率，值代表数字。
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            maps.put(nums[i], maps.getOrDefault(nums[i], 0)+1);
        }
        // 维护一个小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return maps.get(o1) - maps.get(o2);
            }
        });
        maps.keySet().forEach(item->{
            if (pq.size()<k) {
                pq.add(item);
            } else if(maps.get(item) >maps.get(pq.peek())) {
                pq.remove();
                pq.add(item);
            }
        });
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
