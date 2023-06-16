package Task_10.b;

public abstract class Bottom implements Pizza{

    @Override
    public boolean isVegetable() {
        return true;
    }

    @Override
    public boolean isHot() {
        return false;
    }
}
