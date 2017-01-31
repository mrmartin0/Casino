package martin.matthew.casino;

/**
 * Created by matthewmartin on 1/27/17.
 */

class Cards {
    Suits suit;
    Values value;

    public Suits getSuit() {
        return suit;
    }

    public Values getValue() {
        return value;
    }

    public Cards(Suits suit, Values value){
        this.suit = suit;
        this.value = value;

    }

    public void seeCards(){
        System.out.print(this.value + " of ");
        System.out.println(this.suit);

    }


}
