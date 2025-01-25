package Problems.Q0150_Evaluate_Reverse_Polish_Notation;

import java.util.HashMap;
import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("+", 0);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 3);

        for (String s : tokens) {
            if (map.containsKey(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = doOperation(map.get(s), num1, num2);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();

    }
    
    private static int doOperation(int operation, int num1, int num2){
        switch (operation) {
            case 0:
                return num2 + num1;
            case 1:
                return num2 - num1;
            case 2:
                return num2 * num1;
            case 3:
                return num2 / num1;   
        }
        return -1;
    }
}

//Question: given a mathematic equation in stack form, solve it
//solution, when it is number, push, when it is operand, pop two number and do operation