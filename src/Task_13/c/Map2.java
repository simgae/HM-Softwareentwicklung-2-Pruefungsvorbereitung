package Task_13.c;

import Task_12.c.StringMap2;
import Task_12.c.TrueStringMap2;

import java.util.Set;

/**
 * 13c. ZweidimensionaleMaps, reloaded
 * In einer früheren Aufgabe (Seite 401) wurde eine Map entwickelt, die zwei
 * Strings auf einen dritten abbildet. Verallgemeinern Sie diese Lösung zu
 * einem generischen Interface Map2. Implementierungen von Map2 bilden
 * zwei Schlüssel beliebiger Typen T und U auf einen Wert eines dritten Typs
 * V ab.
 * Das Interface definiert die folgenden Methoden:
 *     V put(T row, U column, V value) fügt value in Zeile row, Spalte column ein.
 *         Wenn dort schon ein Wert stand, wird er überschrieben. row und
 *         column dürfen null sein. Die Methode liefert den alten Wert an dieser
 *         Position oder null, wenn dort noch keiner stand.
 *     V get(T row, U col) liefert den Wert in Zeile row, Spalte column.Wenndort
 *         kein Wert eingetragen ist, ist das Ergebnis null.
 *     int size() liefert die Anzahl der Einträge in der ganzen Datenstruktur.
 *     int size(T row) liefert die Anzahl der Einträge in Zeile row oder 0, wenn die
 *         Zeile nicht existiert.
 *     boolean contains(T row, U col) gibt Auskunft, ob in Zeile row, Spalte
 *         column ein Wert eingetragen ist (true) oder nicht (false).
 *     Set<T> keySet() liefert die Menge der Zeilenschlüssel.
 *     Set<U> keySet(T row) liefert die Menge der Spaltenschlüssel in Zeile row
 *     oder null, wenn der Zeilenschlüssel nicht existiert.
 * Begründen Sie, warum zusätzlich zu diesen Methoden die weiteren Methoden int
 * size(U column) und Set<V> keySet(U column) nicht definiert werden
 * können. Implementieren Sie das Interface in einer konkreten Klasse TrueMap2.
 */
public interface Map2 <T,U,V> {

    V put (T row, U column, V value);

    V get(T row, U col);

    int size();

    int size(T row);

    boolean contains(T row, U col);

    Set<T> keySet();

    Set<U> keySet(T row);
}

class Testing{

    public static void main(String[] args) {
        TrueMap2<String, String, String> map2 = new TrueMap2<>();
        System.out.println(map2);
        System.out.println(map2.put("Test Row", "Test Column", "Value"));
        System.out.println(map2);
        map2.put("Test Row", "Test 2", "Value");
        System.out.println(map2);
        map2.put("Test 2", "Test 2", "Value");
        System.out.println(map2);
        System.out.println(map2.get("Test Row", "Test 2"));
        System.out.println(map2.size());
        System.out.println(map2.size("Test Row"));
        System.out.println(map2.contains("Test Row", "Test 2"));
        System.out.println(map2.keySet());
        System.out.println(map2.keySet("Test 2"));
    }
}