package ru.netology.Game.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game.Game;
import ru.netology.Game.NotRegisteredException;
import ru.netology.Player.Player;

public class GameTest {

    @Test
    public void testFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Mary", 100);
        Player player2 = new Player(2, "Anna", 40);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Mary", "Anna");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Garry", 30);
        Player player2 = new Player(2, "Max", 110);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Garry", "Max");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualStrength() {
        Game game = new Game();
        Player player1 = new Player(1, "Garry", 30);
        Player player2 = new Player(2, "Max", 30);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Garry", "Max");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstNotRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Garry", 30);
        Player player2 = new Player(2, "Max", 30);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anna", "Max");
        });
    }

    @Test
    public void testSecondNotRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Garry", 30);
        Player player2 = new Player(2, "Max", 30);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Max", "Bill");
        });
    }

    @Test
    public void testPlayersNotRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Garry", 30);
        Player player2 = new Player(2, "Max", 30);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Mary", "Bill");
        });
    }

}
