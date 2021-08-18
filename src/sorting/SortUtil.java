package sorting;

public class SortUtil {
    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        int length = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < length; i++) {
                if (arr[i] > arr[i + 1]) { //current > next
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            length--; //last element will be in the right place
        }
    }

}
