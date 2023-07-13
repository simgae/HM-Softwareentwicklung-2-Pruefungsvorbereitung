package Task_10.g;

public class Naturals extends Sequence{

    private int counter;

    public Naturals()  {
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        counter++;
        return counter;
    }
}
