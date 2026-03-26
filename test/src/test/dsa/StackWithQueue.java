package test.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    public static class MyStack {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        public void push(int val) {
            if(queue1.isEmpty()) {
                queue1.add(val);
                while(!queue2.isEmpty()) {
                    queue1.add(queue2.poll());
                }
            } else if(queue2.isEmpty()) {
                queue2.add(val);
                while(!queue1.isEmpty()) {
                    queue2.add(queue1.poll());
                }
            }
        };
        public Integer pop() {
            if(!queue1.isEmpty()) {
                return queue1.poll();
            } else if(!queue2.isEmpty()){
                return queue2.poll();
            } else {
                return null;
            }
        };
        public Integer top() {
            if(!queue1.isEmpty()) {
                return queue1.peek();
            } else if(!queue2.isEmpty()){
                return queue2.peek();
            } else {
                return null;
            }
        };
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        };
    }

    public static class MyUpgradedStack {
        Queue<Integer> q1 = new LinkedList<>();
        // Can move the q2 to the push function
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int i) {
            q2.add(i);
            while(!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        };
        public Integer pop() {
            return q1.poll();
        }
        public Integer top() {
            return q1.peek();
        }
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static class OneQueueStack {
        Queue<Integer> queue = new LinkedList<>();
        public void push(int val) {
            queue.add(val);
            int count = 0;
            while(count < (queue.size() - 1)) {
                queue.add(queue.poll());
                count++;
            }

        };
        public Integer pop() {
            return queue.poll();
        }
        public Integer top() {
            return queue.peek();
        }
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        OneQueueStack stack = new OneQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop()); // 4
        System.out.println(stack.pop()); // 3

        stack.push(5);
        System.out.println(stack.top()); // 5
        System.out.println(stack.pop()); // 5
        System.out.println(stack.pop()); // 2
    }
}
