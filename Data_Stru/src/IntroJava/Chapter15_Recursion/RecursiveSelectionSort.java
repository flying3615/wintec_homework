package IntroJava.Chapter15_Recursion;

import java.util.Arrays;

/**
 * Created by liuyufei on 16/7/20.
 */
public class RecursiveSelectionSort {

    public static void sort(double[] list){
        sort(list,0,list.length-1);
    }

    private static void sort(double[] list, int low, int high) {
        if(low<high){
            int indexOfMin = low;
            double min = list[low];
            for(int i=low+1;i<=high;i++){
                if(list[i]<min){
                    min = list[i];
                    indexOfMin = i;
                }
            }

            list[indexOfMin] = list[low];
            list[low] = min;
            sort(list,low+1,high);
        }


    }


    public static void main(String[] args) {
        double[] input = new double[]{7.7, 3.3, 8.8, 1.1};
        sort(input);
        System.out.println(Arrays.toString(input));
    }

}
