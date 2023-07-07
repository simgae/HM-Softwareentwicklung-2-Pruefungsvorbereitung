package Task_10.c;

public class Parallel extends Net{

    private final Net fst;
    private final Net snd;

    public Parallel(Net fst, Net snd){
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    double ohm() {
        return fst.ohm() + snd.ohm();
    }

    @Override
    int resistors() {
        return fst.resistors() + snd.resistors();
    }
}
