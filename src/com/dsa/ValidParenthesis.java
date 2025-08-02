/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type
 */
package com.dsa;

public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println("Valid - " + isValidParenthesis(str));
    }

    public static boolean isValidParenthesis(String str) {
        if(str.isEmpty())
            return true;
        if(str.length() == 1)
            return false;
        char closingChar = findClosingCharacter(str.charAt(0));
        int count = 0, i;
        for(i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(0)) {
                count++;
            } else if(str.charAt(i) == closingChar) {
                if(count == 0)
                    break;
                count--;
            }
        }
        if(i == str.length())
            return false;
        if(i == 1)
            return isValidParenthesis(str.substring(i + 1));
        return isValidParenthesis(str.substring(1, i)) && isValidParenthesis(str.substring(i + 1));
    }

    public static Character findClosingCharacter(char ch) {
        if(ch == '[')
            return ']';
        else if(ch == '(')
            return ')';
        return '}';
    }
}
