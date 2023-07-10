package Task_11.b;

public class SaveCarriage {

    private final int length;
    private final int capacity;
    private SaveCarriage carriage;

    /**
     * CTOR
     *
     * @param length   of the carriage
     * @param capacity of the carriage
     * @param carriage the next carriage
     */

    public SaveCarriage(int length, int capacity, SaveCarriage carriage) {

        if(length <= 0 || capacity < 0)
            throw new IllegalArgumentException("Invalid value");

        this.length = length;
        this.capacity = capacity;
        this.carriage = carriage;
    }

    public SaveCarriage setCarriage(SaveCarriage carriage) {
        this.carriage = carriage;
        return this;
    }

    /**
     * GETTER
     *
     * @return the next carriage
     */
    public SaveCarriage getCarriage() {
        return carriage;
    }

    /**
     * GETTER
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * GETTER
     *
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * CREATE INFORMATION STRING
     *
     * @return information string
     */
    @Override
    public String toString() {
        String result;
        if (getCarriage() != null)
            result = "Carriage{" +
                    "length=" + length +
                    ", capacity=" + capacity +
                    ", carriage=" + carriage.toString() +
                    '}';
        else
            result = "Carriage{" +
                    "length=" + length +
                    ", capacity=" + capacity +
                    '}';
        return result;
    }
}