package Task_13.a;

import java.util.NoSuchElementException;

public class Ring<T> {

    private final T[] ring;
    int acutalElement = 0;


    public Ring (int cap){

        if (cap < 0)
            throw new IllegalArgumentException();

        this.ring = (T[]) new Object[cap];
    }

    public int size(){
        int counter = 0;

        for (T t : ring) {
            if (t != null)
                counter++;
        }

        return counter;
    }

    public int capacity(){
        return ring.length;
    }

    public int add(T t){

        if (size() == capacity())
            throw new IllegalArgumentException();

        ring[(acutalElement + 1) % ring.length] = t;

        return (acutalElement + 1) % ring.length;
    }

    public void back(){
        if (size() == 0)
            throw new NoSuchElementException();

        acutalElement--;

        if (acutalElement < 0)
            acutalElement = capacity() - 1;
    }

    public void remove(){
        if (size() == 0)
            throw new NoSuchElementException();

        ring[acutalElement] = null;

        acutalElement++;

        if(acutalElement >= capacity())
            acutalElement = acutalElement % ring.length;
    }

    public void set(T t){
        if (size() == 0)
            throw new NoSuchElementException();

        ring[acutalElement] = t;

        acutalElement++;
        if (acutalElement >= capacity())
            acutalElement = acutalElement % ring.length;
    }

    public T get(){

        T result = ring[acutalElement % ring.length];

        acutalElement++;
        if (acutalElement >= capacity())
            acutalElement = acutalElement % ring.length;

        return result;
    }

    @Override
    public String toString() {

        StringBuilder information = new StringBuilder();

        for (int i = 0; i < ring.length; i++) {
            if(i == acutalElement)
                information.append("-> *").append(ring[i]).append("* ");
            else
                information.append("-> ").append(ring[i]).append(" ");
        }

        return information.toString();
    }
}
