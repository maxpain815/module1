public class Modulo {
    public static void main(String[] args) {
        int size = 100;
        System.out.println("размер массива: 100");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        for (int j = 2; j < arr.length; j++) {
            System.out.print("на "+j + " делятся без остатка: ");
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] > 9 && arr[i] < size) && arr[i] % j == 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
