package OOP.Game;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;
    int currentTry;
    String computerWord;
    GameStatus gameStatus = GameStatus.INIT;
    Log log;

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        computerWord = generateWord();
        System.out.println("comp:  " + computerWord);
        this.gameStatus = GameStatus.START;
        this.currentTry = 0;
        log = new Log(System.getProperty("user.dir") + "\\", "log.txt");
        log.SetLog("НОВАЯ ИГРА " + getClassName());
        log.SetLog("Сгенерировано слово: " + computerWord + ". Число попыток " + maxTry);
    }

    public void restartGame() {
        log.SetLog("Перезапуск игры");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину слова и количество попыток: ");
        start(scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
    }

    @Override
    public Answer inputValue(String value) {
        if (currentTry >= maxTry) {
            gameStatus = GameStatus.FINISH;
            log.SetLog("FINISH по количеству попыток\n------------------------------");
            System.out.println("вы проиграли по количеству попыток");
            return null;
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == computerWord.charAt(i)) {
                bull++;
                cow++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cow++;
            }
        }
        currentTry++;
        Answer answer = new Answer(bull, cow, currentTry);
        log.SetLog(value, answer);
        if (sizeWord.equals(bull)) {
            gameStatus = GameStatus.FINISH;
            log.SetLog("FINISH ПОБЕДА\n------------------------------");
            System.out.println("вы Победили!!");
            return null;
        }
        return answer;
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    abstract List<String> generateCharList();

    abstract String getClassName();

    private String generateWord() {
        List<String> charList = generateCharList();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            result += charList.get(randomIndex);
            charList.remove(randomIndex);
        }
        return result;
    }

    public void readLog() throws FileNotFoundException {
        log.readLog();
    }
}
