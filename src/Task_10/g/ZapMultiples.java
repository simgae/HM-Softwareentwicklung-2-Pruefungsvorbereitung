package Task_10.g;

public class ZapMultiples extends Filter{


    private final int multiple;

    public ZapMultiples(Sequence sequence, int multiple) {
        super(sequence);
        this.multiple = multiple;
    }

    @Override
    public boolean hasNext() {
        return sequence.hasNext();
    }

    @Override
    public Integer next() {

        int value = sequence.next();

        if (value % multiple == 0)
            return null;

        return value;
    }
}
