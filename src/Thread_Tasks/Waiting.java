package Thread_Tasks;

import java.util.stream.IntStream;

public class Waiting {


    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        System.out.println("Hello from:" + mainThread);

        IntStream.range(0, 100)
                .parallel()
                .mapToObj(n -> new Thread(new MyThreadCommunication()))
                .peek(Thread::start)
                .forEach(n -> {
                    try {
                        n.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        System.out.println("End of: " + mainThread);
    }

}

record MyThreadCommunication() implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from:" + Thread.currentThread());
    }
}
