package S6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        NoteBook note1 = new NoteBook(1234, 16, 500, "Mac", "Black");
        NoteBook note2 = new NoteBook(2345, 16, 250, "Win", "Black");
        NoteBook note3 = new NoteBook(32556, 32, 500, "Win", "White");
        NoteBook note4 = new NoteBook(79674, 32, 900, "Win", "Black");
        NoteBook note5 = new NoteBook(345322, 64, 900, "Win", "Black");
        NoteBook note6 = new NoteBook(1244, 64, 500, "Lin", "White");

        ArrayList<NoteBook> noteList = new ArrayList<>();
        noteList.add(note1);
        noteList.add(note2);
        noteList.add(note3);
        noteList.add(note4);
        noteList.add(note5);
        noteList.add(note6);

        ArrayList<NoteBook> myNotes = new ArrayList<>();
        HashMap<String, String> myParam = getMyParam();

        System.out.println("myParam = " + myParam);

        for (NoteBook note:
             noteList) {
            if (note.isParam(myParam)) myNotes.add(note);
        }

        System.out.println("myNotes = " + myNotes);

    }
    public static HashMap<String, String> getMyParam(){
        System.out.println("1 - ОЗУ\n2 - ЖД\n3 - ОС\n4 - Цвет\nQ - выход");
        System.out.println("Выберите критерии для поиска: ");

        Scanner sc = new Scanner(System.in);
        String param = sc.nextLine();
        String paramLim = "";

        if (param.equals("1") || param.equals("2")){
            System.out.println("Точное значение или минимальное?");
            System.out.println("S/M ");

            paramLim = sc.nextLine();
        }



        HashMap<String, String> myParam = new HashMap<>();
        while (!param.toLowerCase().contains("q")) {
            switch (param) {
                case "1":
                    if (paramLim.toLowerCase().equals("s")){
                        myParam.put("ОЗУ", sc.next());
                        break;
                    }
                    if (paramLim.toLowerCase().equals("m")){
                        myParam.put("ОЗУ - m", sc.next());
                        break;
                    }
                case "2":
                    if (paramLim.toLowerCase().equals("s")){
                        myParam.put("ЖД", sc.next());
                        break;
                    }
                    if (paramLim.toLowerCase().equals("m")){
                        myParam.put("ЖД - m", sc.next());
                        break;
                    }
                case "3":
                    myParam.put("ОС", sc.next());
                    break;
                case "4":
                    myParam.put("Цвет", sc.next());
                    break;
            }
            param = sc.nextLine();
        }
        sc.close();
        return myParam;
    }
}
