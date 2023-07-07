package Task_10.b;

public class Cheese extends Topping{
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return 195 + getPizza().getPrice();
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
