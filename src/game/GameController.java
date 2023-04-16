package game;

import utils.Constants;

import java.util.List;

public class GameController {
    private Board board;
    private Team redTeam;
    private Team blueTeam;
    private Team currentTeam;

    private String hint;
    private int maxGuessesPerTurn;
    private int guessesMadeThisTurn;

    public GameController(List<String> words, List<CardType> types, int maxGuessesPerTurn) {
        board = new Board(words, types, Constants.BOARD_SIZE);
        redTeam = new Team("Red");
        blueTeam = new Team("Blue");
        currentTeam = redTeam;
        this.maxGuessesPerTurn = maxGuessesPerTurn;
        guessesMadeThisTurn = 0;
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

    public boolean hasWon(Team team) {
        return team.getScore() == (team == redTeam ? Constants.RED_CARDS : Constants.BLUE_CARDS);
    }

    public boolean makeGuess(int index) {
        if (guessesMadeThisTurn >= maxGuessesPerTurn) {
            return true;
        }

        Card card = board.getCards().get(index);
        if (!card.isRevealed()) {
            card.reveal();
            guessesMadeThisTurn++;

            if (card.getType() == CardType.ASSASSIN) {
                return false;
            } else if (card.getType().toString().equalsIgnoreCase(currentTeam.getName())) {
                currentTeam.incrementScore();
                if (hasWon(currentTeam)) {
                    return false;
                }
            } else {
                switchTeams();
                guessesMadeThisTurn = 0;
            }
        }
        return true;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
