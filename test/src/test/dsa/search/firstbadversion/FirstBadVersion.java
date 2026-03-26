package test.dsa.search.firstbadversion;

public class FirstBadVersion {
    public static int firstBadVersionBrute(int n) {
        for(int i = 1; i < n; i++) {
            if(FakeApi.isBadVersion(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left<right) {
            int mid = (int)(((long)left + right)/2);
            if(FakeApi.isBadVersion(mid)) {
               right = mid;
            } else {
                left = mid+1;
            }
        }
        if(!FakeApi.isBadVersion(left)) {
            return -1;
        }
        return left;
    }

    // May be failed when no bad version
    public static int firstBadVersionTest(int n) {
        int left = 1, right = n;
        while(left<right) {
            int mid = (int)(((long)left + right)/2);
            if(!FakeApi.isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersionTest(299));
    }
}
