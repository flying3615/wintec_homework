package iphomework;

/**
 * Created by liuyufei on 9/11/16.
 */
public class Hex2Oct {
    public static void main(String[] args) {
//        int[] mask = {0xFF};
        int[] mask = {0x80, 0xC0, 0xE0, 0xF0, 0xF8, 0xFC, 0xFE, 0xFF};
//
//        for (int i : mask) {
//            System.out.println((Integer.toBinaryString(i & 192)));
//        }
//
        String a = "aa bb cc";
        int space = a.indexOf(" ");
        System.out.println(space);
        System.out.println(a.substring(0,space));
        System.out.println(a.substring(space+1,a.length()));
    }
}
