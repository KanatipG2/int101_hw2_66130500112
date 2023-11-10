package work01;

public class Utilitor {
    public static String testString(String value) {
        if (value == null) {
            throw new NullPointerException();
        } else if (value.equals("")) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public static double testPositive(double value) {
        if (value <=0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public static long computeIsbn10(long isbn10) {
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            int digit = String.valueOf(isbn10).charAt(i);
            sum+=(digit * (10-i));
        }
        return sum%11;
    }
}
