/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

//using xor method, 1ms
public class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums){
            num ^= i;

        }
        return num;
    }
}