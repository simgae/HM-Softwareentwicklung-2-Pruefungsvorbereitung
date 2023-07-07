package Task_10.b;

public class Onions extends Topping{

    public Onions(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return 65 + getPizza().getPrice();
    }

    @Override
    public boolean isVegetable() {
        return getPizza().isVegetable();
    }

    @Override
    public boolean isHot() {
        return getPizza().isHot();
    }
}
