package S3;

import java.util.ArrayList;

public class Perm {
    public static void main(String[] args) {
        StringBuilder myString = new StringBuilder("123");
        ArrayList<StringBuilder> list = new ArrayList<>();
        list.add(myString);

        for (int i = 0; i < myString.length()-1; i++) {
            ArrayList<StringBuilder> newList = new ArrayList<>();
            for (StringBuilder s : list) {
                for (int j = i; j < myString.length(); j++) {

                    StringBuilder newString = new StringBuilder("");

                    newString.append(s.substring(0,i));
                    newString.append(s.substring(j, j+1));
                    newString.append((new StringBuilder(s.substring(i))).deleteCharAt(j-i));

                    if (!newList.contains(newString)) {
                        newList.add(newString);
                    }
                }
            }
            list.clear();
            list.addAll(newList);
        }
        System.out.println("Перестановки:\n" + list);


    }
}
