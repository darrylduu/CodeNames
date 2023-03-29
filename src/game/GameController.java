package game;

import utils.Constants;

import java.util.List;

public class GameController {
    private Board board;
    private Team redTeam;
    private Team blueTeam;
    private Team currentTeam;

    public GameController(List<String> words, List<CardType> types) {
        board = new Board(words, types, Constants.BOARD_SIZE);
        redTeam = new Team("Red");
        blueTeam = new Team("Blue");
        currentTeam = redTeam;
    }

    public void switchTeams() {
        currentTeam = (currentTeam == redTeam) ? blueTeam : redTeam;
    }

    public Board getBoard() {
        return board;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public boolean makeGuess(int index) {
        Card card = board.getCards().get(index);
        if (!card.isRevealed()) {
            card.reveal();
            if (card.getType() == CardType.ASSASSIN) {
                return false;
            } else if (card.getType().toString().equals(currentTeam.getName())) {
                currentTeam.incrementScore();
            } else {
                switchTeams();
            }
        }
        return true;
    }
}
