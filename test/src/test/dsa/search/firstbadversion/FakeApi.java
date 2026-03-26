package test.dsa.search.firstbadversion;

public class FakeApi {

    public static boolean isBadVersion(int version) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {}

        // Logic: versions starting from 300 are "bad"
        return version >= 300;
    }

    public static void main(String[] args) {
        System.out.println("Calling API...");

        long startTime = System.currentTimeMillis();
        boolean result = isBadVersion(300);
        long endTime = System.currentTimeMillis();

        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}