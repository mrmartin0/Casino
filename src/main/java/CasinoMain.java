/**
 * Created by matthewmartin on 1/27/17.
 */
public class CasinoMain {
    public static void main(String[] args) {

        DeckOfCards d = new DeckOfCards();
        Cards currentCard = d.takeTopCard();

        GoFishGame goFishDeal = new GoFishGame();
        goFishDeal.goFishDealCards();
        goFishDeal.seePlayerHand();

    }

}
