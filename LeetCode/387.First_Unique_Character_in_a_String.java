/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/
//My version using two pointers and index array, O(n) time, 34 ms
public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[256];
        int slow = 0, fast = 0;
        while(fast < s.length()){
            count[s.charAt(fast)]++;
            while (slow < s.length() && count[s.charAt(slow)] > 1){
                slow ++;
            }
            if (slow >= s.length()){
                return -1;
            }
            fast = Math.max(fast + 1, slow);
            
        }
        if (slow < s.length()){
            return slow;
        }
        return -1;
        
    }
}
