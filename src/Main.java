import srpfacadelab.*;


public class Main {

    public static void main(String[] args) {
        //This is meant to be simple and just show how you could instantiate the structure

        IGameEngine game = new SimpleGameEngine();
        RpgPlayer player1 = new RpgPlayer(game);
        RpgPlayer player2 = new RpgPlayer(game);
        ((SimpleGameEngine) game).addPlayer(player1);
        ((SimpleGameEngine) game).addPlayer(player2);

        //Here you would create items
        Item axe = new Item(1, "Axe", 0, 2, 8, false, false);
        Item shield = new Item(2, "Shield", 0, 5, 3, false, false);
        Item key = new Item(3, "Key", 0, 0, 0, true, true);
        Item medicine = new Item(4, "Medicine", 4, 0, 0, false, false);

        //Here you would tell the history and make the game happen


        //You could make players pick up items
        Facade.pickUpItem(player1, axe);
        //You could make players use items
        //etc.
        //You don't need to worry about it for the assignment
        //This is only to show how the 'external world' would instantiate the structure.
        //In the assignment, you're supposed to improve the design and not instantiate a game
    }
}
