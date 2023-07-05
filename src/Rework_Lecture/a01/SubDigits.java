package Rework_Lecture.a01;

public class SubDigits {

    /**
     * Main method.
     * @param args - [0] contains haystack
     *             [1] contains needle
     */
    public static void main(String[] args) {


        String haystack = String.valueOf(args[0]);
        String needle = String.valueOf(args[1]);

        needle.chars()
                .mapToObj(c -> (char) c)
                .map(haystack::indexOf)
                .reduce((f, s) -> f < s? f: -1)
                .ifPresent(integer -> System.out.println(integer == 0));

    }

}
