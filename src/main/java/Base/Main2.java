package Base;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

        /* Дана строка sql-запроса "select * from students where ".
        Сформируйте часть WHERE этого запроса, используя StringBuilder.
        Данные для фильтрации приведены ниже в виде json-строки.
        Если значение null, то параметр не должен попадать в запрос.
        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */

        String sqlReq = "select * from students where";
        String filter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        filter = filter.replace("{", "").replace("}", "");

        String[] filterArr = new String[filter.split(", ").length];
        filterArr = filter.split(", ");

        System.out.println(Arrays.toString(filterArr));

        StringBuilder filterBuild = new StringBuilder("");

        for (String field: filterArr) {

            String[] fieldArr = new String[2];
            fieldArr = field.split(":");

            if (fieldArr[1].replace("\"", "").equals("null") ){
                continue;
            }

            filterBuild.append(" ")
                    .append(fieldArr[0].replace("\"", ""))
                    .append(" = ").append(fieldArr[1]).append(" AND");

        }

        filterBuild.replace(filterBuild.length()-4, filterBuild.length(), ";");
        sqlReq = sqlReq + filterBuild.toString();

        System.out.println(sqlReq);

        System.out.println("-".repeat(50));
        // Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации вывести в консоль.

        int[] myArr = new int[] {-5, 23, 7, 5, 3, -12, -29, 21, 54, 35, 0};
        System.out.println(Arrays.toString(myArr));

        int temp;

        for (int j = 0; j<myArr.length-1; j++) {

            boolean rep = false;

            for (int i = myArr.length - 1; i > j; i--) {

                if (myArr[i] < myArr[i - 1]) {
                    temp = myArr[i - 1];
                    myArr[i - 1] = myArr[i];
                    myArr[i] = temp;
                    rep = true;
                }
            }

            if (!rep) break;

            System.out.println(Arrays.toString(myArr));
        }

    }
}
