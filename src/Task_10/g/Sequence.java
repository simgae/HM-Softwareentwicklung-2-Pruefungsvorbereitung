package Task_10.g;

import java.util.Iterator;

/**
 * 10g. Zahlenfolgen
 * Schreiben Sie ein Java-Programm, das Zahlenfolgen modelliert. Zur
 * Vereinfachung werden nur Folgen ganzer Zahlen betrachtet.
 * Definieren Sie eine abstrakte Basisklasse Sequence für allgemeine
 * Zahlenfolgen. Sequence hat nur zwei Methoden:
 * hasNext gibt Auskunft, ob diese Folge noch weitere Elemente enthält
 * (true) oder nicht (false).
 * next liefert das nächste Element der Folge. Darf nur dann aufgerufen
 * werden, wenn hasNext das Ergebnis true geliefert hat.
 * Die natürlichen Zahlen (1, 2, 3, . . . ) sind eine konkrete Zahlenfolge. Leiten
 * Sie die Klasse Naturals von Sequence ab. Der erste Aufruf von next liefert
 * 1, der nächste 2,dann 3 und so weiter. hasNext liefert hier immer true.
 * Die Klasse Range repräsentiert die natürlichen Zahlen in einem bestimmten
 * Intervall. Der Konstruktor von Range erwartet zwei Argumente, den
 * Anfang und das Ende des Intervalls. Der erste Parameter nennt die erste
 * Zahl im Intervall, der zweite Parameter die erste Zahl hinter dem Intervall.
 * Zum Beispiel enthält die Folge Range(5, 10) dieZahlen5,6,7,8und9,
 * aber nicht mehr 10. Die Folge Range(5, 5) ist leer.
 * Definieren Sie an passender Stelle eine Methode print, die bis zu 10 Elemente
 * einer beliebigen Folge ausgibt. Wenn die Folge bloß 10 oder weniger Elemente
 * hat, wird anschließend das Wort end ausgegeben, ansonsten "more".
 * Ein "Filter" ist eine Zahlenfolge, die keine eigene Zahlenquelle enthält.
 * Ein Filter "ernährt" sich stattdessen von einer anderen Zahlenfolge, deren
 * Elemente er entweder durchlässt oder absorbiert. Welche Zahlen ein Filter
 * passieren lässt, legen erst konkrete Filterklassen fest.
 * Definieren Sie einen Typ Filter. Die Bedingung zum Schlucken oder
 * Durchlassen von Zahlen bleibt hier noch offen, deshalb ist Filter keine
 * konkrete Klasse.
 * Definieren Sie den Filter Evens, der gerade Zahlen weitergibt und ungerade
 * Zahlen entfernt. Zum Beispiel liefert
 * new Evens(new Naturals()) ==> 2, 4, 6, ...
 * Welche Zahlen enthält die nächste Folge?
 * new Evens(new Range(5, 10)) ==> ?
 * Definieren Sie einen Filter ZapMultiples. Dessen Konstruktor erwartet eine
 * Basiszahl. Der Filter absorbiert alle ganzzahligen Vielfachen der Basiszahl
 * und gibt den Rest weiter. Zum Beispiel ergibt
 * new ZapMultiples(new Naturals(), 3) ==> 1, 2, 4, 5, 7, 8, 10, ...
 * Alle Vielfachen von 3 fehlen. Welche Zahlen erzeugt diese Folge?
 * new ZapMultiples(new Evens(new Range(5, 10)), 2) ==> ?
 * Die nächste Folge hat ein Problem. Können Sie es ohne Hilfe eines Programms
 * vorhersagen?
 * new ZapMultiples(new Evens(new Naturals()), 2)
 */
public abstract class Sequence implements Iterator<Integer> {
    @Override
    public abstract boolean hasNext();

    @Override
    public abstract Integer next();

    public void print() {

        String result = "";

        for (int i = 0; i < 10; i++) {
            if (hasNext()) {
                try {
                    Integer value = next();
                    if (value != null)
                        result += " -> " + value;
                    else
                        i--;
                } catch (NullPointerException e) {
                    System.out.println(" ::: no values!");
                    return;
                }
            }
        }

        if (hasNext())
            result += " ::: more";
        else
            result += " ::: end";

        System.out.println(result);

    }
}


class Testing {
    public static void main(String[] args) {

        Sequence sequence1 = new Naturals();
        Sequence range1 = new Range(5, 10);

        sequence1.print();
        range1.print();

        Sequence evens = new Evens(new Naturals());
        Sequence evensRange = new Evens(new Range(5, 10));

        evens.print();
        evensRange.print();

        Sequence multiple = new ZapMultiples(new Naturals(), 3);
        multiple.print();

        Sequence mul = new ZapMultiples(new Range(5, 10), 2);
        mul.print();

        Sequence noSeq = new ZapMultiples(new Evens(new Naturals()), 2);
        noSeq.print();
    }
}
