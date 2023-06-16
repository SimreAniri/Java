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

        int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Arrays.toString(ar));
        System.out.println("Массив " + isRise(ar));
        System.out.println("----".repeat(10));

        int[] ar2 = new int[15];
        for (int i = 0; i < 15; i++) {
            ar2[i] = new Random().nextInt(-199, 199);
        }

        System.out.println(Arrays.toString(ar2));

        System.out.println(Arrays.toString(negToSumInd(ar2)));
        System.out.println("----".repeat(10));

        Character[][] sudokuArr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        for (Character[] ar3 : sudokuArr) {
            System.out.println(Arrays.toString(ar3));
        }

        System.out.println("Валидация: " + isValidSudoku(sudokuArr));

    }


    /**
     * @param n граница последовательности
     * @return сумма простых чисел
     * @apiNote Дана последовательность n целых чисел. Найти сумму простых чисел.
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
     * @param ar массив
     * @return возрастает или нет
     * @apiNote Дана последовательность из N целых чисел.
     * Верно ли, что последовательность является возрастающей.
     */
    public static String isRise(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) return "Не возрастает";
        }
        return "Возрастает";
    }

    /**
     * @param array массив целых чисел
     * @return массив
     * @apiNote Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных
     * элементов массива.
     */
    public static int[] negToSumInd(int[] array) {
        ArrayList<Integer> indList = new ArrayList<>();
        int sumInd = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) indList.add(i);
            if (array[i] / 10 != 0 && array[i] / 10 < 10 && array[i] / 10 > -10) sumInd += i;
        }

        for (int i : indList) {
            array[i] = sumInd;
        }
        return array;
    }

    /**
     * @param ar матрица судоку
     * @return true/false
     * @apiNote Проверка размера сетки матрицы
     */
    public static boolean chekSize(Character[][] ar) {

        if (ar.length != 9) return false;

        for (Character[] arLine : ar) {
            if (arLine.length != 9) return false;
        }

        return true;
    }


    /**
     * @param ar матрица судоку
     * @return true/false
     * @apiNote Проверка правильности заполнения символами
     */
    public static boolean chekNum(Character[][] ar) {
        String standart = ".123456789";

        for (Character[] arLine : ar) {
            for (Character s : arLine) {
                if (!standart.contains(Character.toString(s))) return false;
            }
        }
        return true;
    }


    /**
     * @param ar матрица судоку
     * @return true/false
     * @apiNote Проверка отсутствия повторений
     */
    public static boolean chekRep(Character[][] ar) {
        for (Character[] arLine : ar) { // проверка по строкам
            String chekStr = "";
            for (Character s : arLine) {
                if (s != '.' && !chekStr.contains(Character.toString(s))) chekStr += s;

                else if (chekStr.contains(Character.toString(s))) return false;
            }
        }

        for (int i = 0; i < 9; i++) { // проверка по столбцам
            String chekStr = "";
            for (int j = 0; j < 9; j++) {
                if (ar[j][i] != '.' && !chekStr.contains(Character.toString(ar[j][i]))) chekStr += ar[j][i];
                else if (chekStr.contains(Character.toString(ar[j][i]))) return false;
            }

        }

        for (int i = 0; i < 9; i += 3) { // проверка по блокам
            for (int j = 0; j < 9; j += 3) {
                String chekStr = "";
                for (int k = i; k < i + 3; k++) {
                    for (int d = j; d < j + 3; d++) {
                        if (ar[k][d] != '.' && !chekStr.contains(Character.toString(ar[k][d]))) {
                            chekStr += ar[k][d];
                        } else if (chekStr.contains(Character.toString(ar[k][d]))) {
                            System.out.println(k + " " + d);
                            System.out.println(ar[k][d]);
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    /**
     * @param ar матрица судоку
     * @return true/false
     * @apiNote Проверка судоку на корректность
     */
    public static boolean isValidSudoku(Character[][] ar) {
        if (chekSize(ar) && chekNum(ar) && chekRep(ar)) return true;
        else return false;
    }
}
