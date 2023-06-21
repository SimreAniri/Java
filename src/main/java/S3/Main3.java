package S3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {

        Product prod1 = new Product("Мука высший сорт Макфа", "Россия", 126.6, "1", 1.0);
        Product prod6 = new Product("Мука высший сорт Портовая", "Россия", 126.6, "1", 1.0);
        Product prod2 = new Product("Мука Высший сорт Селяночка", "Россия", 145.8, "2", 1.0);
        Product prod3 = new Product("Мука высший сорт Перекресток", "Россия", 116.6, "3", 1.0);
        Product prod4 = new Product("Мука 1-го сорта Каждый день", "Россия", 136.7, "1", 1.0);
        Product prod5 = new Product("Мука 2-го сорта Каждый день", "Россия", 106.6, "2", 1.0);

        Product[] prodList = new Product[6];
        prodList[0] = prod1;
        prodList[1] = prod2;
        prodList[2] = prod3;
        prodList[3] = prod4;
        prodList[4] = prod5;
        prodList[5] = prod6;

        System.out.println("Максимальная цена = "
                + maxPriceForNameAndSort(prodList, "высший", new String[]{"1", "2"}));

        System.out.println("-".repeat(50));


        System.out.println("Продукты с минимальной ценой:\n" + prodListWithMinPrice(prodList, "1"));
    }

    /**
     * @param prodAr массив товаров
     * @param name   ключ поиска в названии
     * @param sortAr список сортов продукта
     * @return максимальная цена
     * @apiNote Поиск наибольшой цены товаров заданных сортов среди товаров,
     * название которых содержит заданный ключ.
     */
    public static double maxPriceForNameAndSort(Product[] prodAr, String name, String[] sortAr) {
        double maxPrice = 0;

        for (Product prod : prodAr) {
            if (prod.getName().toLowerCase().contains(name)) {
                for (String sort : sortAr) {
                    if (prod.getSort().equals(sort) && prod.getPrice() > maxPrice) maxPrice = prod.getPrice();
                }
            }
        }

        return maxPrice;
    }

    /**
     * @param prodAr массив товаров
     * @param sort   сорт товара
     * @return список товаров
     * @apiNote Возвращает наименования товаров заданного сорта с наименьшей ценой.
     */
    public static ArrayList<String> prodListWithMinPrice(Product[] prodAr, String sort) {
        double minPrice = Double.POSITIVE_INFINITY;
        ArrayList<String> minList = new ArrayList<>();

        for (Product prod : prodAr) {
            if (prod.getSort().equals(sort)) {
                if (prod.getPrice() < minPrice) {
                    minPrice = prod.getPrice();
                    minList.clear();
                    minList.add(prod.getName());
                } else if (prod.getPrice() == minPrice) {
                    minList.add(prod.getName());
                }
            }
        }
        return minList;
    }

}
