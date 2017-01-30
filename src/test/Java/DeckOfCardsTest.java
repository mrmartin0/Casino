import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import sun.text.bidi.BidiBase;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.assertEquals;


/**
 * Created by matthewmartin on 1/28/17.
 */
public class DeckOfCardsTest {
    DeckOfCards testDeck = new DeckOfCards();

    @Test
    public void seeDeckOfCardsTest(){
        int expectedSize = 52;
        int actualSize = testDeck.size();
        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void takeTopCardValueTest(){
        DeckOfCards testDeck = new DeckOfCards();
        Object expected = Values.ACE;
        Object actual = testDeck.get(0);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void takeTopCardSuitTest() {
        DeckOfCards testDeck = new DeckOfCards();
        Object expected = Suits.SPADES;
        Object actual = testDeck.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleDeckTest(){

    }

}