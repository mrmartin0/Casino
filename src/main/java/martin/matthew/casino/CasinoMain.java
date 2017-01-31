package martin.matthew.casino;

/**
 * Created by matthewmartin on 1/27/17.
 */
public class CasinoMain {
    public static void main(String[] args) {


    playGoFishGame();


    }

    static private void playGoFishGame(){
        GoFishGame firstGame = new GoFishGame();
        firstGame.goFishDealCards();
        while(!firstGame.gameIsOver) {
            firstGame.playerTurn();
            firstGame.dealerTurn();
            firstGame.gameIsOver = firstGame.getIfGameIsOver();
            System.out.println(firstGame.gameIsOver);
        }
        firstGame.getWinner();

    }

}
