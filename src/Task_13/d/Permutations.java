package Task_13.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 13d. Permutationen
 * Definieren Sie eine generische Klasse Permutations<T>, deren Konstruktor
 * eine Anzahl Argumente vom Typ T akzeptiert. Permutations implementiert
 * eine Methode generate, die nacheinander alle Permutationen der Argumente
 * erzeugt.
 * Definieren Sie weiter ein Interface Receiver mit einer Methode
 *     void receive(List<T> args)
 * Die Methode generate erhält als Argument ein Receiver-Objekt und ruft mit
 * jeder generierten Permutation dessen receive-Methode auf.
 * Das Beispielprogramm
 *     Permutations<Integer> nums = new Permutations<>(1, 2, 3);
 *     nums.generate(new Receiver<Integer>() {
 *         public void receive(List<Integer> permutation) {
 *             System.out.println(permutation);
 *         }
 *     });
 * gibt aus:
 *     [1,2,3]
 *     [1,3,2]
 *     [2,1,3]
 *     [2,3,1]
 *     [3,1,2]
 *     [3,2,1]
 */
public class Permutations <T> {

    private final List<T> values = new ArrayList<>();

    @SafeVarargs
    public Permutations(T... values){
        this.values.addAll(List.of(values));
    }

    public List<List<T>> generate(){

        List<List<T>> result = new ArrayList<>();

        int amountOfPermutations = 1;

        for (int i = 1; i <= values.size(); i++) {
            amountOfPermutations *= i;
        }

        int counter = 0;

        while (counter < amountOfPermutations){

            Collections.shuffle(values);

            if(!result.contains(values)){
                result.add(values.stream().toList());
                counter++;
            }
        }

        return result;
    }

}

class Testing{
    public static void main(String[] args) {
        Permutations<Integer> integerPermutations = new Permutations<>(1,2,3);

        System.out.println(integerPermutations.generate());
    }
}
