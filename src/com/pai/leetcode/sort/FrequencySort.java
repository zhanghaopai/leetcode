package com.pai.leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @author: zhp
 * @date: 2022/4/5 17:40
 * @description: ${}
 * @version: 1.0
 */
public class FrequencySort {
    public String frequencySort(String s) {
        int[] feq = new int[256];
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            feq[charArray[i]]++;
        }
        StringBuilder sb = new StringBuilder();
        // 使用大顶堆，对频率进行排序
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return feq[o2]-feq[o1];
            }
        });
        for(int i = feq.length - 1; i>=0 ; i--) {
            pq.add(i);
        }
        // 取出元素
        while(!pq.isEmpty()){
            int index = pq.remove();
            while (--feq[index]>=0) {
                sb.append( (char) index);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySort fs = new FrequencySort();
        System.out.println(fs.frequencySort("tree"));

    }
}
