import java.util.ArrayDeque;
import java.util.Deque;

public class Main4 {
    public static void main(String[] args) {
        String s = "([]){}";

        System.out.println("Корректность скобок: "+ validation(s));
    }

    /**
     * @apiNote проверка корректности открытия и закрытия скобок
     * @param s строка, содержащая скобки
     * @return true/false
     */
    private static boolean validation(String s) {
        Deque<Character> deq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character sym = s.charAt(i);
            if (sym == '(' || sym == '{' || sym == '[') {
                deq.addLast(sym);

            } else {
                Character lastSym = deq.peekLast();
                if ((sym == ')' && lastSym == '(') || (sym == '}' && lastSym == '{') ||
                        (sym == ']' && lastSym == '[')) {

                    deq.removeLast();

                } else return false;
            }
        }
        return true;
    }
}
