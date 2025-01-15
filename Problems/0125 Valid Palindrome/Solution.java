import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ollo"));
    }

    //initial solution
    // public static boolean isPalindrome(String s) {
    //     String trimmedString = "";
    //     for (char c : s.toCharArray()) {
    //         if (Character.isLetterOrDigit(c)) {
    //             trimmedString += Character.toLowerCase(c);
    //         }
    //     }
    //     for (int i = 0; i <= trimmedString.length()/2-1; i++) {
    //         if (trimmedString.charAt(i) != trimmedString.charAt(trimmedString.length() - 1 - i)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }   

    /*
     * Improved Area:
     * edge cases handling, where string length == 0 || 1
     * improve performance of two pointer
     * optimize memory 
     */
    
    public static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        char firstChar = 'a';
        char secondChar = 'a';

        while (start <= end) {
            firstChar = s.charAt(start);
            secondChar = s.charAt(end);
            if (!Character.isLetterOrDigit(firstChar)) {
                start++;
            } else if (!Character.isLetterOrDigit(secondChar)) {
                end--;
            } else {
                if (Character.toLowerCase(firstChar) != Character.toLowerCase(secondChar)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

}