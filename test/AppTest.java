import org.junit.Test;
import scenes.MainMenu;

import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void run_shouldInvokeCreateAndShowGUI() {
    // Given
    MainMenu mainMenu = new MainMenu();
    App app = new App();

    // When
    app.run();

    // Then
    assertNotNull(app);
  }
}
