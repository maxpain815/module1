package util;

public class DaysTest{

    static String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" };

    public static void main(String[] args) {

        int[][] twoD = { { 1, 2, 3} , { 4, 5, 6, 7}, { 8, 9, 10 } };

        int i1 = 1, i2 = 2, i3 = 3;
        int i4 = i1 + (i2=i3 );
        System.out.println(i4);
    }
}
