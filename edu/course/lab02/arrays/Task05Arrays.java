package edu.course.lab02.arrays;

import java.util.Arrays;

public class Task05Arrays {
    public void run() {
        System.out.println("=== ЗАДАНИЕ №5: Одномерные массивы ===");
        int[] arr = createRandomArray(8);

        System.out.print("1. Исходный случайный массив: ");
        printArray(arr);

        printMinMaxAverage(arr);
        sortAndPrint(arr);
        compareArrays();
        System.out.println();
    }

    private int[] createRandomArray(int size) {
        int[] arr = new int[size];
        long seed = System.nanoTime();
        for (int i = 0; i < size; i++) {
            // Линейный конгруэнтный алгоритм псевдорандома без использования сторонних библиотек
            seed = (seed * 1103515245 + 12345) & 0x7fffffff;
            arr[i] = (int) (seed % 100);
        }
        return arr;
    }

    private void printMinMaxAverage(int[] arr) {
        if (arr.length == 0) return;
        int min = arr[0];
        int max = arr[0];
        long sum = 0;
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
            sum += val;
        }
        double avg = (double) sum / arr.length;
        System.out.println("2. Статистика: Min=" + min + ", Max=" + max + ", Среднее=" + avg);
    }

    private void sortAndPrint(int[] arr) {
        // Выбран алгоритм: Сортировка вставками (Insertion Sort)
        // Описание: Устойчивый алгоритм, эффективный для небольших наборов данных.
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);

        for (int i = 1; i < copy.length; i++) {
            int key = copy[i];
            int j = i - 1;
            while (j >= 0 && copy[j] > key) {
                copy[j + 1] = copy[j];
                j = j - 1;
            }
            copy[j + 1] = key;
        }
        System.out.print("3. Массив после сортировки вставками: ");
        printArray(copy);
    }

    private void compareArrays() {
        System.out.println("4. Демонстрация сравнения массивов:");
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};
        System.out.println("  a1 == a2 -> " + (a1 == a2)); // Ложно, разные ссылки на структуры в куче
        System.out.println("  a1.equals(a2) -> " + a1.equals(a2)); // Ложно, метод наследуется от Object и сравнивает ссылки
        System.out.println("  Arrays.equals(a1, a2) -> " + Arrays.equals(a1, a2)); // Истинно, поэлементное сравнение содержимого
    }

    private void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}
