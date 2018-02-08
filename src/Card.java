public class Card {
    int cardValue;
    char cardSuit;
    char card;

    // Constructor to create a Card with Value and Suit

    public Card(String cardInput) {
        cardSuit = cardInput.charAt(cardInput.length() - 1);
        card = cardInput.charAt(0);
        String value = cardInput.substring(0, cardInput.length() - 1);

        if (Character.isDigit(value.charAt(0))) {
            cardValue = Integer.valueOf(value);
        }

        else if (value.equalsIgnoreCase("J")) {
            cardValue = 11;
        } else if (value.equalsIgnoreCase("Q")) {
            cardValue = 12;
        } else if (value.equalsIgnoreCase("K")) {
            cardValue = 13;
        } else if (value.equalsIgnoreCase("A")) {
            cardValue = 14;
        }

    }
    // card suit

    public char getCardSuit() {
        return cardSuit;
    }

    // card value. Convert to int if it is a facecard

    public int getCardValue() {
        return cardValue;
    }
    public char getCardNumber() {
        return card;
        
    }
    public String getCardString(Card card) {
        String myCard ="";
        String number = Character.toString(card.getCardNumber());
        String suit = Character.toString(card.getCardSuit());
        return myCard + number + suit;
    }
    

}
