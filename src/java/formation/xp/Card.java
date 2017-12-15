/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;

/**
 *
 * @author bouguechal
 */
public class Card {
    public Card(Suit suit, int value){
        assert(value<14);
        assert(0<value);
        m_suit = suit;
        m_value = value;
    }
    
    static public enum Suit {CLUBS,HEARTS, DIAMONDS, SPADES };
    private int m_value;

    public Suit getSuit() {
        return m_suit;
    }

    public int getValue() {
        return m_value;
    }
    
    private Suit m_suit;
    
    public String toString(){
        String result;
        switch(m_value)
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
                result = String.valueOf(m_value);
        }
        result += " of ";
        
        switch(m_suit)
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
