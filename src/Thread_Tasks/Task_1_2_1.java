package Thread_Tasks;

import java.util.ArrayList;
import java.util.List;

public class Task_1_2_1 {

    public static void main(String[] args) throws InterruptedException {

        List<String> input = List.of(args);

        List<List<String>> data = new ArrayList<>();

        for (String value: input) {
            data.add(List.of(value.substring(0, value.length()-1), value.substring(value.length()-1)));
        }

        int seconds = calculateSeconds(data);

        Thread.sleep(seconds * 1_000L);

    }


    public static void dataCheck(List<List<String>> data){
        for (List<String> value: data) {

            if(value.size() != 2){
                System.out.println("Exit, wrong length");
                System.exit(1);
            }

            try {
                TimeUnits.valueOf(value.get(1));
            } catch (IllegalArgumentException e){
                System.out.println("Exit, wrong unit");
                System.exit(1);
            }
        }
    }


    public static int calculateSeconds(List<List<String>> data){

        dataCheck(data);

        int seconds = 0;

        for(List<String> value: data){
            if(value.get(1).equals(TimeUnits.s.name()))
                seconds += Integer.parseInt(value.get(0));
            else if(value.get(1).equals(TimeUnits.m.name()))
                seconds += Integer.parseInt(value.get(0)) * 60;
            else if(value.get(1).equals(TimeUnits.h.name()))
                seconds += Integer.parseInt(value.get(0)) * 60 * 60;
            else if(value.get(1).equals(TimeUnits.d.name()))
                seconds += Integer.parseInt(value.get(0)) * 60 * 60 * 24;
            else
                System.exit(1);
        }

        return seconds;

    }
}
