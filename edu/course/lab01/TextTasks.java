package edu.course.lab01;

public class TextTasks {

    public static void reverse(String input) {
        // Reverse string manually using a loop and charAt()
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
        System.out.println(); // Newline at the end
    }

    public static void palindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            char leftChar = input.charAt(left);
            // Skip characters that are not letters or digits
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            char rightChar = input.charAt(right);
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        System.out.println(isPalindrome);
    }
}
