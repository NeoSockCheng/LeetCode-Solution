package Problems.Q0739_Daily_Temperatures;

import java.util.Stack;

// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int i = 0;
//         int[] result = new int[temperatures.length];
//         while (i < temperatures.length) {
//             int res = 0;
//             for (int j = i; j < temperatures.length; j++) {
//                 if (temperatures[j] > temperatures[i]) {
//                     res = j - i;
//                     break;
//                 }
//             }
//             result[i] = res;
//             i++;
//         }
//         return result;
//     }
// }

// question: given an array of temperature, return an array of number of days that each day need to wait until the temperature get warmer
// solution: initially, i use brute force which need to loop the array for each temperature until getting highter temp but exceed time limit
// better solution (or true solution): stack
// push index of temperature into stack, when the current temperature is higher, keep popping out the stack and update result
// need to imagine the solution in reverse order

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
