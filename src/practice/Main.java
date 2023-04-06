package practice;

// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:
// Input: s = "cbbd"
// Output: "bb"
// Constraints:
// 1 <= s.length <= 1000
// s consist of only digits and English letters.

public class Main {

    public static void main(String[] args) {
        String s = "bababa";
        System.out.println(longestPalindrome(s));
        // write your code here
    }

    public static String longestPalindrome(String s) {
        int p1 = 0, p2 = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = findPalindrome(s, i, i);
            int even = findPalindrome(s, i, i + 1);
            int len = Math.max(odd, even);

            if (len > p2 - p1) {
                p1 = i - (len - 1) / 2;
                p2 = i + len / 2;
            }
        }
        return s.substring(p1, p2 + 1);
    }

    private static int findPalindrome(String s, int p1, int p2) {
        while (p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)) {
            p1--;
            p2++;
        }
        return p2 - p1 - 1;
    }
}
