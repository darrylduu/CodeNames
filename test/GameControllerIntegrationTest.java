import game.Card;
import game.CardType;
import game.GameController;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class GameControllerIntegrationTest {

  List<String> words = Arrays.asList("word1", "word2", "word3", "word4", "word5", "word6", "word7",
      "word8", "word9", "word10", "word11", "word12", "word13", "word14", "word15", "word16",
      "word17", "word18", "word19", "word20", "word21", "word22", "word23", "word24", "word25");

  List<CardType> types = Arrays.asList(CardType.ASSASSIN, CardType.RED, CardType.RED, CardType.RED, CardType.RED, CardType.RED,
      CardType.RED, CardType.RED, CardType.RED, CardType.RED, CardType.BLUE, CardType.BLUE, CardType.BLUE,
      CardType.BLUE, CardType.BLUE, CardType.BLUE, CardType.BLUE, CardType.BLUE,
      CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL, CardType.NEUTRAL);


  @Test
  public void testMakeGuessAndEndGame() {
    // Given
    GameController gameController = new GameController(words, types, 3);

    // When
    List<Card> card = gameController.getBoard().getCards();
    int assassinIndex = 0;
    for(int i = 0; i < card.size(); i++) {
      if(card.get(i).getType() == CardType.ASSASSIN) {
        assassinIndex = i;
        break;
      }
    }

    // Make a guess on the assassin card
    boolean gameContinues = gameController.makeGuess(assassinIndex);

    // Then
    assertFalse(gameContinues);
  }

  @Test
  public void testGetHintAndSetHint() {
    // Given
    GameController gameController = new GameController(words, types, 3);

    // When
    gameController.setHint("testHint");
    String hint = gameController.getHint();

    // Then
    assertEquals("testHint", hint);
  }
}
