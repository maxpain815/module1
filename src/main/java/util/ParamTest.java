package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParamTest {

    public static void printSum(Integer a, Integer b){
        System.out.println("In Integer "+(a+b));
    }

    public static void printSum(double a, double b){
        System.out.println("In double "+(a+b));
    }

    public static void main(String[] args) {
        int i = 4;
        int ia[][][] = new int[i][i = 3][i];
        System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);
    }
}
