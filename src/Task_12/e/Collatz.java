package Task_12.e;

import java.util.Iterator;

/**
 * 12e. Collatz-Iterator
 * Die Collatzfolge ist auf Seite 82 beschrieben. Definieren Sie eine Klasse
 * Collatz, deren Konstruktor eine Startzahl als Argument erhält. Collatz-
 * Objekte sollen mit foreach-Schleifen durchlaufen werden können und dabei
 * nacheinander die Zahlen der Folge liefern. Eine 1 ist das letzte Element
 * einer Collatzfolge. Das Codefragment
 *     for(int i: new Collatz(6))
 *         System.out.println(i);
 * gibt aus
 *     6, 3, 10, 5, 16, 8, 4, 2, 1
 * Beachten Sie, dass mehrere Iteratoren gleichzeitig dasselbe Collatz-Objekt
 * durchlaufen können.
 */
public class Collatz implements Iterable<Integer>{

    private int start;
    private int run;

    public Collatz(int start){
        this.start = start;
        this.run = 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !(start == 1);
            }

            @Override
            public Integer next() {

                if (run == 1) {
                    run++;
                    return start;
                }

                if (start % 2 == 0)
                    start /= 2;
                else
                    start = 3 * start + 1;


                return start;
            }
        };
    }
}

class Testing{
    public static void main(String[] args) {
        for (int i : new Collatz(6))
            System.out.println(i);
    }
}
