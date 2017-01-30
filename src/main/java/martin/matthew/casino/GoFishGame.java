package martin.matthew.casino;

import java.util.*;

/**
 * Created by matthewmartin on 1/27/17.
 */
class GoFishGame {
    ArrayList<Cards> dealerHand = new ArrayList<Cards>();
    ArrayList<Cards> playerHand = new ArrayList<Cards>();
    DeckOfCards goFishDeck = new DeckOfCards();
    ArrayList<Cards> dealerBooks = new ArrayList<Cards>();
    ArrayList<Cards> playerBooks = new ArrayList<Cards>();
    int playerScore;
    int dealerScore;
    Values playerChoiceValue; // = formatUserInputPlayerAskingDealer();
    Scanner scan = new Scanner(System.in);
    int matchCounter;


    public void goFishDealCards() {
        goFishDeck.shuffleDeck();
        for (int i = 0; i < 7; i++) {
            playerHand.add(goFishDeck.takeTopCard());
            dealerHand.add(goFishDeck.takeTopCard());
        }
    }


    public boolean getIfGameIsOver() {
        if ((playerScore > 6) || (dealerScore > 6)) {
            return true;
        } else if (goFishDeck.isEmpty()) {
            return true;
        }
        return false;
    }


    public String getWinner() {
        if (playerScore > dealerScore) {
            return "You win!!!";
        } else if (dealerScore > playerScore) {
            return "Dealer Wins.";
        }
        return "Tie game.";
    }


    public void playerTakeCard() {
        goFishDeck.shuffleDeck();
        playerHand.add(goFishDeck.takeTopCard());
    }


    public void dealerTakeCard() {
        goFishDeck.shuffleDeck();
        dealerHand.add(goFishDeck.takeTopCard());
    }


    public String playerAsksDealer() {
        System.out.println("What card do you think the dealer has?");
         return scan.nextLine();
    }


    public Values formatUserInputPlayerAskingDealer(String playerChoice) {
     //   String playerChoice = playerAsksDealer();
        Values result = null;
        switch (playerChoice.toUpperCase()) {
            case "ACE":
                result = Values.ACE;
                break;
            case "TWO":
                result = Values.TWO;
                break;
            case "THREE":
                result = Values.THREE;
                break;
            case "FOUR":
                result = Values.FOUR;
                break;
            case "FIVE":
                result = Values.FIVE;
                break;
            case "SIX":
                result = Values.SIX;
                break;
            case "SEVEN":
                result = Values.SEVEN;
                break;
            case "EIGHT":
                result = Values.EIGHT;
                break;
            case "NINE":
                result = Values.NINE;
                break;
            case "TEN":
                result = Values.TEN;
                break;
            case "JACK":
                result = Values.JACK;
                break;
            case "QUEEN":
                result = Values.QUEEN;
                break;
            case "KING":
                result = Values.KING;
                break;

            default:
                System.out.println("I do not recognize that card");
        }
        return result;
    }


    public int checkDealersHandForMatch(Values playerChoiceValue) {
        matchCounter = 0;
        for (int i = 0; i < dealerHand.size(); i++) {
            if (dealerHand.get(i).getValue().equals(playerChoiceValue)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }


    public void dealerLooksForMatch() {
        if (matchCounter == 0) {
            System.out.println("Go Fish");
        } else {
            System.out.println("Yes, I have " + matchCounter + "" + playerChoiceValue);
        }
    }


    public void playerTakesDealersCard(Values valuePlayerWants){

        ArrayList<Suits> dealerCardSuits = new ArrayList<>();
        for(Cards c : dealerHand){
            if(c.getValue() == valuePlayerWants){
                dealerCardSuits.add(c.getSuit());
            }
        }
        for(Suits s : dealerCardSuits){
            Cards transferCard = new Cards(s, valuePlayerWants);
            playerHand.add(transferCard);
        }
        for(Iterator<Cards> iterator = dealerHand.iterator(); iterator.hasNext();){
            Cards card = iterator.next();
            if(card.getValue() == valuePlayerWants){
                iterator.remove();
            }
        }
    }

    public void dealerTakesPlayersCard(Values valueDealerWants){

        ArrayList<Suits> playerCardSuits = new ArrayList<>();
        for(Cards c : playerHand){
            if(c.getValue() == valueDealerWants){
                playerCardSuits.add(c.getSuit());
            }
        }
        for(Suits s : playerCardSuits){
            Cards transferCard = new Cards(s, valueDealerWants);
            dealerHand.add(transferCard);
        }
        for(Iterator<Cards> iterator = playerHand.iterator(); iterator.hasNext();){
            Cards card = iterator.next();
            if(card.getValue() == valueDealerWants){
                iterator.remove();
            }
        }
    }

   public void playerGoesFish(){
       playerHand.add(goFishDeck.takeTopCard());

    }

    public void dealerGoesFish(){
       dealerHand.add(goFishDeck.takeTopCard());


    }
}
