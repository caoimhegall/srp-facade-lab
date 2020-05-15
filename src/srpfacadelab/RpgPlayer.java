package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;
    private final IGameEngine gameEngine;
    private int health;
    private int maxHealth;
    private int armour;
    private List<Item> inventory;
    // How much the player can carry in pounds
    private int carryingCapacity;

    public ItemUsage itemUsage;
    public InventoryResponsibility inventoryResponsibility;
    public HealthCalculator healthCalculator;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new ArrayList<Item>();
        carryingCapacity = MAX_CARRYING_CAPACITY;
        inventoryResponsibility = new InventoryResponsibility(gameEngine);
        itemUsage = new ItemUsage(gameEngine);
        healthCalculator = new HealthCalculator(gameEngine);
    }
}
