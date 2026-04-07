package test.dsa;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static long fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static long cachedFib(int n) {
        return cachedFib(n, new HashMap<Integer, Long>());
    }

    private static long cachedFib(int n, Map<Integer, Long> cache) {
        if (n <= 1) return n;
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long result = cachedFib(n - 1, cache) + cachedFib(n - 2, cache);
        cache.put(n, result);

        return result;
    }

    public static long iterativeFib(int n) {
        if(n <= 1) {
            return n;
        }

        long a = 0, b = 1;
        for(int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.print(iterativeFib(10));
    }
}
