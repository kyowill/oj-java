package com.oj;


import java.util.*;

class Solution {


    //target = sum / k
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums)sum += num;
        if(k <= 0 || sum%k != 0)return false;
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            visited[i] = false;
        }
        int target = sum / k;
        return dfs(nums, visited, 0, 0, 0, k, target);
    }

    boolean dfs(int[] nums, boolean[] visited, int start, int curSum, int curNum, int k, int target){
        if(k == 1) return true;
        if(curSum == target && curNum > 0){
            return dfs(nums, visited, 0, 0, 0, k-1, target);
        }
        for(int i = start; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(nums, visited, i + 1, curSum + nums[i], curNum + 1, k, target)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }


}
