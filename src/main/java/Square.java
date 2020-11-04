import java.sql.Array;
import java.sql.DatabaseMetaData;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Square {
    private double side = 0;  // LINE 2

    public static void main(String[] args){
        int[] nums = new int[] {2,1,4,2,3};
        System.out.println(Arrays.toString(nums));
        nums = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    //1) Решение выдает верный результат. Первый цикл по счетчику лучше заменить на for each, так можно меньше ошибиться. С помощью stream api можно написать решение в одну строчку, меньше символов - меньше вероятность ошибиться.

    public static int[] removeDuplicates(int[] a){
        return (Arrays.stream(a).distinct().peek((i) -> {if(i < 0) throw new RuntimeException();})).toArray();
    }
}



