package linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println(list);
        System.out.println(list.kthNodeFromEnd(3)); //expected 30
        list.reverse();
        System.out.println(list);
        System.out.println(list.kthNodeFromEnd(3));
        System.out.println(list.kthNodeFromEnd(1));

    }
}
