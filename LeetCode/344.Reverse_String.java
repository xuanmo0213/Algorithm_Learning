/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

*/

//My version 2ms
public class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return new String(c);
    }
}
