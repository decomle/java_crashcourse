package test.dsa;

import java.util.Stack;

public class QueueWith2Stack {
    public static class MyQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void push(int val) {
            stack1.add(val);
        };
        public int pop() {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        };
        public int peek() {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        };
        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        };
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop()); // 1
        queue.push(5);
        System.out.println(queue.pop()); // 2
        System.out.println(queue.peek()); // 3
    }
}
