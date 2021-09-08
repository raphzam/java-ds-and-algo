package heap;

public class MaxHeap {
    private int[] items = new int[10];
    private int size;

    public void insert(int item) {
        if (isFull()) throw new IllegalStateException();
        // insert element at last open slot
        items[size++] = item;
        // bubble up element to correct slot
        bubbleUp();
    }

    // removes the root node
    public int remove() {
        if (isEmpty()) throw new IllegalStateException();

        int root = items[0];
        items[0] = items[--size]; // set root to item at last slot
        //if item(root) < children, bubble down
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int index = 0;
        // if the current item is not a valid parent,
        // swap with larger child
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex; // continue to bubble down
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }

        if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }

        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }

        if (!hasRightChild(index)) {
            return items[index] >= leftChild(index);
        }

        return items[index] >= leftChild(index) &&
                items[index] >= rightChild(index);
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }


    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }


    private void bubbleUp() {
        int index = size - 1;
        int parentIndex = getParentIndex(index);
        while (index > 0 && items[index] > items[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    // takes two indexes and swaps the values
    private void swap(int index, int parentIndex) {
        int temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean isFull() {
        return size == items.length;
    }


}
