import game.Card;
import game.CardType;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

  @Test
  public void testIsRevealed() {
    // Given
    Card card = new Card("word", CardType.RED);

    // When
    boolean initialRevealed = card.isRevealed();
    card.reveal();
    boolean revealed = card.isRevealed();

    // Then
    assertFalse(initialRevealed);
    assertTrue(revealed);
  }
}
