package OOP.Game;

import java.util.ArrayList;
import java.util.List;

public class EngGame extends AbstractGame{
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (Character i = 97; i <= 122; i++) {
            result.add(i.toString());
        }
        System.out.println("result = " + result);
        return result;
    }
    public String getClassName() {
        return "EngGame";
    }
}
