import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введи целое число: ");
        int n = sc.nextInt();
        System.out.println("Сумма простых чисел до " + n + " равна " + sumPrimeNums(n));

        System.out.println("----".repeat(10));

        int[] ar = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Arrays.toString(ar));
        System.out.println("Массив " + isRise(ar));
        System.out.println("----".repeat(10));

    }


    /**
     * @apiNote Дана последовательность n целых чисел. Найти сумму простых чисел.
     * @param n граница последовательности
     * @return сумма простых чисел
     */
    public static int sumPrimeNums(int n) {

        ArrayList<Integer> primeNums = new ArrayList<>();
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            boolean flag = true;

            for (int primeNum : primeNums) {
                if (primeNum > Math.sqrt(i) + 1) break;
                if (i % primeNum == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                primeNums.add(i);
                sum += i;
            }
        }
        primeNums.add(0, 1);
        sum += 1;

        return sum;
    }

    /**
     * @apiNote Дана последовательность из N целых чисел.
     * Верно ли, что последовательность является возрастающей.
     * @param ar массив
     * @return возрастает или нет
     */
    public static String isRise(int[] ar){
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i+1]) return "Не возрастает";
        }
        return "Возрастает";
    }
}
