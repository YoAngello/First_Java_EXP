package edu.course.lab02.numbers;

public class Task01Integers {
    public void run() {
        System.out.println("=== ЗАДАНИЕ №1: Целочисленные ловушки ===");
        printMinMax();
        demonstrateOverflow();
        multiplyLimits();
        divisionAndModulo();
        narrowingConversion();
        charArithmetic();
        testOverflowCheck();
        System.out.println();
    }

    private void printMinMax() {
        System.out.println("1. Диапазоны типов:");
        System.out.println("Byte: " + Byte.MIN_VALUE + " ... " + Byte.MAX_VALUE);
        System.out.println("Short: " + Short.MIN_VALUE + " ... " + Short.MAX_VALUE);
        System.out.println("Integer: " + Integer.MIN_VALUE + " ... " + Integer.MAX_VALUE);
        System.out.println("Long: " + Long.MIN_VALUE + " ... " + Long.MAX_VALUE);
    }

    private void demonstrateOverflow() {
        int max = Integer.MAX_VALUE;
        int overflowed = max + 1;
        System.out.println("\n2. Переполнение Integer.MAX_VALUE + 1:");
        System.out.println("Результат: " + overflowed);
        // Объяснение: В циклическом представлении знаковых чисел (дополнительный код)
        // прибавление 1 к максимальному положительному числу сдвигает бит знака, превращая его в минимальное отрицательное.
    }

    private void multiplyLimits() {
        System.out.println("\n3. Умножение Integer.MAX_VALUE * 2:");
        int resInt = Integer.MAX_VALUE * 2;
        long resLong = (long) Integer.MAX_VALUE * 2;
        System.out.println("В типе int: " + resInt);
        System.out.println("В типе long: " + resLong);
        // Объяснение: В типе int произошло переполнение и потеря старших бит (-2).
        // В типе long вычисления прошли корректно, так как один из операндов был явно приведен к long до умножения.
    }

    private void divisionAndModulo() {
        System.out.println("\n4. Деление и остаток:");
        System.out.println("5 / 2 = " + (5 / 2));
        System.out.println("-5 / 2 = " + (-5 / 2));
        System.out.println("5 % 2 = " + (5 % 2));
        System.out.println("-5 % 2 = " + (-5 % 2));
        // Объяснение: В Java целочисленное деление усекает дробную часть в сторону нуля.
        // Знак остатка (%) всегда соответствует знаку делимого (первого операнда).
    }

    private void narrowingConversion() {
        long largeValue = Integer.MAX_VALUE + 10L;
        int narrowed = (int) largeValue;
        System.out.println("\n5. Приведение long к int (сужение):");
        System.out.println("Long значение: " + largeValue);
        System.out.println("Int результат:  " + narrowed);
        // Объяснение: При сужении типов Java просто отбрасывает старшие 32 бита числа long,
        // оставляя младшие 32 бита, что полностью меняет значение и знак из-за структуры дополнительного кода.
    }

    private void charArithmetic() {
        System.out.println("\n6. Арифметика над char:");
        char letter = 'A';
        char nextLetter = (char) (letter + 1);
        System.out.println("Следующая буква за 'A': " + nextLetter);

        char c1 = '1'; // код 49
        char c2 = '2'; // код 50
        int sumAsInt = c1 + c2;
        char sumAsChar = (char) (c1 + c2);
        System.out.println("Сложение '1' и '2' как число (коды 49+50): " + sumAsInt);
        System.out.println("Сложение '1' и '2' как символ: " + sumAsChar);
    }

    private void testOverflowCheck() {
        System.out.println("\n7. Проверка ручного переполнения:");
        int a1 = 2000000000, b1 = 2000000000;
        int a2 = 1000000, b2 = 500000;
        System.out.println(a1 + " + " + b1 + " переполнится? -> " + isAdditionOverflow(a1, b1));
        System.out.println(a2 + " + " + b2 + " переполнится? -> " + isAdditionOverflow(a2, b2));
    }

    private boolean isAdditionOverflow(int a, int b) {
        if (b > 0 && a > Integer.MAX_VALUE - b) return true;
        if (b < 0 && a < Integer.MIN_VALUE - b) return true;
        return false;
    }
}
