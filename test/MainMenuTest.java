import static org.junit.Assert.assertTrue;

import org.junit.Test;
import scenes.MainMenu;

public class MainMenuTest {
  @Test
  public void mainMenu_shouldRunWithoutExceptions() {
    // When
    MainMenu.createAndShowGUI();

    // Then - no exceptions
    assertTrue(true);
  }
}
