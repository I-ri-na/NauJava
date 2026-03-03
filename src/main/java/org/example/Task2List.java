package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2List {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов списка n: ");
        int n = scanner.nextInt();

        ArrayList<Double> list = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            double value = Math.round((random.nextDouble() * 200 - 100) * 100.0) / 100.0;
            list.add(value);
        }

        System.out.println("Исходный список: " + list);

        selectionSort(list);

        System.out.println("Отсортированный список: " + list);
    }

    public static void selectionSort(ArrayList<Double> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Меняем местами минимальный элемент с текущим
            Double temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }
}
