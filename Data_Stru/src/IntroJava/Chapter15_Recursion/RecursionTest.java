package IntroJava.Chapter15_Recursion;

/**
 * Created by liuyufei on 16/7/20.
 */
public class RecursionTest {

    public static void main(String[] args) {
        xMethod1(1234567);
        xMethod2(1234567);
    }

    public static void xMethod1(int n){
        if(n!=0){
            xMethod1(n/10);
            System.out.println(n);
        }
    }

    public static void xMethod2(int n){
        if(n!=0){
            System.out.println(n);
            xMethod2(n/10);
        }
    }
}
