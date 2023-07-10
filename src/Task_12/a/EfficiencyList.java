package Task_12.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 12a. Effizienz von Listenoperationen
 * Schreiben Sie ein Testprogramm, das die Effizienz von ArrayList und
 * LinkedList gegenüberstellt. Vergleichen Sie folgende Operationen für ein
 * hinreichend großes N, wie zum Beispiel 50000:
 * Anfügen von N Elementen an das Ende;
 * Einschieben von N Elementen am Anfang;
 * sequenzieller Zugriff auf jedes der N Elemente über den Index;
 * sequenzieller Zugriff auf jedes der N Elemente über einen Iterator;
 * N-maliges Löschen des jeweils ersten Elementes über den Index;
 * N-maliges Löschen des jeweils ersten Elementes über einen Iterator.
 * Die Laufzeit eines Codefragmentes kann folgendermaßen bestimmt werden:
 *     long start = System.currentTimeMillis();
 *     ... Code, dessen Laufzeit gemessen werden soll ...
 * System.out.println(System.currentTimeMillis()-start);
 */
public class EfficiencyList {

    public static int N = 50_000;

    public static void main(String[] args) {


        final List<Integer> testArrayList = new ArrayList<>();

        final List<Integer> testLinkedList = new LinkedList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            testArrayList.add(1);
        }

        System.out.println("ArrayList ::: ADD function: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            testLinkedList.add(1);
        }

        System.out.println("LinkedList ::: ADD function: " + (System.currentTimeMillis() - start));

        testArrayList.clear();
        testLinkedList.clear();

        start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            testArrayList.add(0, 1);
        }

        System.out.println("ArrayList ::: INSERT function: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            testLinkedList.add(0, 1);
        }

        System.out.println("LinkedList ::: INSERT function: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        int counter = 0;

        for (int i = 0; i < N; i++) {
            counter += testArrayList.get(i);
        }

        System.out.println("ArrayList ::: GET function (counter= " + counter + "): " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        counter = 0;

        for (int i = 0; i < N; i++) {
            counter += testLinkedList.get(i);
        }

        System.out.println("LinkedList ::: GET function (counter= " + counter + "): " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        counter = 0;

        for (int i : testArrayList) {
            counter += i;
        }

        System.out.println("ArrayList ::: GET ITERATOR function (counter= " + counter + "): " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        counter = 0;

        for (int i : testLinkedList) {
            counter += i;
        }

        System.out.println("LinkedList ::: GET ITERATOR function (counter= " + counter + "): " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();


        for (int i = 0; i < N; i++) {
            testArrayList.remove(0);
        }

        System.out.println("ArrayList ::: REMOVE function: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();


        for (int i = 0; i < N; i++) {
            testLinkedList.remove(0);
        }

        System.out.println("LinkedList ::: REMOVE function: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();


        for (int i : testArrayList) {
            testArrayList.remove(i);
        }

        System.out.println("ArrayList ::: REMOVE ITERATOR function: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();


        for (int i : testLinkedList) {
            testLinkedList.remove(i);
        }

        System.out.println("LinkedList ::: REMOVE ITERATOR function: " + (System.currentTimeMillis() - start));




    }

}
