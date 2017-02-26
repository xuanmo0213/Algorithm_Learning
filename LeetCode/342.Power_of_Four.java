/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/

//My version use bit operator, 1ms
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num > 0 && (num&(num - 1)) == 0 && (num & 0x55555555) != 0){
            return true;
        }
        return false;
    }
}

//Other interesting version from discussion @yfcheng
public boolean isPowerOfFour(int num) {
    return Integer.toString(num, 4).matches("10*");
}
