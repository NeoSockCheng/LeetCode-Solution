package Problems.Q0020_Valid_Parentheses;

import java.util.HashMap;
import java.util.Stack;

// class Solution {

//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (isOpenBracket(c)) {
//                 stack.push(c);
//             } else {
//                 if (stack.isEmpty()) {
//                     return false;
//                 }
//                 char b = stack.pop();
//                 if (!isMatch(c, b)) {
//                     return false;
//                 }
//             }
//         }
//         return stack.isEmpty();
//     }

//     public static boolean isOpenBracket(char c) {
//         return c == '(' || c == '[' || c == '{';
//     }

//     public static boolean isMatch(char c, char b) {
//         switch (b) {
//             case '(':
//                 return c == ')';
//             case '{':
//                 return c == '}';
//             case '[':
//                 return c == ']';
//             default:
//                 return false;
//         }
//     }
// }

// question: check is all the open and close brackets sequence and number match
// solution: use stack, optionally with mapping, if is open bracket then push, 
// if is close bracket then check if it match with the stack.pop()
// area improved: use mapping to fasten the matching process, and use toCharArray instead of charAt to fasten the code

class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c); // if c is open bracket
            } else if (map.containsKey(c)) {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}