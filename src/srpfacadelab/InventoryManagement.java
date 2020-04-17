package srpfacadelab;
import java.util.List;

public class InventoryManagement {

    public static void addToInventory(RpgPlayer player, Item item) {
        player.getInventory().add(item);
    }

    public static boolean checkIfItemExistsInInventory(RpgPlayer player, Item item) {
        for (Item i: player.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public static int calculateInventoryWeight(RpgPlayer player) {
        int sum=0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }
}