/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;
import java.util.ArrayList;

/**
 *
 * @author bouguechal
 */


public class Player {
    private String m_name;
    private ArrayList<Card> m_hand;

    public void setHand(ArrayList<Card> m_hand) {
        this.m_hand = m_hand;
    }

    public ArrayList<Card> getHand() {
        return m_hand;
    }
            
    public String getName() {
        return m_name;
    }
    
    public Player(String name){
        m_name=name;
    }
    
    
    
    
}
