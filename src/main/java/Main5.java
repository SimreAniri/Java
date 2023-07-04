import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        String s = "Россия идет вперед всей планеты. Планета — это не Россия.\n gh";

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toLowerCase();



        System.out.println(word + " - " + countWord(word, s));
    }

    /**
     * @apiNote Подсчитывает количество искомого слова, используя map
     * @param word слово поика
     * @param str строка
     * @return количество вхождений
     */
    public static int countWord(String word, String str){
        str = str.toLowerCase().replaceAll("\\p{Punct}|[\n]", "");
        String[] sPath = str.split(" ");
        HashMap<String, Integer> count = new HashMap<>();
        count.put(word, 0);

        for (String s : sPath) {
            if (s.equals(word)) count.put(word, count.get(word) + 1);
        }

        return count.get(word);
    }

}
