package Task_13.b;

import java.util.Objects;

/**
 * 13b. Paare
 * Manche Methoden sollten zwei Werte als Ergebnis an den Aufrufer zurückliefern.
 * Denken Sie beispielsweise an den Elementzugriff in einer Map mit
 * der Methode get. Wenn kein Eintrag in der Map gefunden wird, liefert get
 * den Fluchtwert null. Allerdings kann null auch der Wert eines regulären
 * Eintrages sein. Um den Unterschied zu erkennen, muss noch die Methode
 * containsKey aufgerufen werden.
 * Alternativ könnte eine einzige Zugriffsmethode zwei Werte zusammen
 * zurückliefern, ein Erfolgssignal und einen Wert (der nur bei einem positiven
 * Erfolgssignal von Bedeutung ist). Allerdings können Methoden in Java
 * nur einen Wert liefern.
 * In diesem Fall ist eine unveränderliche Klasse Pair nützlich, die zwei Werte
 * zusammenschnürt. Die Typen der beiden gebündelten Werte sind unabhängig,
 * deshalb wird Pair eine generische Klasse mit zwei Typparametern T
 * und U sein. Neben dem Konstruktor reichen zwei Getter und die Methoden
 * toString, equals und hashCode aus.
 * Definieren Sie die generische Klasse Pair.
 */
public class Pair <T, U>{

    private final T fstElement;
    private final U sndElement;


    public Pair (T fstElement, U sndElement){
        this.fstElement = fstElement;
        this.sndElement = sndElement;
    }

    public T getFstElement() {
        return fstElement;
    }

    public U getSndElement() {
        return sndElement;
    }

    @Override
    public String toString() {
        return "(" + fstElement + ", " + sndElement + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(fstElement, pair.fstElement) && Objects.equals(sndElement, pair.sndElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fstElement, sndElement);
    }
}

class Testing{
    public static void main(String[] args) {
        Pair<String, String> pair = new Pair<>("Hello", "World");
        System.out.println(pair);
        System.out.println(pair.getFstElement());
        System.out.println(pair.getSndElement());

        Pair<String, String> pair2 = new Pair<>("Hello", "World");
        Pair<String, String> pair3 = new Pair<>("Test", "World");

        System.out.println(pair.equals(pair2));
        System.out.println(pair.equals(pair3));


    }
}
