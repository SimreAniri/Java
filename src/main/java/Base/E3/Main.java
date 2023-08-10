package Base.E3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = new String[]{" 11.01.1999 m Яковлева Ирина Михайловна 89175556633",
                "Яковлев Алексей Алексеевич 11.11.1999 f  89175552233",
                "Савина Анна Викторовна 11.01.1999  89175556633"};

        for (String s : stringArray) {
            try {
                HashMap<String, String> mapS = parseString(s);
                if (checkParseString(mapS).equals("OK")) {
                    writeData(mapS);
                } else System.out.println(checkParseString(mapS));
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
        }
    }

    /**
     * @param s строка
     * @return Словарь с полями ФИО, пол, дата рождения, телефон или с полем ERROR в случае некорректного заполнения
     * @apiNote Парсинг строки по полям ФИО, пол, дата рождения, телефон
     */
    static HashMap<String, String> parseString(String s) throws IllegalAccessException {
        HashMap<String, String> person = new HashMap<>();

        s = s.replace(",", "");
        String[] parseS = s.split(" ");

        for (int i = 0; i < parseS.length; i++) {
            if (parseS[i].equals("")) {
                i++;
                if (i >= parseS.length) break;
            }

            if (parseS[i].toLowerCase().equals("f") || parseS[i].toLowerCase().equals("m")) {
                if (person.containsKey("gender")) {
                    person.clear();
                    person.put("ERROR", "-1");
                    return person;
                }
                person.put("gender", parseS[i]);

            } else if (parseS[i].matches("[a-zA-Zа-яА-Я]+")) {
                if (person.containsKey("FIO")) {
                    person.clear();
                    person.put("ERROR", "-1");
                    return person;
                }
                person.put("FIO", parseS[i]);
                i++;
                if ((i + 1 < parseS.length) &&
                        parseS[i].matches("[a-zA-Zа-яА-Я]+") &&
                        parseS[i + 1].matches("[a-zA-Zа-яА-Я]+")) {
                    person.put("FIO", person.get("FIO") + " " + parseS[i] + " " + parseS[i + 1]);
                    i++;
                    if (i >= parseS.length) break;
                } else throw new NotCorrectDataException("ФИО введено некорректно");

            } else if (parseS[i].matches("\\w*[.]\\w*[.]\\w*")) {
                if (parseS[i].matches("\\d{2}[.]\\d{2}[.]\\d{4}")) {
                    if (person.containsKey("date")) {
                        person.clear();
                        person.put("ERROR", "-1");
                        return person;
                    }
                    person.put("date", parseS[i]);
                } else throw new NotCorrectDataException("Дата рождения введена некорректно");

            } else if (parseS[i].matches("\\w+")) {
                if (person.containsKey("phone")) {
                    person.clear();
                    person.put("ERROR", "-1");
                    return person;
                }
                if (parseS[i].matches("\\d{11}")) {
                    if (person.containsKey("phone")) {
                        person.clear();
                        person.put("ERROR", "-1");
                        return person;
                    }
                    person.put("phone", parseS[i]);
                } else throw new NotCorrectDataException("Телефон введен некорректно");

            }
        }
        return person;
    }

    /**
     * @param person результат работы parseString
     * @return расшифровка кодов ошибок
     * @apiNote проверка кода ошибок parseString
     */
    static String checkParseString(HashMap<String, String> person) {
        if (person.containsKey("ERROR")) {
            if (person.get("ERROR").equals("-1")) return "Несколько значений для одного поля";
        }
        if (person.size() < 4) return "Не все поля заполнены";
        return "OK";
    }

    static void writeData(HashMap<String, String> person) throws IOException {
        String fio = person.get("FIO");
        String gender = person.get("gender");
        String date = person.get("date");
        String phone = person.get("phone");

        String surname = fio.split(" ")[0];

        String fileName = "C:\\Ирина\\Java\\My_HW\\src\\main\\java\\Base\\E3\\" + surname + ".txt";

        FileWriter f = new FileWriter(fileName, true);
        f.write(fio + " ");
        f.write(date + " ");
        f.write(phone + " ");
        f.write(gender + " \n");
        f.flush();
        f.close();
    }
}