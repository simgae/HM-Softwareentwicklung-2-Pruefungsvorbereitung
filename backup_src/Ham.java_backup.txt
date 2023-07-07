package Task_10.b;

public class Ham extends Topping{

    public Ham(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return 245 + getPizza().getPrice();
    }

    @Override
    public boolean isVegetable() {
        return false;
    }

    @Override
    public boolean isHot() {
        return getPizza().isHot();
    }
}
