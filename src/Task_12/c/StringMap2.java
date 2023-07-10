package Task_12.c;

import java.util.Set;

/**
 * 12c. ZweidimensionaleMaps
 * Die Maps im Package java.util bilden Elemente des Schlüsseltyps auf
 * Elemente des Wertetyps ab. Zur Vereinfachung wird in dieser Aufgabe als
 * Schlüssel- und Wertetyp nur String benutzt. Der Typ StringMap2 bildet
 * jeweils zwei Schlüssel-Strings auf einen Wertestring ab. Er funktioniert wie
 * eine Art "zweidimensionaler" Map, vergleichbar mit einem zweidimensionalen
 * Array. Die Schlüssel-Strings werden im Folgenden als "Zeilen-" und
 * "Spaltenschlüssel" bezeichnet, obwohl diese Bezeichnung technisch keine
 * Bedeutung hat. Zum Beispiel könnte der Zeilenschlüssel ein Studentenname,
 * der Spaltenschlüssel ein Prüfungsfach und der Wert eine Note sein:
 *                         Raketenbau  Lyrik   Finanzmathematik
 *     Daniel Düsentrieb   1.3         3.7
 *     Micky Mouse                             5
 *     Minnie Mouse                    1.7     -
 *     Dagobert Duck       4.0                 1.0
 *
 *     Daniel Düsentrieb, Raketenbau => 1.3
 *     Daniel Düsentrieb, Lyrik => 3.7
 *     Micky Mouse, Finanzmathematik => 5
 *     Minnie Mouse, Lyrik => 1.7
 *     Minnie Mouse, Finanzmathematik => -
 *     Dagobert Duck, Raketenbau => 4.0
 *     Dagobert Duck, Finanzmathematik => 1.0
 * Das Interface definiert die folgenden Methoden:
 *     String put(String row, String column, String value) Fügt value in
 *         Zeile row,
 *         Spalte column ein. Wenn dort schon ein Wert stand, wird er
 *         überschrieben. row und column dürfen null sein. Liefert den alten Wert an
 *         dieser Position oder null, wenn dort noch keiner stand.
 *     String get(String row, String col) Liefert den Wert in Zeile row, Spalte
 *         column. Wenn dort kein Wert eingetragen ist, ist das Ergebnis null.
 *     int size() Liefert die Anzahl der Einträge in der ganzen Datenstruktur.
 *     int size(String row) Liefert die Anzahl der Einträge in Zeile row oder 0,
 *         wenn die Zeile nicht existiert.
 *     boolean contains(String row, String col) Gibt Auskunft, ob in Zeile row,
 *         Spalte column ein Wert eingetragen ist (true) oder nicht (false).
 *     SetString keySet() Liefert die Menge der Zeilenschlüssel.
 *     SetString keySet(String row) Liefert die Menge der Spaltenschlüssel in
 *         Zeile row oder null, wenn der Zeilenschlüssel nicht existiert.
 * Definieren Sie das Interface und implementieren Sie es dann in der
 * konkreten Klasse TrueStringMap2.
 */
public interface StringMap2 {

    String put(String row, String column, String value);

    String get(String row, String col);

    int size();

    int size(String row);

    boolean contains(String row, String col);

    Set<String> keySet();

    Set<String> keySet(String row);

}
