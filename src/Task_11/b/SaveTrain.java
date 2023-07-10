package Task_11.b;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SaveTrain {
    /**
     * locomotive of the train
     */
    private final SaveLocomotive locomotive;

    /**
     * CTOR to initialize a train
     *
     * @param locomotive the locomotive of the train
     */
    public SaveTrain(SaveLocomotive locomotive) {

        Objects.requireNonNull(locomotive);

        this.locomotive = locomotive;

    }

    /**
     * Add a new carriage to the train
     *
     * @param length   of the carriage
     * @param capacity of the carriage
     * @return the train
     */
    public SaveTrain add(int length, int capacity) {

        if(length <= 0 || capacity < 0)
            throw new IllegalArgumentException("Invalid value!");

        Objects.requireNonNull(getLocomotive());

        getLocomotive().setCarriage(new SaveCarriage(length, capacity, getLocomotive().getCarriage()));

        assert getLocomotive().getCarriage() != null;

        return this;
    }

    /**
     * Create information string about the complete train
     */
    public void print() {
        System.out.println(this);
    }

    /**
     * Sum up all the capacity for passengers in the train
     *
     * @return complete capacity
     */
    public int getPassengers() {

        Objects.requireNonNull(getLocomotive());

        SaveCarriage carriage = getLocomotive().getCarriage();

        int result = 0;
        while (carriage != null) {
            result += carriage.getCapacity();
            carriage = carriage.getCarriage();
        }

        assert result >= 0;

        return result;
    }

    /**
     * calculate the whole length of the train
     *
     * @return length
     */
    public int getLength() {

        Objects.requireNonNull(getLocomotive());

        int result = getLocomotive().getLength();
        SaveCarriage carriage = getLocomotive().getCarriage();

        while (carriage != null) {
            result += carriage.getLength();
            carriage = carriage.getCarriage();
        }

        assert result >= getLocomotive().getLength();

        return result;
    }

    /**
     * Remove the first carriage
     *
     * @return the removed carriage
     */
    public SaveCarriage removeFirst() {

        Objects.requireNonNull(getLocomotive());

        final SaveCarriage fstCarriage = getLocomotive().getCarriage();

        if (fstCarriage != null) {
            final SaveCarriage restTrain = fstCarriage.getCarriage();
            fstCarriage.setCarriage(null);
            getLocomotive().setCarriage(restTrain);

        } else
            throw new NoSuchElementException("No first carriage");

        return fstCarriage;

    }

    /**
     * add all carriages of the snd train to the first and remove them from the snd train
     *
     * @param train snd train
     * @return modified train
     */
    public SaveTrain relink(SaveTrain train) {

        Objects.requireNonNull(getLocomotive());
        Objects.requireNonNull(train.getLocomotive());

        while (train.getLocomotive().getCarriage() != null) {
            final SaveCarriage removed = train.removeFirst();
            add(removed.getLength(), removed.getCapacity());
        }

        assert train.getLength() == train.getLocomotive().getLength();

        return this;
    }

    /**
     * Revert the carriage order
     *
     * @return new train with reverted order
     */
    public SaveTrain revert() {

        Objects.requireNonNull(getLocomotive());

        final SaveTrain result = new SaveTrain(new SaveLocomotive(getLocomotive().getLength(), getLocomotive().getTyp()));

        while (getLength() != getLocomotive().getLength()) {
            final SaveCarriage removed = removeFirst();
            result.add(removed.getLength(), removed.getCapacity());
        }

        assert result.getLocomotive() != null;

        return result;
    }

    /**
     * GETTER
     *
     * @return locomotive
     */
    public SaveLocomotive getLocomotive() {
        return locomotive;
    }

    /**
     * CREATE INFORMATION STRING
     *
     * @return information string
     */
    @Override
    public String toString() {
        return locomotive.toString();
    }

    /**
     * MAIN METHOD
     *
     * @param args arguments
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void main(String[] args) {


        try{
            final SaveLocomotive bigChief = new SaveLocomotive(23, 5311);
            final SaveTrain santaFe = new SaveTrain(bigChief);

            santaFe.add(12, 50).add(15, 75).add(20, 100);

            final SaveLocomotive steelHorse = new SaveLocomotive(21, 5409);
            final SaveTrain rioGrandeExpress = new SaveTrain(steelHorse);

            rioGrandeExpress.add(12, 60).add(18, 80);


            rioGrandeExpress.relink(santaFe);

            rioGrandeExpress.revert();
        }  catch (RuntimeException e){
            e.printStackTrace();
        }


    }


}