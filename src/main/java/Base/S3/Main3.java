package Base.S3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
        System.out.println("Продукты с минимальной ценой:\n"
                + prodListWithMinPrice(prodList, "1"));

        Books book1 = new Books("Еще один великолепный МИФ", "Асприн", 1978, 565.8, 159);
        Books book2 = new Books("Профессия - Ведьма", "Громко", 2003, 565.8, 444);
        Books book3 = new Books("Сумерки", "Майер", 2005, 765.8, 449);
        Books book4 = new Books("Чужак", "Фрай", 1996, 865.9, 607);
        Books book5 = new Books("Эрагон", "Паолини", 2003, 965.8, 631);
        Books book6 = new Books("Эрагон. Возвраение", "Паолини", 2006, 995.8, 877);

        Books[] bookList = new Books[6];
        bookList[0] = book1;
        bookList[1] = book2;
        bookList[2] = book3;
        bookList[3] = book4;
        bookList[4] = book5;
        bookList[5] = book6;

        System.out.println("-".repeat(50));
        System.out.println("myBook = " + booksWithPrime(bookList, "а", 2000));

        // Задан целочисленный список ArrayList.
        // Найти минимальное, максимальное и среднее из этого списка.
        System.out.println("-".repeat(50));

        ArrayList<Integer> list = new ArrayList<>();
        int size = 20;

        for (int i = 0; i < size; i++) list.add(new Random().nextInt(100));
        System.out.println(list);

        int maxNum = list.get(0), minNum = list.get(0);
        double mean = 0;

        int i = 0;
        while (i <= list.size() - 1) {

            mean += list.get(i);

            if (list.get(i) < minNum) minNum = list.get(i);
            if (list.get(i) > maxNum) maxNum = list.get(i);

            i++;
        }

        mean = mean / size;

        System.out.println("Минимальное значение " + minNum);
        System.out.println("Максимальное значение " + maxNum);
        System.out.println("Среднее значение " + mean);

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

    /**
     * @param n верхняя граница
     * @return список простых чисел
     * @apiNote Ищет простые числа
     */
    public static ArrayList<Integer> primeNums(int n) {
        ArrayList<Integer> primeNums = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            boolean flag = true;

            for (int primeNum : primeNums) {

                if (primeNum > Math.sqrt(i) + 1) break;

                if (i % primeNum == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) primeNums.add(i);
        }
        primeNums.add(0, 1);
        return primeNums;
    }

    /**
     * @param bookAr массив книг
     * @param cons   подстрока в фамилии автора
     * @param year   нижняя граница года издания
     * @return список названий книг
     * @apiNote Список названий книг, в которых простое количество страниц,и
     * фамилия автора содержит подстроку, а год издания после year, включительно.
     */
    public static ArrayList<String> booksWithPrime(Books[] bookAr, String cons, int year) {
        cons = cons.toLowerCase();
        ArrayList<String> books = new ArrayList<>();
        ArrayList<Integer> primeNums1000 = primeNums(1000);

        for (Books book : bookAr) {
            if (book.getAuthorSurname().toLowerCase().contains(cons) && book.getYear() >= year) {
                if (book.getPagesCount() < 1000 && primeNums1000.contains(book.getPagesCount())) {
                    books.add(book.getTitle());
                }
                if (book.getPagesCount() > 1000
                        && primeNums(book.getPagesCount()).contains(book.getPagesCount())) {
                    books.add(book.getTitle());
                }
            }
        }
        return books;
    }
}
