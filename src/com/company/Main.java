package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    // массив стоимостей
    final static double[] PRICES = new double[]{100, 200, 300, 400, 500, 600, 700, 800};
    // массив объёмов памяти
    final static int[] RAMS = new int[]{4, 8, 16, 20, 24, 28, 32};
    // массив производителей
    final static Brand[] BRANDS = new Brand[]{Brand.Lenuvo, Brand.Asos, Brand.MacNote, Brand.Eser, Brand.Xamiou};

    public static void main(String[] args) {
        // количество ноутбуков
        final int count = 10000;
        Random random = new Random();
        // массив ноутбуков
        Notebook[] notebooks = new Notebook[count];
        // инициализация массива ноутбуков
        for (int i = 0; i < count; i++) {
            notebooks[i] = new Notebook(
                    PRICES[random.nextInt(PRICES.length)],
                    RAMS[random.nextInt(RAMS.length)],
                    BRANDS[random.nextInt(BRANDS.length)]);
        }
        // компаратор
        Comparator<Notebook> notebookComparator = (o1, o2) -> {
            // сортировка по стоимости
            if (o1.getPrice() > o2.getPrice()) return 1;
            if (o1.getPrice() < o2.getPrice()) return -1;
            // сортировка по объёму памяти
            if (o1.getRam() > o2.getRam()) return 1;
            if (o1.getRam() < o2.getRam()) return -1;
            // сортировка по производителю
            if (o1.getBrand().ordinal() > o2.getBrand().ordinal()) return 1;
            if (o1.getBrand().ordinal() < o2.getBrand().ordinal()) return -1;
            return 0;
        };
        // сортировка с использованием компоратора
        Arrays.sort(notebooks, notebookComparator);
        // вывод отсортированного массива
        for (int i = 0; i < count; i++) {
            System.out.println(notebooks[i]);
        }
    }
}
