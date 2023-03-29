package scenes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScene {
	
	public static void createGameScene() {
		
		JFrame frame = new JFrame("Game Board");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	    JPanel panel = new JPanel();
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    panel.setLayout(new GridLayout(5, 5));

	    for (int i = 0; i < 25; i++) {
	        JPanel cell = new JPanel();
	        cell.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
	        panel.add(cell);
	    }

	    JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setBackground(new Color(255, 85, 85));
        exitButton.setFocusPainted(false);
	    exitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	        }
	    });

	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(exitButton);

	    frame.add(panel, BorderLayout.CENTER);
	    frame.add(buttonPanel, BorderLayout.PAGE_END);
	    frame.setVisible(true);
	}
}