import game.Board;
import game.Card;
import game.CardType;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class BoardTest {

  @Test
  public void testGetCards() {
    // Given
    List<String> words = Arrays.asList("word1", "word2", "word3", "word4");
    List<CardType> types = Arrays.asList(CardType.RED, CardType.BLUE, CardType.NEUTRAL, CardType.ASSASSIN);
    int boardSize = 4;
    Board board = new Board(words, types, boardSize);

    // When
    List<Card> cards = board.getCards();

    // Then
    assertEquals(boardSize, cards.size());
    assertEquals(words.get(0), cards.get(0).getWord());
    assertEquals(types.get(0), cards.get(0).getType());
  }
}
