package OOP.ToyGame;

import java.util.Random;

public class Game {
    private ToyPool pool;
    private int playerCount;

    public Game(ToyPool pool, int playerCount) {
        this.pool = pool;
        this.playerCount = playerCount;
        this.pool.setChancePool();
    }

    private void hi() {
        System.out.println("Приветствую!");
        System.out.println("Игрушек участвует в игре: " + this.pool.toysCount());
        System.out.println("Среди них: " + this.pool.getToyList());
    }

    private Toy getWin() {
        Toy winToy = null;
        double maxChance = pool.getMaxChanceRang();
        int goal = new Random().nextInt(1, (int) maxChance);
        for (int i = 0; i < pool.getChanceList().size(); i++) {
            if (goal <= pool.getChanceList().get(i)) {
                winToy = pool.getToyList().get(i);
                return winToy;
            }
        }
        return winToy;
    }

    private Toy[] getWins() {
        Toy[] winsToys = new Toy[playerCount];
        for (int i = 0; i < playerCount; i++) {
            winsToys[i] = getWin();
            System.out.println(i + 1 + "-й игрок выиграл: " + winsToys[i].getName());
            pool.getPool().put(winsToys[i], pool.getPool().get(winsToys[i]) - 1);
            if (pool.getPool().get(winsToys[i]) == 0) {
                pool.delToy(winsToys[i]);
            }
        }
        return winsToys;
    }

    public ToyPool start() {
        if (playerCount > pool.toysCount()) {
            System.out.println("Призов меньше, чем участников");
        } else {
            hi();
            System.out.println("Начинаем игру");
            try {
                getWins();
                pool.saveFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Файл обновлен");
        }

        return pool;
    }
}
