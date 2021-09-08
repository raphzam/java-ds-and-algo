package heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(12);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(17);
        maxHeap.insert(15);
        System.out.println("Done");
        maxHeap.remove();
        System.out.println("Done");

    }
}
