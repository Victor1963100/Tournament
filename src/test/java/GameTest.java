import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void WhenFirstPlayerStrengtherTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Alexandr", 40);
        Player player2 = new Player(2, "Vladimir", 36);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Alexandr", "Vladimir");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenSecondPlayerStrengtherTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Alexandr", 36);
        Player player2 = new Player(2, "Vladimir", 40);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Alexandr", "Vladimir");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenBothPlayersAreEqualTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Alexandr", 40);
        Player player2 = new Player(2,"Vladimir", 40);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Alexandr", "Vladimir");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFistPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = null;
        Player player2 = new Player(2,"Vladimir", 40);

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Alexandr", "Vladimir");
        });
    }

    @Test
    public void testWhenSecondPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Alexandr", 40);
        Player player2 = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Alexandr", "Vladimir");
        });
    }

    @Test
    public void testWhenBothPlayersIsNotRegistered() {
        Game game = new Game();
        Player player1 = null;
        Player player2 = null;

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Alexandr", "Vladimir");
        });
    }
}
