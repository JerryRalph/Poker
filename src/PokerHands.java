import java.util.ArrayList;


public class PokerHands {
    //public PokerHands blackPlayer;
   // public PokerHands whitePlayer;

    public ArrayList<Card> cards;

    public int rank = 0;

    public PokerHands(String[] fiveCards) {
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < fiveCards.length; i++)
            cards.add(new Card(fiveCards[i]));

    }

    public char getCardSuit(int cardSuit) {
        return cards.get(cardSuit).getCardSuit();
    }

    public int getCardValue(int cardValue) {
        return cards.get(cardValue).getCardValue();
    }

    public int determineHigestCard() {
        int max = cards.get(0).getCardValue();
        for (int i = 0; i < cards.size(); i++) {
            if (max < cards.get(i).getCardValue()) {
                max = cards.get(i).getCardValue();

            }

        }
        return max;
    }

    public int hasPair(PokerHands hand) {

        int counter = 0;

        for (int i = 0; i < cards.size(); i++) {

            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getCardValue() == cards.get(j).getCardValue()) {
                    counter++;

                }
            }
        }

        if (counter == 0) {
            if(isFlush()) {
                counter =5;
                if(isStraight(hand)) {
                    counter =8;
                    rank=8;
                }
            }
        }
        
        return counter;

    }

    public boolean isPair(PokerHands hand) {
        rank = 1;

        return (hand.hasPair(hand) == 1);
    }

    public boolean isThreeofAKind(PokerHands hand) {
        rank = 3;
        return (hand.hasPair(hand) == 3);
    }

    public boolean isFourofAKind(PokerHands hand) {
        rank = 7;
        return (hand.hasPair(hand) == 6);
    }

    public boolean isFlush() {
        int counter = 1;

        int card = cards.get(0).getCardSuit();
        for (int i = 1; i < cards.size(); i++) {
            if (card == cards.get(i).getCardSuit()) {
                counter = counter + 1;

            }
        }

        rank = 5;
        return counter == 5;

    }

    public ArrayList<Card> sort() {

        for (int i = 0; i < cards.size(); i++) {
            int minIndex = i;
            int minValue = getCardValue(i);
            for (int j = i + 1; j < cards.size(); j++) {
                if (getCardValue(j) < minValue) {
                    minValue = getCardValue(j);
                    minIndex = j;
                }
            }
            Card temp = getCard(i);
            cards.set(i, getCard(minIndex));
            cards.set(minIndex, temp);

        }

        return cards;

    }

    public Card getCard(int i) {

        return cards.get(i);
    }
    public String getCardString(Card card) {
        String myCard ="";
        String number = Character.toString(card.getCardNumber());
        String suit = Character.toString(card.getCardSuit());
        return myCard + number + suit;
    }

    public boolean isStraight(PokerHands hand) {
        int count = 1;

        hand.sort();
        int nextCard = cards.get(0).getCardValue();
        for (int i = 1; i < 5; i++) {

            if (nextCard == cards.get(i).getCardValue() - 1) {
                nextCard = cards.get(i).getCardValue();
                count = count + 1;
            }
        }
        if(count == 5) {
            rank = 4;
        }
        if(count < 5) {
            rank = 0;
        }
       

        return count == 5;

    }

    public boolean isStraightFlush(PokerHands straightFlush) {

        rank = 8;
        return (straightFlush.hasPair(straightFlush) == 8);

    }

    public boolean isFullHouse(PokerHands hand) {
        rank = 6;

        return (hand.hasPair(hand) == 4);
    }

    public boolean isTwoPair(PokerHands hand) {
        rank = 2;
        return (hand.hasPair(hand) == 2);
    }

    public int getRank(PokerHands player) {

        int playerHand = player.hasPair(player);

        if (playerHand == 5) {
          player.isFlush();

            }
        if(playerHand == 8) {
            player.isStraightFlush(player);
        }

        if (playerHand == 1) {
            player.isPair(player);
        }
        if (playerHand == 3) {
            player.isThreeofAKind(player);
        }
        if (playerHand == 4) {
            player.isFullHouse(player);
        }
        if (playerHand == 0) {

            player.isStraight(player);
        }
        if (playerHand == 6) {
            player.isFourofAKind(player);
        }
        if (playerHand == 2) {
            player.isTwoPair(player);
        }

        return this.rank;
    }
    public String getRankString(PokerHands player) {
        int playerHand = player.hasPair(player);
        String rankString = null;

        if (playerHand == 5) {
          rankString = "Flush";

            }
        if(playerHand == 8) {
            rankString = " Straight Flush";
        }

        if (playerHand == 1) {
            rankString = "A pair";
        }
        if (playerHand == 3) {
            rankString = "3 of a Kind";
        }
        if (playerHand == 4) {
            rankString = "Full House";
        }
        if (playerHand == 0) {
            rankString = "Straight";
            if (!isStraight(player)) {
                rankString = "High Card";
            }
          
            }
        
        
        if (playerHand == 6) {
            rankString = "4 of a Kind";
        }
        if (playerHand == 2) {
            rankString = "Two Pair";
        }

        return rankString;
        
        
    }
    public String gethand() {
        StringBuilder hand = new StringBuilder();
        
        //String fiveCards = new String();
        for (int i = 0; i < 5; i++) {
             hand.append(getCardString(getCard(i)) +"  ");
        }
        String aHand =hand.toString();
        return aHand;
        
    }

}
