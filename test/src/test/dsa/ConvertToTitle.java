package test.dsa;

// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet
// 1 -> A, 27 -> AA, 28-> AB, etc...
public class ConvertToTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;

            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {

        System.out.println(convertToTitle(1001)); // ALM
    }
}
