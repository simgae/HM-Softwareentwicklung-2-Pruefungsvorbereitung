package Task_10.g;


public class Evens extends Filter {

    public Evens(Sequence sequence) {
        super(sequence);
    }

    @Override
    public boolean hasNext() {
        return sequence.hasNext();
    }

    @Override
    public Integer next() {

        int value = sequence.next();

        if (value % 2 != 0)
            return null;

        return value;
    }
}
