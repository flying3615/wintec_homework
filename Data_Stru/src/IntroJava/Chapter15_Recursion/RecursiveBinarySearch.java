package IntroJava.Chapter15_Recursion;

/**
 * Created by liuyufei on 16/7/20.
 */
public class RecursiveBinarySearch {
    public static int recursiveBinarySearch(int[] list,int key){
        int low = 0;
        int high = list.length-1;
        return recursiveBinarySearch(list,key,low,high);
    }

    private static int recursiveBinarySearch(int[] list, int key, int low, int high) {
        if(low>high) return -low-1;

        int mid = (low+high)/2;
        if(key<list[mid])
            return recursiveBinarySearch(list,key,low,mid-1);
        else if(key>list[mid])
            return recursiveBinarySearch(list,key,mid+1,high);
        else
            return mid;
    }

    public static void main(String[] args) {
        System.out.println(recursiveBinarySearch(new int[]{1,2,3,4,5},5));
    }
}
