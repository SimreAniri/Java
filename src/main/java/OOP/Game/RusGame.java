package OOP.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RusGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        String alpha = "йцукенгшщзхъфывапролджэячсмитьбю";
        for (int i = 0; i < alpha.length(); i++) {
            result.add(String.valueOf(alpha.charAt(i)));
        }
        return result;
    }

    public String getClassName() {
        return "RusGame";
    }
}
