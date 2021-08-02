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

        /*
        Check is an expression is balanced by
        validating brackets and parenthesis
         */
        //Edge cases
        //(
        //(())
        //(]
        //)(
        String input = "[(1 + 2)]]";
        Expression exp = new Expression();
        Boolean bal = exp.isBalanced(input);
        System.out.println(bal);

    }
}
