package OOP.ToyGame;

import Base.E3.NotCorrectDataException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ToyPool {

    private HashMap<Toy, Integer> pool;
    private ArrayList<Double> chanceList;
    private ArrayList<Toy> toyList;
    private File file;

    public ToyPool(HashMap<Toy, Integer> pool) {
        this.pool = pool;
    }

    public ToyPool() {
        this.pool = new HashMap<>();
    }

    public void addToy(Toy toy, int count) {
        pool.put(toy, count);
    }

    public void addToys(String filePath) throws Exception {
        if (!filePath.toLowerCase().endsWith(".csv")) {
            throw new IllegalArgumentException("Не верный формат файла");
        }
        this.file = new File(filePath);
        Scanner sc = new Scanner(this.file);

        while (sc.hasNext()) {
            int id, count;
            String name;
            double chance;
            Toy toy;

            String[] line = sc.nextLine().split(";");
            if (line.length != 4) {
                throw new NotCorrectDataException("Ошибка в данных. В данных должно быть 4 поля");
            }
            if (!line[0].matches("\\d+")) {
                throw new NotCorrectDataException("Ошибка в данных");
            }
            id = Integer.parseInt(line[0]);
            if (!line[3].matches("\\d+")) {
                throw new NotCorrectDataException("Ошибка в данных");
            }
            count = Integer.parseInt(line[3]);
            if (line[2].matches("\\d+[.,]?\\d*")) {
                if (line[2].contains(",")) {
                    throw new NumberFormatException("Ошибка в данных. Числа должны быть записаны через точку");
                }
                chance = Double.parseDouble(line[2]);
            } else throw new NotCorrectDataException("Ошибка в данных");
            name = line[1];

            toy = new Toy(id, name, chance);
            addToy(toy, count);
        }
        sc.close();
    }

    public void setChancePool() {
        chanceList = new ArrayList<>();
        toyList = new ArrayList<>();
        int count = 0;

        for (var toy : pool.entrySet()) {
            double chanceFlag =toy.getKey().getProbability() * 10;
            if (count == 0) chanceList.add(chanceFlag);
            else chanceList.add(chanceList.get(count - 1) + chanceFlag);
            toyList.add(toy.getKey());
            count++;
        }
    }

    public int toysCount() {
        int count = 0;
        for (var toy : pool.entrySet()) {
            count += toy.getValue();
        }
        return count;
    }

    public double getMaxChanceRang() {
        return chanceList.get(chanceList.size() - 1);
    }

    public void delToy(Toy toy) {
        int index = toyList.indexOf(toy);
        pool.remove(toy);
        toyList.remove(index);
        chanceList.remove(index);
        for (int i = index; i < chanceList.size(); i++) {
            double temp = chanceList.get(i) - toy.getProbability();
            chanceList.set(i, temp);
        }
    }

    public void saveFile() throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (var toy : pool.entrySet()) {
            String s = toy.getKey().getId() + ";" + toy.getKey().getName()
                    + ";" + toy.getKey().getProbability() + ";" + pool.get(toy.getKey()) + ";";
            fileWriter.write(s);
            fileWriter.write("\n");
            fileWriter.flush();
        }
    }

    public HashMap<Toy, Integer> getPool() {
        return pool;
    }

    public ArrayList<Double> getChanceList() {
        return chanceList;
    }

    public ArrayList<Toy> getToyList() {
        return toyList;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "ToyPool{" +
                "pool=" + pool +
                '}';
    }
}
