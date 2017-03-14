/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".	
*/

//My 5ms version
public class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j){
            while (i < c.length && !isVowel(c[i]) ){
                i++;
            }
            
            while (j >= 0 && !isVowel(c[j])){
                j--;
            }

            if (i < j){
                char temp = c[j];
                c[j] = c[i];
                c[i] = temp;
                i++;
                j--;
            }
        }
        return new String(c);
    }
    public boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

//use string to check vowels
public class Solution {
static final String vowels = "aeiouAEIOU";
public String reverseVowels(String s) {
    int first = 0, last = s.length() - 1;
    char[] array = s.toCharArray();
    while(first < last){
        while(first < last && vowels.indexOf(array[first]) == -1){
            first++;
        }
        while(first < last && vowels.indexOf(array[last]) == -1){
            last--;
        }
        char temp = array[first];
        array[first] = array[last];
        array[last] = temp;
        first++;
        last--;
    }
    return new String(array);
}
