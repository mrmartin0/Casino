package martin.matthew.casino;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeArray.lastIndexOf;

/**
 * Created by matthewmartin on 1/27/17.
 */
class GoFishGame {
    ArrayList<Cards> dealerHand = new ArrayList<Cards>();
    ArrayList<Cards> playerHand = new ArrayList<Cards>();
    DeckOfCards goFishDeck = new DeckOfCards();
    int playerScore = 0;
    int dealerScore = 0;
    Values playerChoiceValue; // = formatUserInputPlayerAskingDealer();
    Scanner scan = new Scanner(System.in);
    int matchCounter;
    boolean gameIsOver = false;


    public void goFishDealCards() {
            goFishDeck.shuffleDeck();
        for (int i = 0; i < 7; i++) {
            playerHand.add(goFishDeck.takeTopCard());
            dealerHand.add(goFishDeck.takeTopCard());
        }
        sortDealerHand();
        sortPlayerHand();
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


    public boolean getIfGameIsOver() {
        if ((playerScore > 6) || (dealerScore > 6)) {
            System.out.println(playerScore + "is player score" + dealerScore + "is dealer score");
            return true;
//        } else if (goFishDeck.size() < 1) {
//            System.out.println("go Fish deck is empty");
//            return true;
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
        seePlayerHand();
    }


    public void dealerTakeCard() {
        goFishDeck.shuffleDeck();
        dealerHand.add(goFishDeck.takeTopCard());
        sortDealerHand();
    }


    public String playerAsksDealer() {
        System.out.println("\nWhat card do you think the dealer has?");
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


    public int checkPlayersHandForMatch(Values dealerChoiceValue) {
        matchCounter = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).getValue().equals(dealerChoiceValue)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }


    public void dealerLooksForMatch() {
        if (matchCounter == 0) {
            System.out.println("\nGo Fish");
        } else {
            System.out.println("\nYes, I have " + matchCounter + "" + playerChoiceValue);
        }
    }


    public void playerTakesDealersCard(Values valuePlayerWants) {

        ArrayList<Suits> dealerCardSuits = new ArrayList<>();
        for (Cards c : dealerHand) {
            if (c.getValue() == valuePlayerWants) {
                dealerCardSuits.add(c.getSuit());
            }
        }
        for (Suits s : dealerCardSuits) {
            Cards transferCard = new Cards(s, valuePlayerWants);
            playerHand.add(transferCard);
        }
        seePlayerHand();
        for (Iterator<Cards> iterator = dealerHand.iterator(); iterator.hasNext(); ) {
            Cards card = iterator.next();
            if (card.getValue() == valuePlayerWants) {
                iterator.remove();
            }
        }
    }


    public void dealerTakesPlayersCard(Values valueDealerWants) {

        ArrayList<Suits> playerCardSuits = new ArrayList<>();
        for (Cards c : playerHand) {
            if (c.getValue() == valueDealerWants) {
                playerCardSuits.add(c.getSuit());
            }
        }
        for (Suits s : playerCardSuits) {
            Cards transferCard = new Cards(s, valueDealerWants);
            dealerHand.add(transferCard);
        }
        sortDealerHand();
        for (Iterator<Cards> iterator = playerHand.iterator(); iterator.hasNext(); ) {
            Cards card = iterator.next();
            if (card.getValue() == valueDealerWants) {
                iterator.remove();
            }
        }
    }


    public void playerGoesFish() {
        playerHand.add(goFishDeck.takeTopCard());
    //    seePlayerHand();
        System.out.println("\nplayer goes fish, picks a " + playerHand.get(playerHand.size()-1).getValue());

    }


    public void dealerGoesFish() {
        dealerHand.add(goFishDeck.takeTopCard());
        sortDealerHand();
        System.out.println("\ndealer goes fish");

    }


    public void playGame() {
        goFishDealCards();
        while (gameIsOver == false) {
            playerTurn();
            dealerTurn();
            gameIsOver = getIfGameIsOver();
            System.out.println(gameIsOver);
        }
        getWinner();
    }


    public void playerTurn() {
        System.out.println("\nYour hand is \n");
        seePlayerHand();
        String playerChoice = playerAsksDealer();
        dealerLooksForMatch();
        Values valuePlayerWants = formatUserInputPlayerAskingDealer(playerChoice);
        System.out.println("\nThe player is asking for a " + valuePlayerWants +"\n");
        if (checkDealersHandForMatch(valuePlayerWants) == 0) {
            playerGoesFish();
            bookPlayerEngine();
        } else {
            playerTakesDealersCard(valuePlayerWants);
            bookPlayerEngine();
            System.out.println("Your Score is " + playerScore + "\n" + "Dealers Score is " + dealerScore + "\n");
            playerTurn();
        }
    }


    public void dealerTurn() {
//        System.out.println("\nYour hand is ");
//        seePlayerHand();

        if (dealerHand.size() == 0) {
            dealerGoesFish();
        }

        Values valueDealerWants = dealerHand.get((int) (Math.random() * dealerHand.size())).getValue();
        System.out.println("\nThe dealer is asking for a " + valueDealerWants);
        if (checkPlayersHandForMatch(valueDealerWants) == 0) {
            dealerGoesFish();
        } else {
            dealerTakesPlayersCard(valueDealerWants);
            dealerTurn();
        }

    }


    public void bookPlayerEngine(){
        if(checkPlayersHandForBook()){
            Values bookValue =  playersBookValue();
            addToPlayersBooks(bookValue);
        }

    }


    public void bookDealerEngine() {
        if (checkDealersHandForBook()) {
            Values bookValue = dealerBookValue();
            addToDealerBooks(bookValue);

        }
    }

    public void sortPlayerHand() {

        Collections.sort(playerHand, new Comparator<Cards>() {
            @Override
            public int compare(Cards o1, Cards o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }


    public void sortDealerHand() {

        Collections.sort(dealerHand, new Comparator<Cards>() {
            @Override
            public int compare(Cards o1, Cards o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }


    public Boolean checkPlayersHandForBook() {
        matchCounter = 0;
        for (int i = 0; i < playerHand.size() - 1; i++)
            if (playerHand.get(i).getValue().equals(playerHand.get(i + 1).getValue())) {
                matchCounter++;
                if (matchCounter == 4) {
                    return true;
                }
            }
        return false;
    }


    public Values playersBookValue() {
        matchCounter = 0;
        for (int i = 0; i < playerHand.size() - 1; i++)
            if (playerHand.get(i).getValue().equals(playerHand.get(i + 1).getValue())) {
                matchCounter++;
                if (matchCounter == 4) {
                    return playerHand.get(i).getValue();
                }
            }
        return Values.ACE;
    }


    public void addToPlayersBooks(Values playerBookValue) {
        playerScore++;

            for (Iterator<Cards> iterator = playerHand.iterator(); iterator.hasNext(); ) {
                Cards card = iterator.next();
                if (card.getValue() == playerBookValue) {
                    iterator.remove();
                    playerScore++;
                }
            }
    }


    public Boolean checkDealersHandForBook(){
        matchCounter = 0;
        for (int i = 0; i < dealerHand.size() - 1; i++)
            if (dealerHand.get(i).getValue().equals(dealerHand.get(i + 1).getValue())) {
                matchCounter++;
                if (matchCounter == 4) {
                    return true;
                }
            }
        return false;
    }


    public Values dealerBookValue() {
        matchCounter = 0;
        for (int i = 0; i < dealerHand.size() - 1; i++)
            if (dealerHand.get(i).getValue().equals(dealerHand.get(i + 1).getValue())) {
                matchCounter++;
                if (matchCounter == 4) {
                    return dealerHand.get(i).getValue();
                }
            }
        return Values.ACE;
    }


    public void addToDealerBooks(Values dealerBookValue) {
        playerScore++;

        for (Iterator<Cards> iterator = dealerHand.iterator(); iterator.hasNext(); ) {
            Cards card = iterator.next();
            if (card.getValue() == dealerBookValue) {
                iterator.remove();
                dealerScore++;
            }
        }
    }


}






