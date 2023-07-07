package Task_10.b;

public abstract class Topping implements Pizza {

    private final Pizza pizza;

    public Topping(Pizza pizza){
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }
}
