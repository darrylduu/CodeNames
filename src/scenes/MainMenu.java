package scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    public static void createAndShowGUI() {

        JFrame frame = new JFrame("Code Names");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(new Color(54, 57, 63));

        JLabel label = new JLabel("Code Names");
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(new Color(255, 255, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 30, 0);
        panel.add(label, gbc);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setForeground(new Color(255, 255, 255));
        startButton.setBackground(new Color(114, 137, 218));
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> {
        	GameScene.createGameScene();
            frame.dispose();
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 20);
        panel.add(startButton, gbc);

        JButton exitButton = new JButton("Exit Game");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setBackground(new Color(255, 85, 85));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> System.exit(0));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 20, 0, 0);
        panel.add(exitButton, gbc);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}