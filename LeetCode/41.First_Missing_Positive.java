/*

*/
//My first version, hashset O(n) time O(n) space,13 ms
public class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> dict = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0 && nums[i] <= nums.length){
                dict.add(nums[i]);
            }
        }
        int i = 1;
        for (; i < nums.length + 1; i++){
            if (!dict.contains(i)){
                return i;
            }
        }
        return i;

    }
}

//swap version O(n) time O(1) space, 15ms
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0){
            return 1;
        }
        int i = 0;
        while (i < nums.length){
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length){
                i ++;
            }
            else if (nums[nums[i] - 1] != nums[i]){
                int j = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1){
            i++;
        }
        return i + 1;
    }
}
