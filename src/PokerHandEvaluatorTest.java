import static org.junit.Assert.*;

import org.junit.Test;

public class PokerHandEvaluatorTest {

    // test card suit
    @Test
    public void cardSuitTest() {

        Card newCard = new Card("2H");
        assertEquals('H', newCard.getCardSuit());
    }

    // test card value
    @Test
    public void cardValueTest() {

        Card newCard = new Card("2H");
        assertEquals(2, newCard.getCardValue());
        Card newCard10 = new Card("10H");
        assertEquals(10, newCard10.getCardValue());
    }

    // test card value of face cards
    @Test
    public void cardFaceValueTest() {

        Card newCard = new Card("JH");
        assertEquals(11, newCard.getCardValue());
        Card newCardQ = new Card("QH");
        assertEquals(12, newCardQ.getCardValue());
        Card newCardK = new Card("KH");
        assertEquals(13, newCardK.getCardValue());
        Card newCardA = new Card("AH");
        assertEquals(14, newCardA.getCardValue());
    }

    // test creating a poker hand consisting of 5 cards
    @Test
    public void createPokerHandTest() {

        // create an String array of 5 cards for a poker hand
        // check to see if array populated correctly
        // checks the list of cards in the hand to make sure the suit and
        // value are correct for each of the 5 cards in the array

        String[] cards = { "AH", "2C", "10S", "8D", "QD" };
        PokerHands hand = new PokerHands(cards);
        assertEquals(5, cards.length);
        assertEquals('H', hand.getCardSuit(0));
        assertEquals(14, hand.getCardValue(0));
        assertEquals('C', hand.getCardSuit(1));
        assertEquals(2, hand.getCardValue(1));
        assertEquals('D', hand.getCardSuit(3));
        assertEquals(8, hand.getCardValue(3));
        assertEquals('D', hand.getCardSuit(4));
        assertEquals(12, hand.getCardValue(4));

    }

    @Test
    public void createPokerHandFromStringTest() {

        // black hand
    	
    	

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH");
        readHands.getWhitePlayerHand();
        
        assertEquals(2, readHands.getbBlackPlayerHand().getCardValue(0));
        assertEquals(3, readHands.getbBlackPlayerHand().getCardValue(1));
        assertEquals(5, readHands.getbBlackPlayerHand().getCardValue(2));
        assertEquals(9, readHands.getbBlackPlayerHand().getCardValue(3));
        assertEquals(13, readHands.getbBlackPlayerHand().getCardValue(4));
        assertEquals('H', readHands.blackPlayer.getCardSuit(0));
        assertEquals('D', readHands.blackPlayer.getCardSuit(1));
        assertEquals('S', readHands.blackPlayer.getCardSuit(2));
        assertEquals('C', readHands.blackPlayer.getCardSuit(3));
        assertEquals('D', readHands.blackPlayer.getCardSuit(4));

        // white hand
        assertEquals(2, readHands.blackPlayer.getCardValue(0));
        assertEquals(3, readHands.blackPlayer.getCardValue(1));
        assertEquals(4, readHands.getWhitePlayerHand().getCardValue(2));
        assertEquals(8, readHands.getWhitePlayerHand().getCardValue(3));
        assertEquals(14, readHands.getWhitePlayerHand().getCardValue(4));
        assertEquals('C', readHands.getWhitePlayerHand().getCardSuit(0));
        assertEquals('H', readHands.whitePlayer.getCardSuit(1));
        assertEquals('S', readHands.whitePlayer.getCardSuit(2));
        assertEquals('C', readHands.whitePlayer.getCardSuit(3));
        assertEquals('H', readHands.whitePlayer.getCardSuit(4));

    }

    @Test
    public void highestCardTest() {
        String[] newArray;
        newArray = new String[] { "2H", "10S", "8C", "JC", "5D" };
        PokerHands highCard = new PokerHands(newArray);
        assertEquals(11, highCard.determineHigestCard());

    }

    @Test
    public void hasPairTest() {

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 5H KD KS 3C 2D White: 2C 3H 4S 8C AH");
        PokerHands pairCheck = readHands.getbBlackPlayerHand();
        assertEquals(13, pairCheck.determineHigestCard());
        assertEquals(1, pairCheck.hasPair(pairCheck));
        assertEquals(true, pairCheck.isPair(pairCheck));
        assertEquals(1, pairCheck.getRank(pairCheck));
    }

    @Test
    public void isThreeOfAKindTest() {
        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: QH 3D 3S 3C 4D White: 3C 3H 4S 8C AH");
        PokerHands pairCheck2 = readHands.getbBlackPlayerHand();
        assertEquals(12, pairCheck2.determineHigestCard());
        assertEquals(3, pairCheck2.hasPair(pairCheck2));
        assertEquals(true, pairCheck2.isThreeofAKind(pairCheck2));
        assertEquals(3, pairCheck2.getRank(pairCheck2));

        PokerHands threeOfKind = readHands.getWhitePlayerHand();
        assertEquals(14, threeOfKind.determineHigestCard());
        assertEquals(1, threeOfKind.hasPair(threeOfKind));
        assertEquals(false, threeOfKind.isThreeofAKind(threeOfKind));

    }

    @Test
    public void isFourOfAKindTest() {
        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 2H 2D 5S 2C 2D White: 3C 3H 3S 3C AH");
        PokerHands pairCheck2 = readHands.getbBlackPlayerHand();
        assertEquals(5, pairCheck2.determineHigestCard());
        assertEquals(6, pairCheck2.hasPair(pairCheck2));
        assertEquals(true, pairCheck2.isFourofAKind(pairCheck2));
        assertEquals(7, pairCheck2.getRank(pairCheck2));

        PokerHands fourOfKind = readHands.getWhitePlayerHand();
        assertEquals(14, fourOfKind.determineHigestCard());
        assertEquals(6, fourOfKind.hasPair(fourOfKind));
        assertEquals(true, fourOfKind.isFourofAKind(fourOfKind));
        assertEquals(7, fourOfKind.getRank(fourOfKind));
    }

    @Test
    public void isFlushTest() {

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: AC 2C 5C 3C JC White: 3C 3H 3S 3C AH");
        PokerHands pairCheck2 = readHands.getbBlackPlayerHand();
        assertEquals(14, pairCheck2.determineHigestCard());
        assertEquals(5, pairCheck2.hasPair(pairCheck2));
        assertEquals(true, pairCheck2.isFlush());
        assertEquals(5, pairCheck2.getRank(pairCheck2));
    }

    @Test

    public void sortTest() {

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 2C 2C 5C 2C 2C White: 3C 3H 3S 3C AH");
        PokerHands sortCheck = readHands.getbBlackPlayerHand();

        sortCheck.sort();
        assertEquals(2, sortCheck.getCardValue(0));
        assertEquals(2, sortCheck.getCardValue(1));
        assertEquals(2, sortCheck.getCardValue(2));
        assertEquals(2, sortCheck.getCardValue(3));
        assertEquals(5, sortCheck.getCardValue(4));

    }

    @Test

    public void straightTest() {

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 4C 6S 9C 7C 8C White: 3C 3H 3S 3C AH");
        PokerHands straightCheck = readHands.getbBlackPlayerHand();

      
        straightCheck.isStraight(straightCheck);
        assertEquals(4, straightCheck.getCardValue(0));
        assertEquals(6, straightCheck.getCardValue(1));
        assertEquals(7, straightCheck.getCardValue(2));
        assertEquals(8, straightCheck.getCardValue(3));
        assertEquals(9, straightCheck.getCardValue(4));
        assertEquals(0, straightCheck.hasPair(straightCheck));
        assertEquals(false, straightCheck.isStraight(straightCheck));
        assertEquals(0, straightCheck.getRank(straightCheck));

    }

    @Test

    public void straightFlushTest() {

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 10C JC QC KC AC White: 3C 3H 3S 3C AH");
        PokerHands straightCheck = readHands.getbBlackPlayerHand();

        straightCheck.sort();
        assertEquals(10, straightCheck.getCardValue(0));
        assertEquals(11, straightCheck.getCardValue(1));
        assertEquals(12, straightCheck.getCardValue(2));
        assertEquals(13, straightCheck.getCardValue(3));
        assertEquals(14, straightCheck.getCardValue(4));
        assertEquals(true,straightCheck.isFlush());
        assertEquals(true,straightCheck.isStraight(straightCheck));
        assertEquals(true, straightCheck.isStraightFlush(straightCheck));
        assertEquals(8, straightCheck.getRank(straightCheck));
    }

    @Test

    public void notStraightFlushTest() {

        // String[] newArray;
        // newArray = new String[] { "10D", "JC", "QC", "KC", "AC" };

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 10D JC QC KC AC White: 3C 3H 3S 3C AH");
        PokerHands straightCheck = readHands.getbBlackPlayerHand();

        straightCheck.sort();
        assertEquals(10, straightCheck.getCardValue(0));
        assertEquals(11, straightCheck.getCardValue(1));
        assertEquals(12, straightCheck.getCardValue(2));
        assertEquals(13, straightCheck.getCardValue(3));
        assertEquals(14, straightCheck.getCardValue(4));
        assertEquals(false, straightCheck.isStraightFlush(straightCheck));

    }

    @Test

    public void fullHouse() {

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 5H 5D 5S 2C 2D White: 3C 3H 3S 3C AH");
        PokerHands pairCheck2 = readHands.getbBlackPlayerHand();
        assertEquals(5, pairCheck2.determineHigestCard());
        assertEquals(4, pairCheck2.hasPair(pairCheck2));

        assertEquals(true, pairCheck2.isFullHouse(pairCheck2));
        assertEquals(6, pairCheck2.getRank(pairCheck2));
    }

    @Test

    public void twoPairTest() {

        PokerHandEvaluator readHands = new PokerHandEvaluator("Black: 4H 6D 6S 2C 2D White: 3C 3H 3S 3C AH");
        PokerHands pairCheck2 = readHands.getbBlackPlayerHand();
        
        assertEquals(6, pairCheck2.determineHigestCard());
        assertEquals(2, pairCheck2.hasPair(pairCheck2));

        assertEquals(true, pairCheck2.isTwoPair(pairCheck2));
        assertEquals(2, pairCheck2.getRank( pairCheck2));
    
    }

    @Test

    public void evaluateHandsTest() {
        PokerHandEvaluator evaluate = new PokerHandEvaluator("Black: 4H 6D 6S 4C 4D White: 3C 3H 3S 2C AH");
        PokerHands check = evaluate.getbBlackPlayerHand();
        assertEquals(6, check.determineHigestCard());
        assertEquals(4, check.hasPair(check));
        assertEquals(6, check.getRank(check));
        
        
        PokerHands check2 = evaluate.getWhitePlayerHand();
        assertEquals(14, check2.determineHigestCard());
        assertEquals(3, check2.hasPair(check2));
        assertEquals(3, check2.getRank(check2));
        assertEquals("Black Player Won!", evaluate.evaluateHand());
        
        PokerHandEvaluator evaluate1 = new PokerHandEvaluator("Black: 4H 4D 4S 3C 2D White: 9C 5H 6S 7C 8H");
        
        assertEquals("White Player Won!", evaluate1.evaluateHand());
    }
}
