package Task_10.b;

public class Salami extends Topping{

    public Salami(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return 225 + getPizza().getPrice();
    }

    @Override
    public boolean isVegetable() {
        return false;
    }

    @Override
    public boolean isHot() {
        return true;
    }
}
