package OOP.Game;

import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }
    public String getClassName() {
        return "NumericGame";
    }
}
