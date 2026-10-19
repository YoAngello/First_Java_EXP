package edu.course.lab02.numbers;

public class Task02Floats {
    public void run() {
        System.out.println("=== ЗАДАНИЕ №2: Вещественная арифметика ===");
        demonstratePrecisionLoss();
        loopSummation();
        testEpsilonComparison();
        demonstrateSpecialValues();
        compareRounding();
        compareFloatVsDouble();
        System.out.println();
    }

    private void demonstratePrecisionLoss() {
        System.out.println("1. Точность 0.1 + 0.2:");
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));
        // Объяснение: Числа 0.1 и 0.2 не могут быть точно представлены в двоичной системе счисления
        // (они превращаются в бесконечные периодические дроби), что приводит к погрешности округления при сложении в стандарте IEEE 754.
    }

    private void loopSummation() {
        System.out.println("\n2. Цикл сложения 0.1 десять раз:");
        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            sum += 0.1;
        }
        System.out.println("Результат накопления: " + sum);
        System.out.println("sum == 1.0 ? -> " + (sum == 1.0));
    }

    private void testEpsilonComparison() {
        System.out.println("\n3. Сравнение с заданной точностью (epsilon):");
        double sum = 0.0;
        for (int i = 0; i < 10; i++) sum += 0.1;
        double target = 1.0;
        double eps = 1e-9;
        System.out.println("Равны ли с точностью " + eps + "? -> " + equalsWithEpsilon(sum, target, eps));
    }

    private boolean equalsWithEpsilon(double a, double b, double epsilon) {
        double diff = a - b;
        if (diff < 0) diff = -diff; // Ручной аналог Math.abs
        return diff < epsilon;
    }

    private void demonstrateSpecialValues() {
        System.out.println("\n4. Особые вещественные значения:");
        double pInf = 1.0 / 0.0;
        double nInf = -1.0 / 0.0;
        double nan = 0.0 / 0.0;
        System.out.println("1.0 / 0.0 = " + pInf);
        System.out.println("-1.0 / 0.0 = " + nInf);
        System.out.println("0.0 / 0.0 = " + nan);
        System.out.println("nan != nan ? -> " + (nan != nan));
    }

    private void compareRounding() {
        System.out.println("\n5. Сравнение стратегий округления:");
        double[] values = {2.7, -2.7};
        for (double v : values) {
            System.out.println("Для числа: " + v);
            System.out.println("  (int)cast:   " + (int) v);
            System.out.println("  Math.round:  " + Math.round(v));
            System.out.println("  Math.floor:  " + Math.floor(v));
            System.out.println("  Math.ceil:   " + Math.ceil(v));
        }
    }

    private void compareFloatVsDouble() {
        System.out.println("\n6. Точность float против double:");
        float fVal = 1.0f / 3.0f;
        double dVal = 1.0 / 3.0;
        System.out.println("1.0 / 3.0 как float:  " + fVal);
        System.out.println("1.0 / 3.0 как double: " + dVal);
    }
}
