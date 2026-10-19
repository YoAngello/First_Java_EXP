package edu.course.lab02.strings;

public class Task04Text {
    public void run() {
        System.out.println("=== ЗАДАНИЕ №4: Обработка текста ===");

        System.out.println("1. Палиндром:");
        String palindromeTest = "А роза упала на лапу Азора!";
        System.out.println("  \"" + palindromeTest + "\" палиндром? -> " + isPalindrome(palindromeTest));

        System.out.println("\n2. Разворот слов:");
        String sentence = "кот съел мышь";
        System.out.println("  Исходная: " + sentence);
        System.out.println("  Результат: " + reverseWords(sentence));

        System.out.println("\n3. Статистика строки за один проход:");
        printStringStats("Hello World! 123");

        System.out.println("\n4. Шифр Цезаря:");
        String secret = "Hello-Z";
        String encrypted = caesarCipher(secret, 3);
        String decrypted = caesarCipher(encrypted, -3);
        System.out.println("  Исходный текст: " + secret);
        System.out.println("  Зашифрованный (+3): " + encrypted);
        System.out.println("  Расшифрованный (-3): " + decrypted);

        System.out.println("\n5. Самое длинное слово:");
        String longWordsStr = "Java прекрасный язык программирования для обучения";
        System.out.println("  Строка: " + longWordsStr);
        System.out.println("  Самое длинное слово: " + findLongestWord(longWordsStr));
        System.out.println();
    }

    private boolean isPalindrome(String str) {
        char[] clean = new char[str.length()];
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'А' && ch <= 'Я')) {
                ch = (char) (ch + 32); // приведение к нижнему регистру для базовой кириллицы/латиницы
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'а' && ch <= 'я')) {
                // уже строчная
            } else {
                continue; // пропускаем знаки препинания
            }
            clean[len++] = ch;
        }

        for (int i = 0; i < len / 2; i++) {
            if (clean[i] != clean[len - 1 - i]) return false;
        }
        return true;
    }

    private String reverseWords(String str) {
        char[] chars = str.toCharArray();
        // 1. Разворачиваем всю строку
        reverseRange(chars, 0, chars.length - 1);
        // 2. Разворачиваем каждое слово обратно
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                reverseRange(chars, start, i - 1);
                start = i + 1;
            }
        }
        return new String(chars);
    }

    private void reverseRange(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private void printStringStats(String str) {
        int vowels = 0, consonants = 0, digits = 0, spaces = 0;
        String vList = "aeiouyAEIOUYаеёиоуыэюяАЕЁИОУЫЭЮЯ";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                spaces++;
            } else if (ch >= '0' && ch <= '9') {
                digits++;
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ||
                    (ch >= 'а' && ch <= 'я') || (ch >= 'А' && ch <= 'Я')) {
                boolean isVowel = false;
                for (int j = 0; j < vList.length(); j++) {
                    if (ch == vList.charAt(j)) {
                        isVowel = true;
                        break;
                    }
                }
                if (isVowel) vowels++; else consonants++;
            }
        }
        System.out.println("  Гласных: " + vowels + ", Согласных: " + consonants +
                ", Цифр: " + digits + ", Пробелов: " + spaces);
    }

    private String caesarCipher(String str, int k) {
        char[] result = str.toCharArray();
        // Нормализация сдвига под размер английского алфавита (26)
        k = k % 26;
        if (k < 0) k += 26;

        for (int i = 0; i < result.length; i++) {
            char ch = result[i];
            if (ch >= 'a' && ch <= 'z') {
                result[i] = (char) ('a' + (ch - 'a' + k) % 26);
            } else if (ch >= 'A' && ch <= 'Z') {
                result[i] = (char) ('A' + (ch - 'A' + k) % 26);
            }
        }
        return new String(result);
    }

    private String findLongestWord(String str) {
        String longest = "";
        int start = -1;
        for (int i = 0; i <= str.length(); i++) {
            if (i < str.length() && str.charAt(i) != ' ') {
                if (start == -1) start = i;
            } else {
                if (start != -1) {
                    String word = str.substring(start, i);
                    if (word.length() > longest.length()) {
                        longest = word;
                    }
                    start = -1;
                }
            }
        }
        return longest;
    }
}
