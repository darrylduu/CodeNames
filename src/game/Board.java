package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Card> cards;

    public Board(List<String> words, List<CardType> types, int boardSize) {
        cards = new ArrayList<>();
        generateCards(words, types, boardSize);
    }

    private void generateCards(List<String> words, List<CardType> types, int boardSize) {
        Collections.shuffle(words);
        Collections.shuffle(types);

        for (int i = 0; i < boardSize; i++) {
            cards.add(new Card(words.get(i), types.get(i)));
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
