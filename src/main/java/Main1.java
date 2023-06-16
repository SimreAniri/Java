import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        {
            //Вычислить n-ое треугольное число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

            Scanner sc = new Scanner(System.in);
            System.out.print("Введите число: ");
            int n = sc.nextInt();

            int sum = 0;

            for (int i = 0; i <= n; i++) {
                sum += i;
            }

            System.out.println("Сумма чисел от 1 до " + n + " равна " + sum);

            System.out.println("----".repeat(10));
        }


        {
            // Вывести все простые числа от 1 до 1000

            ArrayList<Integer> primeNums = new ArrayList<>();

            for (int i = 2; i < 1000; i++) {
                boolean flag = true;

                for (int primeNum : primeNums) {

                    if (primeNum > Math.sqrt(i) + 1) break;

                    if (i % primeNum == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) primeNums.add(i);
            }
            primeNums.add(0, 1);

            System.out.println(primeNums);
            System.out.println("----".repeat(10));
        }

        {
            // Реализовать простой калькулятор

            Scanner sc = new Scanner(System.in);
            System.out.println("Калькулятор");
            System.out.print("Введите первое число: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.print("Какое действие будем делать: ");
            String action = sc.nextLine();

            System.out.print("Введите второе число: ");
            double num2 = Double.parseDouble(sc.nextLine());

            sc.close();

            System.out.println("Результат:");

            switch (action) {
                case "+":
                    System.out.println(num1 + num2);
                    break;

                case "-":
                    System.out.println(num1 - num2);
                    break;

                case "*":
                    System.out.println(num1 * num2);
                    break;

                case "/":
                    System.out.println(num1 / num2);
                    break;
            }
        }


        //Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        int i;
//
//        Random random = new Random();
//        i = random.nextInt(0, 2001);
//
//        System.out.println(i);
//
//        System.out.println("-----".repeat(10));

        // Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        int n;
//
//        n = Integer.toBinaryString(i).length();
//
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(n);
//
//        System.out.println("-----".repeat(10));

        // Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1

//        int[] m1 = new int[(Short.MAX_VALUE - i) /n + 1];
//
//        int k = 0;
//        int j = i;
//
//        while (j <= Short.MAX_VALUE){
//
//           if (j%n == 0){
//               m1[k] = j;
//               //System.out.println(k + " " + j);
//               k++;
//               j += n;
//           }
//           else j += 1;
//
//        }
//
//        System.out.println("-----".repeat(10));

        // Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

//        int[] m2 = new int[(-Short.MIN_VALUE + i) - (-Short.MIN_VALUE + i)/n + 2];
//
//        k = 0;
//        j = Short.MIN_VALUE;
//
//        while (j <= i){
//
//            if (j%n != 0){
//                m2[k] = j;
//                k++;
//            }
//
//            j += 1;
//
//        }


    }

}
