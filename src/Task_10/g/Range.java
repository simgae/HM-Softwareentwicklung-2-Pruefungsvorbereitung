package Task_10.g;

public class Range extends Sequence{

    private final int start;
    private final int end;

    private int counter;

    public Range(int start, int end){
        this.start = start;
        this.end = end;
        this.counter = start-1;
    }

    @Override
    public boolean hasNext() {
        return counter < end - 1;
    }

    @Override
    public Integer next() {
        counter++;
        return counter;
    }
}
