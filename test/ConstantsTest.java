import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import utils.Constants;

import org.junit.Test;

public class ConstantsTest {
    @Test
    public void constants_shouldBeInitialized() {
      // Then
      assertEquals(25, Constants.BOARD_SIZE);
      assertEquals(9, Constants.RED_CARDS);
      assertEquals(8, Constants.BLUE_CARDS);
      assertEquals(7, Constants.NEUTRAL_CARDS);
      assertEquals(1, Constants.ASSASSIN_CARDS);
    }
}
