package edu.course.lab02.arrays;

public class Task06Matrices {
    public void run() {
        System.out.println("=== ЗАДАНИЕ №6: Многомерные массивы ===");
        int[][] matrix = {
                {12, 5, 3},
                {4, 127, 89}
        };
        System.out.println("1. Исходная матрица:");
        printMatrix(matrix);

        System.out.println("2. Транспонированная матрица:");
        int[][] transposed = transpose(matrix);
        printMatrix(transposed);

        System.out.println("3. Умножение матриц:");
        int[][] m1 = {{1, 2}, {3, 4}};
        int[][] m2 = {{2, 0}, {1, 2}};
        int[][] multRes = multiply(m1, m2);
        if (multRes != null) {
            printMatrix(multRes);
        }

        System.out.println("Попытка некорректного умножения:");
        multiply(m1, matrix); // Несогласованные размеры
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                // Форматированный вывод для ровной таблицы с выравниванием по ширине в 5 символов
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
    }

    private int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private int[][] multiply(int[][] m1, int[][] m2) {
        int r1 = m1.length;
        int c1 = m1[0].length;
        int r2 = m2.length;
        int c2 = m2[0].length;

        if (c1 != r2) {
            System.out.println("  [Ошибка выполнения]: Размеры матриц несогласованы для умножения (" + c1 + " != " + r2 + ").");
            return null;
        }

        int[][] res = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
