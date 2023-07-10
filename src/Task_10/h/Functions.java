package Task_10.h;

/**
 * 10h. Funktionen
 * Eine mathematische Funktion f bildet eine Zahl x, den Parameter, auf eine
 * neue Zahl f (x), den Funktionswert, ab. Aus der Sicht von Java kann das
 * durch eine Methode mit dem Kopf
 *     double map(double x)
 * ausgedrückt werden.
 * Definieren Sie eine abstrakte Basisklasse Function mit dieser Methode.
 * Eine Parabel ist eine Funktion der Form f(x) = ax² + bx + c. Definieren
 * SieeineKlasse Parabel, die von Function abgeleitet ist und deren Konstruktor
 * a, b und c akzeptiert.
 * Definieren Sie ebenso eine Klasse Hyperbel für Funktionen der Form
 * f(x) = a/x.
 * Eine Funktion kann in einer Wertetabelle grob dargestellt werden, die
 * für eine Reihe von x-Werten in regelmäßigen Abständen jeweils den
 * Funktionswert f (x) auflistet. Definieren Sie in der passenden Klasse eine
 * Methode print, die drei Parameter akzeptiert (kleinster x-Wert, größter
 * x-Wert, Abstand zwischen zwei x-Werten) und die eine derartige Wertetabelle
 * ausdruckt.
 * Zwei Funktionen f und g können verkettet werden. Die Verkettung ist
 * eine neue Funktion h(x) = g(f (x)). Definieren Sie eine Klasse Composed,
 * die von Function abgeleitet ist und im Konstruktor zwei andere Funktionen
 * akzeptiert, deren Verkettung sie repräsentiert.
 * Schreiben Sie eine Anwendung, die die Funktion [] erzeugt
 * und deren Wertetabelle im Bereich -5 <= x <= +5 in Schritten von 1/10
 * ausgibt.
 * Die (punktweise mathematische) Ableitung einer Funktion kann approximiert
 * werden durch []
 * für ein hinreichend kleines d. Definieren Sie eine Klasse Derivation, die
 * von Function (programmiersprachlich) abgeleitet ist und eine andere Funktion
 * f im Konstruktor akzeptiert, deren (punktweise mathematische) Ableitung
 * sie repräsentiert. Weiter akzeptiert der Konstruktor ein festes d als
 * zweiten Parameter.
 * Schreiben Sie eine weitere Anwendung, die eineWertetabelle der zweiten
 * Ableitung von f (x) = 1/x2-2x+2
 * im Bereich -5 <= x <= +5 in Schritten von 1/10 ausgibt.
 */
public abstract class Functions {

    abstract double map(double x);

    void evaluate(double minX, double maxX, double stepWidth){
        System.out.print("| x-value\t | y-value \t |\n");
        for (double i = minX; i < maxX; i += stepWidth) {
            System.out.printf("| %.3f \t | %.3f \t |\n", i, map(i));
        }
        System.out.println();

    }
}

class Parable extends Functions{

    private final double a;
    private final double b;
    private final double c;

    public Parable(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double map(double x) {
        return a * x * x + b * x + c;
    }
}

class Hyperbole extends Functions{

    private final double a;

    public  Hyperbole(double a){
        this.a = a;
    }

    @Override
    double map(double x) {
        return a / x;
    }
}

class Composed extends Functions{

    private final Functions fstFunction;
    private final Functions sndFunction;

    public Composed(Functions fstFunction, Functions sndFunction){
        this.fstFunction = fstFunction;
        this.sndFunction = sndFunction;
    }

    @Override
    double map(double x) {
        return sndFunction.map(fstFunction.map(x));
    }
}

class MainClass{
    public static void main(String[] args) {
        Functions functions = new Parable(1,1,0);
        functions.evaluate(0.1, 1, 0.1);

        Functions functions1 = new Hyperbole(3);
        functions1.evaluate(0.5, 2, 0.3);

        Functions functions2 = new Composed(functions1, functions);
        functions2.evaluate(-5, 5, 0.1);
    }
}