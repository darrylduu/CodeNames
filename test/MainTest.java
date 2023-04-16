import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void main_shouldCreateAndRunApp() {
    // When
    Main.main(new String[0]);

    // Then - no exceptions
    assertTrue(true);
  }
}
