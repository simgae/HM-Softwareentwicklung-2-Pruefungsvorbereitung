package Task_11.b;

import java.util.Objects;

public class SaveLocomotive {

    private final int length;
    private final int typ;
    private SaveCarriage carriage;

    /**
     * CTOR
     *
     * @param length of the locomotive
     */
    public SaveLocomotive(int length, int typ) {

        if(length <= 0)
            throw new IllegalArgumentException("Invalid value!");

        this.length = length;
        this.typ = typ;
        this.carriage = null;
    }

    /**
     * SETTER
     *
     * @param carriage new carriage
     * @return this
     */
    public SaveLocomotive setCarriage(SaveCarriage carriage) {
        this.carriage = carriage;
        return this;
    }

    /**
     * GETTER
     *
     * @return the carriage on the train
     */
    public SaveCarriage getCarriage() {
        return carriage;
    }

    /**
     * GETTER
     *
     * @return length of the train
     */
    public int getLength() {
        return length;
    }

    /**
     * GETTER
     *
     * @return type of the train
     */
    public int getTyp() {
        return typ;
    }

    /**
     * CREATE INFORMATION STRING
     *
     * @return information string
     */
    @Override
    public String toString() {
        String result;
        if (carriage != null)
            result = "Locomotive{" +
                    "length=" + length +
                    ", typ=" + typ +
                    ", carriage=" + carriage.toString() +
                    '}';
        else
            result = "Locomotive{" +
                    "length=" + length +
                    ", typ=" + typ +
                    '}';
        return result;
    }
}