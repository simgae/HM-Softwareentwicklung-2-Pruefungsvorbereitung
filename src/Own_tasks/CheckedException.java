package Own_tasks;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Own_tasks.CheckedException.BombingConsumer.tunnel;

public class CheckedException {

    @FunctionalInterface
    interface BombingConsumer<T> {
        void accept(T arg) throws Exception;
        static <T> Consumer<T> tunnel(BombingConsumer<T> bombingConsumer) {
            return arg -> {
                try {
                    bombingConsumer.accept(arg);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        }
    }



    public static void main(String... args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        final int pro = Runtime.getRuntime().availableProcessors();
        Stream.iterate(0, n -> n + 1)
                .limit(100)
                .unordered()
                .parallel()
                /*.peek(n -> {
                    try {
                        Thread.sleep(n);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })

                 */
                .peek(tunnel(Thread::sleep))
                .forEach(System.out::println);

        final long elapsed = System.currentTimeMillis() - start;
        System.out.println("elapsed: " + elapsed);
        System.out.println("Kerne: " + pro);
    }

}


