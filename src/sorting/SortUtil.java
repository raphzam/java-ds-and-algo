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

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int boundary = partition(arr, start, end);
        quickSort(arr, start, boundary - 1);
        quickSort(arr, boundary + 1, end);

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int b = start - 1;

        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                b++;
                swap(arr, i, b);
            }
        }
        return b;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
