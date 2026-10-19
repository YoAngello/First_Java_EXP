package edu.course.lab02.util;

public class Task07Methods {
    public void run() {
        System.out.println("=== ЗАДАНИЕ №7: Методы и передача аргументов ===");

        System.out.println("1. Демонстрация перегрузки методов:");
        print(42);
        print(3.14);
        print("Тестовая строка");
        print(new int[]{5, 6, 7});

        System.out.println("\n2. Вызовы методов с varargs:");
        System.out.println("  Сумма(без аргументов) = " + sumVarArgs());
        System.out.println("  Сумма(1, 2, 3) = " + sumVarArgs(1, 2, 3));
        System.out.println("  Сумма(массив) = " + sumVarArgs(new int[]{10, 20}));

        System.out.println("\n3. Возведение в степень:");
        long base = 2; int exp = 10;
        System.out.println("  Итеративно (2^10): " + powIterative(base, exp));
        System.out.println("  Рекурсивно (2^10): " + powRecursive(base, exp));
        System.out.println("  Проверка Math.pow: " + (long)Math.pow(base, exp));
        System.out.println("  Проверка граничной степени 0 (5^0): " + powRecursive(5, 0));

        // Объяснение производительности:
        // Итеративная реализация будет работать быстрее. При каждом рекурсивном вызове
        // в памяти создается новый фрейм стека (выделяется место под аргументы, локальные переменные и адрес возврата).
        // Это влечет за собой накладные расходы процессора. В цикле же используются одни и те же регистры или ячейки памяти.
    }

    // Перегруженные методы
    private void print(int val) { System.out.println("  Вызван метод print(int): " + val); }
    private void print(double val) { System.out.println("  Вызван метод print(double): " + val); }
    private void print(String val) { System.out.println("  Вызван метод print(String): " + val); }
    private void print(int[] arr) {
        System.out.print("  Вызван метод print(int[]): [");
        for(int i=0; i<arr.length; i++) System.out.print(arr[i] + (i==arr.length-1?"":", "));
        System.out.println("]");
    }

    // Метод с varargs
    private int sumVarArgs(int... args) {
        int sum = 0;
        for (int val : args) sum += val;
        return sum;
    }

    // Итеративное возведение в степень
    private long powIterative(long base, int exp) {
        long res = 1;
        for (int i = 0; i < exp; i++) {
            res *= base;
        }
        return res;
    }

    // Рекурсивное возведение в степень
    private long powRecursive(long base, int exp) {
        if (exp == 0) return 1;
        return base * powRecursive(base, exp - 1);
    }
}
