/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

*/

//My first 7ms solution
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String word ="";
        String[] words = s.split(" ");
        if (words.length > 1){
            word = words[words.length - 1];
        }
        else{
            word = s.trim();
        }
        return word.length();
    }
}

//Simple solution use higer level functions lastIndexOf() and trim(), 5ms
public class Solution {
    public int lengthOfLastWord(String s) {
	    s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;   
    }
}
