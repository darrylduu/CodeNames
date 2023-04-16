import static org.junit.Assert.assertTrue;

import org.junit.Test;
import scenes.GameScene;
public class GameSceneTest {
    @Test
    public void gameScene_shouldRunWithoutExceptions() {
        // When
        GameScene.createGameScene();

        // Then - no exceptions
        assertTrue(true);
    }
}
