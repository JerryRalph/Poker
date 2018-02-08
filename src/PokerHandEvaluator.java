
public class PokerHandEvaluator {

    String cardString;

    public PokerHands blackPlayer;
    public PokerHands whitePlayer;

    public PokerHandEvaluator(String input) {

        this.cardString = input;

        String black = cardString.substring(cardString.indexOf(":") + 2, cardString.indexOf("White:"));

        String white = cardString.substring(cardString.lastIndexOf(":") + 2);

        // create black cards in array by splitting string at " "
        // and creating 5 cards in an array

        String[] blackPlayerHand = black.split(" ");

        // create white cards in array by splitting string at " "
        // // and creating 5 cards in an array

        String[] whitePlayerHand = white.split(" ");

        // make a Hand out of the players cards
        blackPlayer = new PokerHands(blackPlayerHand);

        whitePlayer = new PokerHands(whitePlayerHand);

    }

    public PokerHands getbBlackPlayerHand() {

        return blackPlayer;

    }

    public PokerHands getWhitePlayerHand() {

        return whitePlayer;

    }

    public String evaluateHand() {
      
       
        
    if(blackPlayer.getRank(blackPlayer) == whitePlayer.getRank(whitePlayer))
        
   
    {
        if(blackPlayer.determineHigestCard() > whitePlayer.determineHigestCard()) {
            

        System.out.println ("Black Player Won!");
        System.out.println("Black hand:  " + blackPlayer.gethand()+ blackPlayer.getRankString(blackPlayer) + blackPlayer.determineHigestCard());
        System.out.println("White hand:  " + whitePlayer.gethand()+ whitePlayer.getRankString(whitePlayer) + whitePlayer.determineHigestCard());
    }
        if(blackPlayer.determineHigestCard()< whitePlayer.determineHigestCard()) {
           

            System.out.println ("White Player Won!");
            System.out.println("Black hand:  " + blackPlayer.gethand()+ blackPlayer.getRankString(blackPlayer)+ blackPlayer.determineHigestCard());
            System.out.println("White hand:  " + whitePlayer.gethand()+ whitePlayer.getRankString(whitePlayer) + whitePlayer.determineHigestCard());
        }
        return "It's a Tie";
        
    }
        if (blackPlayer.getRank(blackPlayer) > whitePlayer.getRank(whitePlayer)) {

            System.out.println("Black Player Won!");
            System.out.println("Black hand:  " + blackPlayer.gethand()+ blackPlayer.getRankString(blackPlayer));
            System.out.println("White hand:  " + whitePlayer.gethand()+ whitePlayer.getRankString(whitePlayer));
            return "Black Player Won!";

        }
        if (blackPlayer.getRank(blackPlayer) < whitePlayer.getRank(whitePlayer)) {

            System.out.println("White Player Won!");
            System.out.println("Black hand:  " + blackPlayer.gethand() + blackPlayer.getRankString(blackPlayer));
            System.out.println("White hand: " + whitePlayer.gethand() + whitePlayer.getRankString(whitePlayer));
            return "White Player Won!";

        }
        return "Game Over";
    }

}
