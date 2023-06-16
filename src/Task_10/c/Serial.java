package Task_10.c;

public class Serial extends Net {

    private final Net fst;

    public Serial(Net fst){
        this.fst = fst;
    }

    @Override
    double ohm() {
        return fst.ohm();
    }

    @Override
    int resistors() {
        return fst.resistors();
    }
}
