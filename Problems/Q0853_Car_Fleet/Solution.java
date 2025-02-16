package Problems.Q0853_Car_Fleet;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         if (position.length == 0) {
//             return 0;
//         }

//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < position.length; i++) {
//             map.put(position[i], speed[i]);
//         }
//         Arrays.sort(position);
//         Stack<Integer> stack = new Stack<>();

//         for (int i = 0; i < position.length; i++) {
//             int time = (target - position[i]) / map.get(position[i]);
//             stack.push(time);
//         }

//         int count = stack.pop();
//         int res = 1;
//         while (!stack.isEmpty()) {
//             if (stack.peek() > count) {
//                 count = stack.peek();
//                 res++;
//             }
//             stack.pop();
//         }

//         return res;

//     }
// }

// question: car with different position and speed provided, car where meet each other will form car fleet, rreturn number of car fleet
// solution: sort the car according to postion in descending order, together with its time
// if time>current time, means the car will be slower, so will form another fleet, fleetNum ++
// area improved, handle time using double, use treemap inseead of array
// a better way can be sort the position, storing time directly in stack, and compare them while popping


class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < pos.length; ++i) {
            m.put(pos[i], (double) (target - pos[i]) / speed[i]);
        }
        int res = 0;
        double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;

    }
}