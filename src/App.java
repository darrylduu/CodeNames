import scenes.MainMenu;
import javax.swing.SwingUtilities;

public class App {
    public void run() {
        SwingUtilities.invokeLater(() -> MainMenu.createAndShowGUI());
    }
}