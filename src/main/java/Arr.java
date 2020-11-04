import java.util.Random;
import java.util.Scanner;

public class Arr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int[] arr = new int[in.nextInt()];
        Random random = new Random();
        for (int i=0;i<arr.length;i++){
            arr[i]= random.nextInt(90 )+10;
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i=0;i<arr.length/2;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i=arr.length-1;i>arr.length/2-1;i--){
            System.out.print(arr[i] + " ");
        }
    }
}
