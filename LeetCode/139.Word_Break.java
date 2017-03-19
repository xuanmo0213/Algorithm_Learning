/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

// 18 ms DP solution, bottom up
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0){
            return false;
        }
        int len = s.length();
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j <=i; j++){
                if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || flag[j - 1] )){
                    flag[i] = true;
                    break;
                }
                
            }
        }
        return flag[len - 1];
    }
}
