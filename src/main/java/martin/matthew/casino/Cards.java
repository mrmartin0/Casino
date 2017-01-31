package martin.matthew.casino;

import java.util.ArrayList;

/**
 * Created by matthewmartin on 1/27/17.
 */

class Cards {
    private Suits suit;
    private Values value;
    private ArrayList<Cards> dealerHand = new ArrayList<Cards>();
    private ArrayList<Cards> playerHand = new ArrayList<Cards>();

    Suits getSuit() {
        return suit;
    }

    Values getValue() {
        return value;
    }

    Cards(Suits suit, Values value){
        this.suit = suit;
        this.value = value;

    }

    void seeCards(){
        System.out.print(this.value + " of ");
        System.out.println(this.suit);

    }


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


