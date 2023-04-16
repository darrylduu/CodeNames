package game;

public class Card {
    private String word;
    private CardType type;
    private boolean revealed;

    public Card(String word, CardType type) {
        this.word = word;
        this.type = type;
        this.revealed = false;
    }

    public String getWord() {
        return word;
    }

    public CardType getType() {
        return type;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void reveal() {
        revealed = true;
    }
}

