package Task_10.b;

/**
 * 10b. Pizzen, Pizze und Pizzas
 * Das Interface Pizza repräsentiert ein Pizza. In dieser Aufgabe geht es um den
 * Preis einer Pizza, der sich aus der Summe der Preise der Bestandteile ergibt,
 * und um die Eigenschaften "vegetarisch" und "scharf".
 *     public interface Pizza {
 *         int getPrice(); // Preis in Cent
 *         boolean isVegetable(); // Pizza ist vegetarisch?
 *         boolean isHot(); // Pizza ist scharf?
 *     }
 * Eine Pizza besteht aus einem Pizzaboden (Klasse Bottom) und einer Auswahl
 * von Auflagen (Klasse Topping).
 * Definieren Sie die abstrakte Basisklasse Bottom für einen allgemeinen Pizzaboden.
 * Bottom implementiert das Interface Pizza. Leiten Sie von Bottom die
 * folgenden konkreten Klassen für bestimmte Pizzaböden ab:
 *     Crusty, Grundpreis 3,40 C
 *     Munchy, Grundpreis 3,95 C
 *     CuscinoSpeciale, Grundpreis 4,95 C
 * Jede Art von Pizzaboden trägt mit ihrem Grundpreis zum Gesamtpreis einer
 * Pizza bei. Arbeiten Sie in dieser Aufgabe nur mit ganzen Cent-Beträgen. Alle
 * Pizzaböden sind vegetarisch und keiner ist scharf. Verschieben Sie so viel
 * Code wie möglich in die Basisklasse und minimieren Sie den Umfang der
 * abgeleiteten Klassen.
 * Formal gilt ein bloßer Pizzaboden als Pizza, auch wenn diese aus kulinarischer
 * Sicht vielleicht nicht besonders attraktiv ist. Auf einen Pizzaboden
 * können beliebig viele Auflagen gestapelt werden. Die Reihenfolge der Auflagen
 * spielt hier keine Rolle.
 * Die abstrakte Basisklasse Topping ist die Grundlage für alle Pizzaauflagen.
 * Topping steht in zweifacher Beziehung zum Interface Pizza:
 * Zumeinen braucht jede Auflage eine Pizza, auf der sie liegt. Entsprechend
 * erwartet der Topping-Konstruktor ein Pizza-Objekt als Argument. Das ist
 * die Pizza, auf der die Auflage liegt.
 * Zum anderen ist eine Auflage samt allem, was darunterliegt, selbst eine
 * Pizza. Deshalb implementiert Topping das Interface Pizza.
 * Der folgende Rahmen zeigt diese Beziehungen:
 *     public abstract class Topping implements Pizza { // Auflage mit allem darunter
 *         private final Pizza below; // die Pizza darunter
 *         ...
 *     }
 * Leiten Sie von Topping verschiedene konkrete Klassen für Auflagen ab.
 *     Onions,0,65 C, vegetarisch, mild
 *     Ham,2,45 C, nicht vegetarisch, mild
 *     Salami,2,25 C, nicht vegetarisch, scharf
 *     Chili,0,95 C, vegetarisch, scharf
 *     Cheese,1,95 C, vegetarisch, mild
 * Eine Pizza ist als Ganzes vegetarisch, wenn alle Auflagen vegetarisch sind.
 * Sie ist scharf, wenn zwei oder mehr Auflagen scharf sind. Der Preis einer
 * Pizza ergibt sich aus der Summe der Preise der einzelnen Bestandteile.
 * Insgesamt ergibt sich folgende Struktur:
 * []
 */

/**
 * Define Pizza.
 */
public interface Pizza {

    /**
     * Calculate price.
     * @return price.
     */
    int getPrice();

    /**
     * Check if vegetable.
     * @return true if vegetable.
     */
    boolean isVegetable();

    /**
     * Check if pizza is hot.
     * @return true if pizza is hot.
     */
    boolean isHot();
}

class Testing{
    public static void main(String[] args) {

        Pizza pizza = new Chili(new Salami(new Onions(new Onions(new Crusty()))));

        System.out.println(pizza.getPrice());
        System.out.println(pizza.isVegetable());
        System.out.println(pizza.isHot());

    }
}
