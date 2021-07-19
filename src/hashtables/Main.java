package hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        /*
        Given a String of characters, define a method that returns the
        first unique (non-repeating) element
         */

        String str = "a green apple";
        char result = findFirstUniqueCharacter(str);
        System.out.println(result);

        /*
        Given a String of characters, define a method that returns the
        first repeated element
         */

        result = findFirstRepeatedCharacter(str);
        System.out.println(result);

    }

    private static char findFirstRepeatedCharacter(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }

    public static char findFirstUniqueCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch : chars) {
            if (map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }
}
