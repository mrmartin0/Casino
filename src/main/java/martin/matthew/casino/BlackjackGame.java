package martin.matthew.casino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by matthewmartin on 1/30/17.
 */
class BlackjackGame {


        private ArrayList<Cards> dealerHand = new ArrayList<Cards>();
        private ArrayList<Cards> playerHand = new ArrayList<Cards>();
        private DeckOfCards blackjackDeck = new DeckOfCards();
        private BlackjackGame blackjackGame = new BlackjackGame();
        private int playerScore;
        private int dealerScore;
        private boolean playerStand;
        private boolean dealerStand;
        private boolean gameIsOver;
        private Scanner scan = new Scanner(System.in);


        public void blackjackDealCards() {
            blackjackDeck.shuffleDeck();
            for (int i = 0; i < 2; i++) {
                playerHand.add(blackjackDeck.takeTopCard());
                dealerHand.add(blackjackDeck.takeTopCard());

            }
        }


        private void playerHits() {
            blackjackDeck.shuffleDeck();
            playerHand.add(blackjackDeck.takeTopCard());
        }


        public void dealerHits() {
            blackjackDeck.shuffleDeck();
            dealerHand.add(blackjackDeck.takeTopCard());
        }

        private boolean playerBusts(){
            if(playerScore > 21){
            }
            return true;
        }

        private boolean dealerBusts(){
            if(dealerScore > 21){
            }
            return true;
        }


        public boolean getIfGameIsOver(int playerScore, int dealerScore, boolean playerStand, boolean dealerStand) {
            if (playerBusts() || (dealerBusts())) {
                return true;
            } else if ((playerStand = true ) && (dealerStand = true)) {
                return true;
            }else if (dealerScore == 21){
                return true;
            }
                return false;
        }


        public String getWinner() {
            if (gameIsOver = true) {
                if ((playerScore < 22) && (playerScore > dealerScore)) {
                    return "You win!!!";
                } else if ((dealerScore < 22) && (dealerScore > playerScore)) {
                    return "Dealer Wins.";
                }
                return "Push.";
            }
            return ("\nGameOver.");
        }


        public void askPlayerToHit(String playerChoice) {
            System.out.println("Do you want to hit or stay?");
            playerChoice = scan.nextLine();
            if(playerChoice.equalsIgnoreCase("HIT")) {
                blackjackGame.playerHits();
            } else if (playerChoice.equalsIgnoreCase("STAY")) {
                playerStand = true;
            }
        }

}