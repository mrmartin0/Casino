import org.junit.Assert.*;
import org.junit.Test;
import sun.text.bidi.BidiBase;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by matthewmartin on 1/28/17.
 */


public class GoFishGameTest {
    Cards aceOfSpades = new Cards(Suits.SPADES, Values.ACE);
    Cards twoOfSpades = new Cards(Suits.SPADES, Values.TWO);
    Cards threeOfSpades = new Cards(Suits.SPADES, Values.THREE);
    Cards fourOfSpades = new Cards(Suits.SPADES, Values.FOUR);
    Cards fiveOfSpades = new Cards(Suits.SPADES, Values.FIVE);
    Cards sixOfSpades = new Cards(Suits.SPADES, Values.SIX);
    Cards sevenOfSpades = new Cards(Suits.SPADES, Values.SEVEN);
    Cards eightOfSpades = new Cards(Suits.SPADES, Values.EIGHT);
    Cards nineOfSpades = new Cards(Suits.SPADES, Values.NINE);
    Cards tenOfSpades = new Cards(Suits.SPADES, Values.TEN);
    Cards jackOfSpades = new Cards(Suits.SPADES, Values.JACK);
    Cards queenOfSpades = new Cards(Suits.SPADES, Values.QUEEN);
    Cards kingOfSpades = new Cards(Suits.SPADES, Values.KING);
    Cards aceOfDiamonds = new Cards(Suits.DIAMONDS, Values.ACE);


    @Test

     public void matchCounterTest() {

        GoFishGame goFishGame = new GoFishGame();
        goFishGame.goFishDealCards();
        int actual = goFishGame.checkDealersHandForMatch(Values.TWO);
        int expected = 1;
        assertEquals("I expect the dealer to have a TWO",expected,actual);
    }

    @Test

    public void playerTakesDealersCardTest() {

        GoFishGame goFishGame = new GoFishGame();
        goFishGame.goFishDealCards();
        goFishGame.playerTakesDealersCard(Values.TWO);
        ArrayList<Cards>testHand = new ArrayList<Cards>();
        testHand.add(aceOfSpades);
        testHand.add(threeOfSpades);
        testHand.add(fiveOfSpades);
        testHand.add(sevenOfSpades);
        testHand.add(nineOfSpades);
        testHand.add(jackOfSpades);
        testHand.add(kingOfSpades);
        testHand.add(twoOfSpades);

        for(Cards c : goFishGame.dealerHand){
            c.seeCards();
        }

        System.out.println(" ");
        for(Cards c : goFishGame.dealerHand){
            c.seeCards();
        }


        assertEquals(goFishGame.playerHand.get(7).getValue(), testHand.get(7).getValue());

        //the card value of the player hand from the go fish game at index 7(known because of the order in which the
        //deck deals) compared to the value of the card in the test hand at index 7(known because I placed it into the
        //7th index on line 48 in the test hand array created on line 41.
    }

    @Test

    public void dealerTakesPlayersCardTest(){

        GoFishGame goFishGame = new GoFishGame();
        goFishGame.goFishDealCards();
        goFishGame.dealerTakesPlayersCard(Values.THREE);
        ArrayList<Cards>testHand = new ArrayList<Cards>();
        testHand.add(twoOfSpades);
        testHand.add(fourOfSpades);
        testHand.add(sixOfSpades);
        testHand.add(eightOfSpades);
        testHand.add(tenOfSpades);
        testHand.add(queenOfSpades);
        testHand.add(aceOfDiamonds);
        testHand.add(nineOfSpades);


        for (Cards c : goFishGame.playerHand){
            c.seeCards();
        }
        assertEquals(goFishGame.dealerHand.get(6).getValue(), testHand.get(6).getValue());
    }

    @Test

    public void formatUserInputPlayerAskingDealerTest() {
        GoFishGame goFishGame = new GoFishGame();
        goFishGame.goFishDealCards();
        goFishGame.formatUserInputPlayerAskingDealer("ace");
        Values expected = Values.ACE;
        Values actual = goFishGame.formatUserInputPlayerAskingDealer("ace");
        assertEquals(expected,actual);

    }

    @Test

    public void goFishDealCardsTest() {
        GoFishGame goFishGame = new GoFishGame();
        goFishGame.goFishDealCards();
        int expectedSize = 7;
        int actualSize = goFishGame.playerHand.size();
        assertEquals(expectedSize,actualSize);

    }

    @Test
    public String getWinnerTest;{
        GoFishGame testGame = new GoFishGame();
        Integer playerScore = 6;
        Integer dealerScore = 5;
        String expected  = ("You win!!!");
        String actual = testGame.getWinner();
        assertEquals(actual,expected);

    }

}




