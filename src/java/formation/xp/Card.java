/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;

/**
 *
 * Card class
 */

public class Card {
	
	static public enum Suit {CLUBS,HEARTS, DIAMONDS, SPADES };
    private int mValue;
    private Suit mSuit;
    
    /**
	 *
	 * Constructor 
	 */
    public Card(Suit suit, int value){
    	assert(value<14);
        assert(0<value);
        mSuit = suit;
        mValue = value;
    }
       
    /**
	 *
	 * Constructor with name only
	 */
    public Suit getSuit() {
    	return mSuit;
    }

    /**
	 *
	 * Constructor with name only
	 */
    public int getValue() {
        return mValue;
    }
    
    /**
	 *
	 * toString (card)
	 */
    public String toString(){
    	String result;
        switch(mValue)
        {
            case 13:
                result = "King";
                break;
            case 12:
                result = "Queen";
                break;
            case 11:
                result = "Jack";
                break;
            case 1:
                result = "Ace";
                break;
            default:
                result = String.valueOf(mValue);
        }
        result += " of ";
        
        switch(mSuit)
        {
            case SPADES:
                result += "Spades";
                break;
            case DIAMONDS:
                result += "Diamonds";
                break;
            case HEARTS:
                result += "Hearts";
                break;
            case CLUBS:
                result += "Clubs";
                break;
        }
        return result;
    }
    
}
