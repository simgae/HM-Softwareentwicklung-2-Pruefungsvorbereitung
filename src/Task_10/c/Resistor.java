package Task_10.c;


public class Resistor extends Net{


    private final double ohm;

    public Resistor(double ohm){
        this.ohm = ohm;
    }

    @Override
    double ohm() {
        return ohm;
    }

    @Override
    int resistors() {
        return 1;
    }
}
