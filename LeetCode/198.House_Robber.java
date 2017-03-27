/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

//DP solution, O(n) time O(1) space, 1ms
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return  nums[0];
        }
        int sum_2 = nums[0];
        int sum_1 = Math.max(nums[1], sum_2);
        int max = Math.max(sum_1, sum_2);
        for (int i = 2; i < nums.length; i++){
            max = Math.max(sum_2 + nums[i], sum_1);
            sum_2 = sum_1;
            sum_1 = max;
        }
        return max;
    }
}
//More consice solution from discussion
public int rob(int[] num) {
    int prevNo = 0;
    int prevYes = 0;
    for (int n : num) {
        int temp = prevNo;
        prevNo = Math.max(prevNo, prevYes);
        prevYes = n + temp;
    }
    return Math.max(prevNo, prevYes);
}
