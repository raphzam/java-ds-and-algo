package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6,2,4,7,3,1,0};
        SortUtil.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
