package Problems.Q0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            res.add(s);
        }
        if (left < n) {
            dfs(res, s + "(", left + 1, right, n);
        }
        if (right < left) {
            dfs(res, s + ")", left, right + 1, n);
        }
    }
}

// question: generate all possibility of combination of () given number of bracket
// solution: use dfs
// start from 1 (, if (<n, try adding more (
// if right < left, try adding more )