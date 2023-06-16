import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введи целое число: ");
        int n = sc.nextInt();
        System.out.println("Сумма простых чисел до " + n + " равна " + sumPrimeNums(n));

        System.out.println("----".repeat(10));

        //Дана последовательность из N целых чисел. Верно ли, что последовательность является возрастающей.
        int[] ar = new int[25];

        for (int i=0; i < 25; i++) ar[i] = new Random().nextInt(-99, 99);
        System.out.println(ar.toString());

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

}
