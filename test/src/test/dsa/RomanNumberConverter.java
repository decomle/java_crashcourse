package test.dsa;

public class RomanNumberConverter {
    public static int romanNumberConverter(String str) {
        int total = 0, prevVal = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);

            int currentVal = getValue(c);
            if(currentVal < prevVal) {
                total = total - currentVal;
            } else {
                total = total + currentVal;
            }
            prevVal = currentVal;
        }

        return total;
    }

    public static int alternateSolution(String str) {
        char[] chars = str.toCharArray();
        int total = 0;

        for(int i = 0; i < chars.length; i++) {
            int left = getValue(chars[i]), right = 0;
            if(i + 1 < chars.length) {
                right = getValue(chars[i+1]);
                if(left < right) {
                    total = total + (right - left);
                    i++;
                } else {
                    total = total + left;
                }
            } else {
                total+=left;
            }
        }

        return total;
    }

    public static int getValue(char roman) {
        return switch (roman) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(alternateSolution("IX"));
        System.out.println(alternateSolution("MCMXCIV"));
    }
}
