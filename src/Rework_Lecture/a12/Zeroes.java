package Rework_Lecture.a12;

import java.util.Arrays;

public class Zeroes {

    public static int count0(int ... number){
        return (int) Arrays.stream(number)
                .filter(n -> n == 0)
                .count();
    }

}
