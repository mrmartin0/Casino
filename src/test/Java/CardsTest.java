import org.junit.Assert;

/**
 * Created by matthewmartin on 1/28/17.
 */
public class CardsTest {
    Suits suit;
    Values value;
    Cards cards;

    public void seeCardTest(){
    Cards card = new Cards(Suits.SPADES, Values.ACE);
    String expected = "Ace of Spades";
    String actual = cards.seeCards();
    Assert.assertEquals(expected, actual);

    }
}



//    //This just pulls from the enum's Suits and Values.
//    Suits suit;
//    Values value;
//    Cards card;
//
//    @Test
//    public void makeCardSuitTest() {
//
//        Suits expected = Suits.SPADES;
//        Suits actual = card.getSuit();
//        Assert.assertEquals(card.getSuit(), Suits.SPADES);
//
//    }
//
//    @Test
//    public void makeCardValue() {
//
//        Values expected = Values.ACE;
//        Values actual = card.getValue();
//        Assert.assertEquals(card.getValue(), Values.ACE);
//
//    }
//
//}
