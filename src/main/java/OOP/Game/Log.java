package OOP.Game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {
    private FileWriter f;
    private String dir;
    private String name;

    public Log(String dir, String name) {
        this.dir = dir;
        this.name = name;
        try {
            f = new FileWriter(dir + name, true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getLog(String s, Answer answer) {
        try {
            f.write(new Date().toString() + ": " + s + " " + answer.toString() + "\n");
            f.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getLog(String s) {
        try {
            f.write(new Date().toString() + ": " + s + "\n");
            f.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
