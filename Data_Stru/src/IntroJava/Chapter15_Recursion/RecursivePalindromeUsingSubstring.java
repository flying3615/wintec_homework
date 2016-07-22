package IntroJava.Chapter15_Recursion;

/**
 * Created by liuyufei on 16/7/20.
 */
public class RecursivePalindromeUsingSubstring {

    public static boolean isPalindrome(String s){
        return isPalindrome(s,0,s.length()-1);
    }

    public static boolean isPalindrome(String s,int low,int high){
        if(high<=low)return true;
        else if(s.charAt(low)!=s.charAt(high))return false;
        else return isPalindrome(s.substring(low+1,high-1));
    }

    public static void main(String[] args){
        System.out.println("is mom a palindrome "+isPalindrome("mom"));
        System.out.println("is moon a palindrome "+isPalindrome("moon"));
        System.out.println("is aba a palindrome "+isPalindrome("aba"));
        System.out.println("is a a palindrome "+isPalindrome("a"));
    }


}
