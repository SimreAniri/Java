package S6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteBook {
    private int id;
    private int ram;
    private int hhd;
    private String os;
    private String color;

    public boolean isParam(HashMap<String, String> params){
        boolean flag = true;
        if (params.containsKey("ОЗУ")){
            if (!(Integer.parseInt(params.get("ОЗУ")) == ram)) flag = false;
        }
        if (params.containsKey("ОЗУ - m")){
            if (Integer.parseInt(params.get("ОЗУ - m")) > ram) flag = false;
        }
        if (params.containsKey("ЖД")){
            if (!(Integer.parseInt(params.get("ЖД")) == hhd)) flag = false;
        }
        if (params.containsKey("ЖД - m")){
            if (Integer.parseInt(params.get("ЖД - m")) > hhd) flag = false;
        }
        if (params.containsKey("ОС")){
            if (!(params.get("ОС").toLowerCase().equals(os.toLowerCase()))) flag = false;
        }
        if (params.containsKey("Цвет")){
            if (!(params.get("Цвет").toLowerCase().equals(color.toLowerCase()))) flag = false;
        }
        return flag;
    }

}
