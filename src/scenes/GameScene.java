package scenes;

import game.Card;
import game.CardType;
import game.GameController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import utils.Constants;

public class GameScene {

  public static void createGameScene() {

		String foodStr = "Pizza, Sushi, Hamburger, Pasta, Burrito, Sandwich, Salad, IceCream, Soup, Steak, Pancake, Tacos, Dumplings, FriedChicken, Chocolate, Croissant, Curry, Lasagna, Waffle, Risotto, Noodles, Omelette, Paella, Crepes, Barbecue";
		List<String> words =  Arrays.asList(foodStr.split(", "));
		List<CardType> types = new ArrayList<>();

		for (int i = 0; i < Constants.RED_CARDS; i++) {
			types.add(CardType.RED);
		}

		for (int i = 0; i < Constants.BLUE_CARDS; i++) {
			types.add(CardType.BLUE);
		}

		for (int i = 0; i < Constants.NEUTRAL_CARDS; i++) {
			types.add(CardType.NEUTRAL);
		}

		for (int i = 0; i < Constants.ASSASSIN_CARDS; i++) {
			types.add(CardType.ASSASSIN);
		}

		GameController gameController = new GameController(words, types, 3); // Set the maximum number of guesses per turn


		JFrame frame = new JFrame("Game Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(5, 5));

		// Add a label to show the hint
		JLabel hintLabel = new JLabel("Hint: ");
		hintLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		// Add a text field to allow the Spymaster to enter the hint
		JTextField hintTextField = new JTextField(20);
		hintTextField.addActionListener(e -> {
			gameController.setHint(hintTextField.getText());
			hintLabel.setText("Hint: " + gameController.getHint());
		});

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			int index = i;
			Card card = gameController.getBoard().getCards().get(index);
			JButton cell = new JButton(card.getWord() + " (" + card.getType() + ")");
			cell.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
			cell.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					boolean gameContinues = gameController.makeGuess(index);

					if (!gameContinues) {
						if (card.getType() == CardType.ASSASSIN) {
							JOptionPane.showMessageDialog(frame, gameController.getCurrentTeam().getName() + " team lost! The word was an ASSASSIN.");
						} else {
							JOptionPane.showMessageDialog(frame, gameController.getCurrentTeam().getName() + " team won!");
						}
						frame.dispose();
					} else {
						cell.setEnabled(false);
						cell.setBackground(card.getType().toString().equals(gameController.getCurrentTeam().getName()) ? java.awt.Color.GREEN : java.awt.Color.RED);
					}
				}
			});
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

		// Add the hint label and text field to the UI
		JPanel hintPanel = new JPanel();
		hintPanel.add(hintLabel);
		hintPanel.add(hintTextField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(exitButton);

		frame.add(hintPanel, BorderLayout.PAGE_START);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.PAGE_END);
		frame.setVisible(true);
  }
}
