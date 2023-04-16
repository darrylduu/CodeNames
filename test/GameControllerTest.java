import game.CardType;
import game.GameController;
import game.Team;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class GameControllerTest {

  List<String> words = Arrays.asList("word1", "word2", "word3", "word4", "word5", "word6", "word7",
      "word8", "word9", "word10", "word11", "word12", "word13", "word14", "word15", "word16",
      "word17", "word18", "word19", "word20", "word21", "word22", "word23", "word24", "word25");

  List<CardType> types = Arrays.asList(CardType.RED, CardType.RED, CardType.RED, CardType.RED, CardType.RED,
      CardType.RED, CardType.RED, CardType.RED, CardType.RED, CardType.BLUE, CardType.BLUE, CardType.BLUE,
      CardType.BLUE, CardType.BLUE, CardType.BLUE, CardType.BLUE, CardType.BLUE, CardType.ASSASSIN,
  CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL);

  @Test
  public void testMakeGuess() {
    // Given
    GameController gameController = new GameController(words, types, 3);

    // When
    boolean gameContinues1 = gameController.makeGuess(0);
    boolean gameContinues2 = gameController.makeGuess(3);
    boolean gameContinues3 = gameController.makeGuess(1);
    boolean gameContinues4 = gameController.makeGuess(2);

    // Then
    assertTrue(gameContinues1);
    assertTrue(gameContinues2);
    assertTrue(gameContinues3);
    assertTrue(gameContinues4);
  }

  @Test
  public void testSwitchTeams() {
    // Given
    GameController gameController = new GameController(words, types, 3);

    // When
    Team initialTeam = gameController.getCurrentTeam();
    gameController.switchTeams();
    Team switchedTeam = gameController.getCurrentTeam();

    // Then
    assertNotEquals(initialTeam, gameController.getCurrentTeam());
    assertEquals(switchedTeam, gameController.getCurrentTeam());
  }

  @Test
  public void testGetHint() {
    // Given
    GameController gameController = new GameController(words, types, 3);

    // When
    gameController.setHint("testHint");
    String hint = gameController.getHint();

    // Then
    assertEquals("testHint", hint);
  }

  @Test
  public void testSetHint() {
    // Given
    GameController gameController = new GameController(words, types, 3);

    // When
    gameController.setHint("testHint");
    String hint = gameController.getHint();

    // Then
    assertEquals("testHint", hint);
  }
}
