package srpfacadelab;

public class HealthCalculator extends RpgPlayer{

    public HealthCalculator(IGameEngine gameEngine) {
        super(gameEngine);
    }

    protected void calculateStats() {
        for (Item i: inventory) {
            armour += i.getArmour();
        }
    }

    public void takeDamage(int damage) {
        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - armour;
        if (super.inventoryResponsibility.calculateInventoryWeight() < .5 * carryingCapacity)
            damageToDeal *= .75;
        health -= damageToDeal;

        gameEngine.playSpecialEffect("lots_of_gore");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    void setArmour(int armour) {
        this.armour = armour;
    }
}