package Thread_Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Synchro {

    static int counter = 0;
    static List<Integer> list = new ArrayList<>();

    record MyThreadSynchro() implements Runnable{
        @Override
        public void run() {

            synchronized ("Monitor"){
                counter++;
                System.out.println("Before sleeping: " + counter);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("After sleeping: " + counter);
                list.add(counter);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {


        System.out.println("Starting counting...");


        List<Thread> threads = new ArrayList<>(IntStream.range(0, 100)
                .mapToObj(n -> new Thread(new MyThreadSynchro()))
                .peek(Thread::start)
                .toList());

        while (threads.size() > 0){
            threads.removeIf(thread -> !thread.isAlive());
        }

        System.out.println(list);


    }

}


