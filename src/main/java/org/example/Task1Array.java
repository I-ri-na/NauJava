package org.example;

import java.util.Random;
import java.util.Scanner;

public class Task1Array {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива n: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(201) - 100;
        }

        System.out.print("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int lastPositive = Integer.MIN_VALUE;
        boolean found = false;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] > 0) {
                lastPositive = array[i];
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Последний положительный элемент: " + lastPositive);
        } else {
            System.out.println("Положительных элементов нет.");
        }
    }
}
