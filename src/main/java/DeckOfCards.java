import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by matthewmartin on 1/27/17.
 */
public class DeckOfCards extends ArrayList {
    ArrayList<Cards> deckOfCards = new ArrayList<Cards>();

    public DeckOfCards() {
        for (Suits s : Suits.values()) {
            for (Values v : Values.values()) {
                Cards card = new Cards(s, v);
                deckOfCards.add(card);

            }
        }
    }

    public void seeCardDeck() {
        for (Cards c : deckOfCards) {
            c.seeCards();

        }
    }

    public Cards takeTopCard() {
        Cards card = deckOfCards.get(0);
        deckOfCards.remove(0);

        return card;
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);

    }

}