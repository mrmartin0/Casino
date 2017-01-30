package martin.matthew.casino;

import java.util.ArrayList;

/**
 * Created by matthewmartin on 1/30/17.
 */
class CardHand {

    ArrayList<Cards> dealerHand = new ArrayList<Cards>();
    ArrayList<Cards> playerHand = new ArrayList<Cards>();


    public void seePlayerHand() {
        for (Cards c : playerHand) {
            c.seeCards();
        }
    }


    public void seeDealerHand() {
        for (Cards c : dealerHand) {
            c.seeCards();
        }
    }


}
