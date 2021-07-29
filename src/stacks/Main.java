package stacks;

public class Main {
    public static void main(String[] args) {

        /*
        Reverse a string using a stack
         */
        StringReverser stringReverser = new StringReverser();
        String str = "a green apple";
        String reverse = stringReverser.reverse(str);
        System.out.println(reverse);

    }
}
