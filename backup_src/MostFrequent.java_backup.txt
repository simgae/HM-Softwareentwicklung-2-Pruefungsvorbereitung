package Rework_Lecture.a11;

import java.util.*;
public record MostFrequent(int value, int occurrences) {

    public MostFrequent{
        if (occurrences < 1)
            throw new IllegalArgumentException();
    }


    public static MostFrequent scan(int... array){

        Objects.requireNonNull(array);

        if(array.length == 0)
            throw new NoSuchElementException();

       List<Integer> list = Arrays.stream(array)
                .distinct()
                .mapToObj(n -> List.of(n, (int) Arrays.stream(array)
                        .filter(p -> n == p)
                        .count()))
               .max(Comparator.comparingInt(p -> p.get(1)))
               .orElse(List.of(0, 0));

       return new MostFrequent(list.get(0), list.get(1));
   }

    public static void main(String[] args) {

        int[] ints = new int[] {1,2,3,4,5,5,3,2,2};

        System.out.println(scan(ints));;
    }

}
