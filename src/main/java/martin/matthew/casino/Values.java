package martin.matthew.casino;

/**
 * Created by matthewmartin on 1/27/17.
 */
public enum Values {
    ACE ("Ace"),
    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    TEN ("10"),
    JACK ("10"),
    QUEEN ("10"),
    KING ("10");

    public String value;

    Values(String s) {
        this.value = s;
    }
}
