/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

*/

//My first version, 7ms
public class Solution {
    public String reverseStr(String s, int k) {
        if (s.length() <= 1 || k < 2){
            return s;
        }
        char[] c = s.toCharArray();
        int count = 0;
        while (2 * k * count < c.length){
            int i = 2 * k * count;
            int j = (2 * count + 1) * k - 1 > c.length - 1 ? c.length - 1 : (2 * count + 1) * k - 1;
            inverse(c, i, j);
            count ++;
        }
        return new String(c);
        
    }
    public void inverse(char[] c, int i, int j){
        while (i < j){
            char temp = c[j];
            c[j] = c[i];
            c[i] = temp;
            i++;
            j--;
        }
        return;
    }
}
