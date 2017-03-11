/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/


//My binary search version, 16ms
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int init = nums[0];
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (init <= target){
                if (nums[mid] >= init && target > nums[mid]){
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
            if (target < init){
                if (nums[mid] < init && target < nums[mid]){
                    end = mid;
                }
                else start = mid;
            }
            //System.out.println("start  " + nums[start]);
            
        }
        //System.out.println("start  " + nums[start]);
        //System.out.println("end  " + nums[end]);
        if (nums[start] == target){
            
            return start;
        }
            
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}

//Clean and optimized solution from discussion
public int search(int[] A, int target) {
    if (A.length == 0) return -1;
    int L = 0, R = A.length-1;
    //
    if (target < A[L] && target > A[R]) return -1;
    
    while (L < R) {
        int M = (L + R)/2;
        if (A[M] <= A[R]) {
            if (target > A[M] && target <= A[R]) {
                L = M+1;
            } else {
                R = M;
            }
            
        } else {
            if (target <= A[M] && target >= A[L]) {
                    R = M;
            } else {
                L = M+1;
            }
        }
    }
    if (A[L] == target) return L;
    else return -1;
}
