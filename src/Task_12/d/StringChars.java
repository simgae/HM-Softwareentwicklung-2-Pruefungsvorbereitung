package Task_12.d;

import java.util.Iterator;

/**
 * 12d. String-Iterator
 * Definieren Sie eine Klasse StringChars, die die einzelnen Zeichen eines
 * Strings in einer foreach-Schleife verfügbar macht. Das folgende
 * Programmfragment zählt die kleinen Vokale in einem String:
 *     int vowels = 0;
 *     for(char c: new StringChars("Hello, world"))
 *         if("aeiou".indexOf(c) >= 0)
 *             vowels++;
 *     System.out.println(vowels); // 3
 * Beachten Sie, dass ein und dasselbe StringChars-Objekt von mehreren
 * Iteratoren gleichzeitig durchlaufen werden kann. Die folgende Methode stellt
 * fest, ob die Zeichen eines Strings alle nur einmal vorkommen:
 *     boolean charsAreUnique(String s) {
 *         StringChars chars = new StringChars(s);
 *         for(char c0: chars) {
 *             boolean me = false;
 *             for(char c1: chars)
 *                 if(c0 == c1)
 *                     if(me)
 *                         return false;
 *                     else
 *                         me = true;
 *         }
 *         return true;
 *     }
 */
public class StringChars implements Iterable<Character>{

    private final String string;
    private int index;

    public StringChars(String string){
        this.string = string;
        this.index = 0;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < string.length();
            }

            @Override
            public Character next() {
                char character = string.toCharArray()[index];
                index++;
                return character;
            }
        };
    }
}


class Testing{
    public static void main(String[] args) {
        StringChars stringChars = new StringChars("Hello, World!");

        for (Character character : stringChars){
            System.out.println(character);
        }
    }
}
