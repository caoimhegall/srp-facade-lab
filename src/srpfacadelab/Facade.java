package srpfacadelab;
import java.util.List;

public class Facade {

    public static void useItem(RpgPlayer player, Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public static boolean pickUpItem(RpgPlayer player, Item item) {
        int weight = InventoryManagement.calculateInventoryWeight(player);
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && InventoryManagement.checkIfItemExistsInInventory(player, item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                player.getGameEngine().playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            player.getGameEngine().playSpecialEffect("cool_swirly_particles");

        if (item.isRare() && item.isUnique()) {
            player.getGameEngine().playSpecialEffect("blue_swirly");
        }

        InventoryManagement.addToInventory(player, item);

        player.calculateStats();

        return true;
    }

    public static void takeDamage(RpgPlayer player, int damage) {
        if (damage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();
        if(InventoryManagement.calculateInventoryWeight(player) < (player.getCarryingCapacity() * .5))
            damageToDeal *= .75;
        player.setHealth(player.getHealth() - damageToDeal);

        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }
}