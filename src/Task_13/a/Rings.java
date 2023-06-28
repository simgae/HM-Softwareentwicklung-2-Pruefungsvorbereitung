package Task_13.a;
public class Rings {

    public static <T> void removeAll(Ring<T> ring, T x){
        for (int i = 0; i <= ring.capacity(); i++) {


            if (ring.get() != null){
                ring.back();
                if (ring.size() != 0 && ring.get().equals(x)){
                    ring.back();
                    ring.remove();
                }
            }
        }

        ring.back();
    }

    public static <T> void removeLess(Ring<T> ring, T x){
        for (int i = 0; i < ring.capacity(); i++) {

            if(ring.get() != null){
                ring.back();

                T valueOne = ring.get();
                ring.back();

                if (valueOne instanceof Integer value && x instanceof Integer intx){
                    if (value.compareTo(intx) < 0)
                        ring.remove();
                    else ring.get();
                }
            }

        }
    }

    public static <T> Ring<T> revert(Ring<T> ring){

        Ring<T> reverted = new Ring<>(ring.capacity());

        ring.back();
        for (int i = 0; i < ring.capacity(); i++) {

            T value = ring.get();
            ring.back();
            ring.back();

            reverted.add(value);
            reverted.get();
        }
        return reverted;
    }

    public static <T> Ring<T> merge(Ring<T> ring1, Ring<T> ring2){

        Ring<T> merged = new Ring<>(ring1.capacity() + ring2.capacity());

        for (int i = 0; i < ring1.capacity(); i++) {

            T value = ring1.get();

            if (value != null){
                merged.add(value);
                merged.get();
            }
        }

        for (int i = 0; i < ring2.capacity(); i++) {

            T value = ring2.get();

            if (value != null){
                merged.add(value);
                merged.get();
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        Ring<Integer> ring = new Ring<>(3);
        ring.add(1);
        ring.back();
        ring.add(2);

        Ring<Integer> ring2 = new Ring<>(1);
        ring2.add(3);

        System.out.println(ring);
        System.out.println(ring2);
        System.out.println(Rings.merge(ring, ring2));
    }
}
