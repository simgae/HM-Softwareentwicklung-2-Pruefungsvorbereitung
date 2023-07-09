package Thread_Tasks;

import java.util.stream.IntStream;

public class Task_1_1_1 {

    public static void main(String[] args) {

        Runnable flagWaver = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread() + "  :::  " + "wave flag");
            }
        };

        IntStream.range(0, 2)
                .mapToObj(n -> n % 2 == 0? new Thread(new Captain("wink")): new Thread(flagWaver))
                .forEach(Thread::start);


    }

}

record MyThread(String message) implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread() + "  :::  " + message);
        }
    }
}
