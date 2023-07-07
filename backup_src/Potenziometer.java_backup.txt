package Task_10.c;

public class Potenziometer extends Net{

    private double ohm;

    public Potenziometer(double ohm){
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

    public Potenziometer setOhm(double ohm) {
        this.ohm = ohm;
        return this;
    }
}
