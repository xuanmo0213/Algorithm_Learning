/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


*/
// My binary sort solution, since use sort, it could be larger than O(n)
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == mid){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        if (nums[start] != start){
            return start;
        }
        if (nums[end] != end){
            return end;
        }
        return end + 1;
    }
}

//Another solution using XOR idea and O(n) time and O(1) space.
public int missingNumber(int[] nums) { //xor
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
    }
    return res;
}
