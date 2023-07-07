package Task_10.b;

public class Chili extends Topping{

    public Chili(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return 95 + getPizza().getPrice();
    }

    @Override
    public boolean isVegetable() {
        return getPizza().isVegetable();
    }

    @Override
    public boolean isHot() {
        return true;
    }
}
