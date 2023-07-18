package OOP.Game;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Log {
    private FileWriter f;
    private String file;

    public Log(String dir, String name) {
        this.file = dir + name;
        try {
            f = new FileWriter(file, true);
            f.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SetLog(String s, Answer answer) {
        try {
            f = new FileWriter(file, true);
            f.write(new Date().toString() + ": " + s + " " + answer.toString() + "\n");
            f.flush();
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SetLog(String s) {
        try {
            f = new FileWriter(file, true);
            f.write(new Date().toString() + ": " + s + "\n");
            f.flush();
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readLog() throws FileNotFoundException {
        FileReader fr = new FileReader(file);
        System.out.println("--------");
        Scanner scanner = new Scanner(fr);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }


}
