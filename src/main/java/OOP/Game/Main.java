package OOP.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вариант игры:");
        System.out.println("N - NumericGame");
        System.out.println("R - RusGame");
        System.out.println("E - EngGame");

        String gameVar = scanner.nextLine().toUpperCase();
        AbstractGame game;

        switch (gameVar){
            case "N":
                game = new NumberGame();
                System.out.println("Введите длину слова и количество попыток: ");
                game.start(scanner.nextInt(), scanner.nextInt());
                break;
            case "E":
                game = new EngGame();
                System.out.println("Введите длину слова и количество попыток: ");
                game.start(scanner.nextInt(), scanner.nextInt());
                break;
            case "R":
                game = new RusGame();
                System.out.println("Введите длину слова и количество попыток: ");
                game.start(scanner.nextInt(), scanner.nextInt());
                break;
            default:
                System.out.println("Выбран неверный вариант");
                game = null;
        }
        scanner.nextLine();

        while (!game.getGameStatus().equals(GameStatus.FINISH)){
            System.out.println("Какое слово я загадал? ");
            String value = scanner.nextLine();
            Answer answer = game.inputValue(value);
          if (answer!=null){
              System.out.println("answer = " + answer);
          }
        }
    }
}
