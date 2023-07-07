package Rework_Lecture.a02;
public class Tac {


    /**
     * Main method
     *
     * @param args - [0] contain string
     */
    public static void main(String[] args) {

        """
                Start
                Middle
                End
        """
                .lines()
                .sorted((o1, o2) -> -1)
                .forEach(System.out::println);

    }
}
