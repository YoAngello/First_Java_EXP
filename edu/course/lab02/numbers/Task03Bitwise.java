package edu.course.lab02.numbers;

public class Task03Bitwise {
    public void run() {
        System.out.println("=== ЗАДАНИЕ №3: Побитовые операции ===");
        demonstrateOperators();
        explainShiftDifference();
        testBitwiseMethods();
        swapWithXor();
        System.out.println();
    }

    private void demonstrateOperators() {
        int a = 0b1100; // 12
        int b = 0b1010; // 10
        System.out.println("1. Базовые операторы (a=12, b=10):");
        System.out.println("  a & b  = " + (a & b)  + " (бинарно: " + Integer.toBinaryString(a & b) + ")");
        System.out.println("  a | b  = " + (a | b)  + " (бинарно: " + Integer.toBinaryString(a | b) + ")");
        System.out.println("  a ^ b  = " + (a ^ b)  + " (бинарно: " + Integer.toBinaryString(a ^ b) + ")");
        System.out.println("  ~a     = " + (~a)     + " (бинарно: " + Integer.toBinaryString(~a) + ")");
        System.out.println("  a << 2 = " + (a << 2) + " (бинарно: " + Integer.toBinaryString(a << 2) + ")");
    }

    private void explainShiftDifference() {
        System.out.println("\n2. Разница между >> и >>> для отрицательного числа:");
        int num = -8;
        System.out.println("  Число: " + num + " (бинарно: " + Integer.toBinaryString(num) + ")");
        System.out.println("  num >> 2  = " + (num >> 2)  + " (бинарно: " + Integer.toBinaryString(num >> 2) + ")");
        System.out.println("  num >>> 2 = " + (num >>> 2) + " (бинарно: " + Integer.toBinaryString(num >>> 2) + ")");
        // Объяснение: Оператор >> (знаковый сдвиг) сохраняет знак, заполняя освобождающиеся старшие биты знаковым битом (единицами для отрицательных).
        // Оператор >>> (беззнаковый сдвиг) всегда заполняет старшие биты нулями, превращая отрицательное число в огромное положительное.
    }

    private void testBitwiseMethods() {
        System.out.println("\n3. Тестирование побитовых методов:");
        int testNum = 12;
        int powerOfTwo = 16;
        System.out.println("  " + testNum + " чётное? -> " + isEven(testNum));
        System.out.println("  " + testNum + " степень 2? -> " + isPowerOfTwo(testNum));
        System.out.println("  " + powerOfTwo + " степень 2? -> " + isPowerOfTwo(powerOfTwo));
        System.out.println("  Количество единичных бит в " + testNum + " -> " + countSetBits(testNum));
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }

    private boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    private int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1; // Используем беззнаковый сдвиг, чтобы обрабатывать отрицательные числа без зацикливания
        }
        return count;
    }

    private void swapWithXor() {
        System.out.println("\n4. Обмен значений через XOR (^):");
        int x = 55;
        int y = 99;
        System.out.println("  До: x = " + x + ", y = " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("  После: x = " + x + ", y = " + y);
    }
}
