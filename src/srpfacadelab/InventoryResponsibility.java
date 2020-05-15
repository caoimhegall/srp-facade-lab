package srpfacadelab;
import java.util.List;

public class InventoryResponsibility extends RpgPlayer{

    public InventoryResponsibility(IGameEngine gameEngine) {
        super(gameEngine);
    }

    public static int calculateInventoryWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}