package Rework_Lecture.a00;

import java.util.Comparator;
import java.util.stream.Collector;

public class ReverseDigits {

    /**
     * main method.
     * @param args - index 0 contains the number
     */
    public static void main(String[] args) {

        String number = String.valueOf(args[0]);

        number = number.chars().mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                ));

        System.out.println(number);
    }
}
