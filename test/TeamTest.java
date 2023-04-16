import game.Team;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void testIncrementScore() {
    // Given
    Team team = new Team("test");

    // When
    int initialScore = team.getScore();
    team.incrementScore();
    int newScore = team.getScore();

    // Then
    assertEquals(0, initialScore);
    assertEquals(1, newScore);
  }
}
