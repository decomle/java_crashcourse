package test.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(200));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(8000));
    }
}
