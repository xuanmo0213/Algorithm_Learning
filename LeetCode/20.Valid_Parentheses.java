/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

//My first version using stack, 9 ms
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c == '(' || c =='[' || c == '{'){
                stack.push(c);
            }
            else{
                if (stack.isEmpty() || !match(stack.pop(),c)){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
        
    }
    public boolean match(char a, char b){
        return (a == '(' && b ==')') || (a == '[' && b ==']') || (a == '{' && b =='}');
    }
}

//A more efficient one without compare function
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c == '(' ){
                stack.push(')');
            }
            else if (c == '['){
                stack.push(']');
            }
            else if (c == '{'){
                stack.push('}');
            }
            else{
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
        
    }
}
