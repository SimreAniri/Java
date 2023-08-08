package Base.E2;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        /*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
         Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        try {
            String temp = sc.nextLine();
            if (temp.equals("")) {
                throw new RuntimeException("Пустые строки вводить нельзя");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
