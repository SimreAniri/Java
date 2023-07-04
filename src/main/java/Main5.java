import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        String s = "Россия идет вперед всей планеты. Планета — это не Россия.\n gh";

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toLowerCase();
        sc.close();

        System.out.println(word + " - " + countWord(word, s));
        System.out.println("-".repeat(50));

        String[] nameList = new String[]{"Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        HashMap<String, Integer> nameCount = new HashMap<>();
        HashMap<Integer, String> nameId = new HashMap<>();

        int i = 0;

        for (String str : nameList) {
            String name = str.split(" ")[0];
            if (!nameCount.containsKey(name)) {
                nameCount.put(name, 1);
                nameId.put(i, name);
                i++;
            }
            else nameCount.put(name, nameCount.get(name) + 1);
        }

        int[] idList= new int[nameId.size()];
        for (int j = 0; j < nameId.size(); j++) {
            idList[j] = j;
        }

        System.out.println("nameCount = " + nameCount);

        int temp;

        for (int j = 0; j < nameCount.size(); j++) {

            boolean rep = false;

            for (int k = nameCount.size() - 1; k > j; k--) {

                if (nameCount.get(nameId.get(idList[k])) > nameCount.get(nameId.get(idList[k - 1]))) {
                    temp = idList[k - 1];
                    idList[k - 1] = idList[k];
                    idList[k] = temp;
                    rep = true;
                    rep = true;
                }
            }

            if (!rep) break;
        }

        for (int id: idList) {
            System.out.println(nameId.get(id) + " - " + nameCount.get(nameId.get(id)));
        }

    }

    /**
     * @param word слово поика
     * @param str  строка
     * @return количество вхождений
     * @apiNote Подсчитывает количество искомого слова, используя map
     */
    public static int countWord(String word, String str) {
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
