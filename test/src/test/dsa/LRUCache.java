package test.dsa;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class LRUCache {
    static class Node {
        String key, value;
        Node prev, next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return  String.format("Node: %s | %s", this.key, this.value);
        }

    }

    private final int capacity;
    private final Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.head = new Node(null, null);
        this.tail = new Node(null, null);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public String get(String key) {
        if(!nodes.containsKey(key)) {
            return null;
        }
        Node node = nodes.get(key);
        update(node);
        return node.value;
    }

    public void put(String key, String value) {
        if(key == null || value == null) {
            throw new IllegalArgumentException("Key and Value can not be null");
        }
        if(nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.value = value;
            update(node);
        } else {
            Node node = new Node(key, value);
            if(nodes.size() >= this.capacity) {
                Node lastNode = this.tail.prev;
                delete(lastNode);
                nodes.remove(key);
            }
            nodes.put(key, node);
            add(node);
        }
    }

    private void delete(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void update(Node node) {
        delete(node);
        add(node);
    }

    private void add(Node node) {
        Node first = this.head.next;
        this.head.next = node;
        node.next = first;
        node.prev = this.head;
        first.prev = node;

    }

    public void print() {
        Node node = this.head;
        while(node.next != this.tail) {
            node = node.next;
            System.out.println(node.toString());
        }
    }

    private Map<String, Node> nodes = new HashMap<>();


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put("1", "a");
        cache.put("2", "b");
        cache.put("3", "c");
        cache.put("4", "d");
        System.out.println("Get: " + cache.get("1"));
        cache.put("5", "e");
        cache.put("6", "f");

        cache.print();
    }
}
