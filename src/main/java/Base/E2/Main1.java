package Base.E2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        float num = sayFloat();
        System.out.println("Вы ввели: " + num);
    }

    /**
     * @return число типа float
     * @apiNote Запрашивает у пользователя ввод дробного числа
     */
    static float sayFloat() {
        System.out.println("Введите число: ");
        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();
        float num;

        while (!temp.matches("[0-9]+[.]?[0-9]*")) {
            if (temp.matches("[0-9]+,?[0-9]*")) {
                System.out.println("Число должно быть записано через точку");
            } else {
                System.out.println("Введено не число");
            }
            System.out.println("Введите число: ");
            temp = sc.nextLine();
        }
        num = Float.parseFloat(temp);
        sc.close();

        return num;
    }
}
