package S3;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {

        Product prod1 = new Product("Мука высший сорт Макфа", 126.6, "1");
        Product prod2 = new Product("Мука Высший сорт Селяночка", 145.8, "2");
        Product prod3 = new Product("Мука высший сорт Перекресток", 116.6, "3");
        Product prod4 = new Product("Мука 1-го сорта Каждый день", 136.7, "1");
        Product prod5 = new Product("Мука 2-го сорта Каждый день", 106.6, "2");

        Product[] prodList = new Product[5];
        prodList[0] = prod1;
        prodList[1] = prod2;
        prodList[2] = prod3;
        prodList[3] = prod4;
        prodList[4] = prod5;

        System.out.println("Максимальная цена = "
                + maxPriceForNameAndSort(prodList, "высший", new String[]{"1", "2"}));
    }

    /**
     * @param prodAr массив продуктов
     * @param name   ключ поиска в названии
     * @param sortAr список сортов продукта
     * @return максимальная цена
     * @apiNote Дан массив записей: наименование товара, цена, сорт. Найти наибольшую цену товаров
     * 1го или 2-го сорта среди товаров, название которых содержит «высший».
     */
    public static double maxPriceForNameAndSort(Product[] prodAr, String name, String[] sortAr) {
        double maxPrice = 0;

        for (Product prod : prodAr) {
            if (prod.getName().toLowerCase().contains(name)) {
                for (String sort : sortAr) {
                    if (prod.getSort().equals(sort) && prod.getPrice() > maxPrice) {
                        maxPrice = prod.getPrice();
                    }
                }
            }
        }

        return maxPrice;
    }

}
