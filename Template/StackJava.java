package Template;

import java.util.Stack;

public class StackJava {
    public static void main(String[] args) {
        // Create a Stack object
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);

        // Peek the top element of the stack
        int top = stack.peek();
        System.out.println(top);

        // Pop elements from the stack
        int popped = stack.pop();
        System.out.println(popped);

        // Check if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println(isEmpty);
    }
}

/*
 * Use case: recursion call, expression evaluation (prefix/postfix), undo operation, dfs
 * edge cases: stack overflow, peek()/pop() in empty stack trigger errors
 */

