package srpfacadelab;
import java.util.List;

public class Facade {
    private final IGameEngine gameEngine;
    private RpgPlayer player;

    public Facade(IGameEngine gameEngine){
        this.gameEngine = gameEngine;
        player = new RpgPlayer(gameEngine);
    }

    public static void useItem(Item item) {
        player.itemUsage.useItem(item);
    }

    public static boolean pickUpItem(Item item) {
        return player.itemUsage.pickUpItem(item);
    }

    private boolean checkIfItemExistsInInventory(Item item) {
        return player.itemUsage.checkIfItemExistsInInventory(item);
    }

    private int calculateInventoryWeight() {
        return player.inventoryResponsibility.calculateInventoryWeight();
    }

    public int getCarryingCapacity() {
        return player.inventoryResponsibility.getCarryingCapacity();
    }

    private void setCarryingCapacity(int carryingCapacity) {
        player.inventoryResponsibility.setCarryingCapacity(carryingCapacity);
    }

    private void calculateStats() {
        player.healthCalculator.calculateStats();
    }

    public static void takeDamage(int damage) {
        player.healthCalculator.takeDamage(damage);
    }

    public int getHealth() {
        return player.healthCalculator.getHealth();
    }

    public void setHealth(int health) {
        player.healthCalculator.setHealth(health);
    }

    public int getMaxHealth() {
        return player.healthCalculator.getMaxHealth();
    }

    public void setMaxHealth(int maxHealth) {
        player.healthCalculator.setHealth(maxHealth);
    }

    public int getArmour() {
        return player.healthCalculator.getArmour();
    }

    public void setArmour(int armour) {
        player.healthCalculator.setArmour(armour);
    }
}