/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;
import java.util.ArrayList;

import javax.smartcardio.Card;


/**
 *
 * @author bouguechal
 */


public class Player {
	
	private String m_name;
	private ArrayList<Card> m_hand;
	int initialStake;
	int remainingStake;
	int playerLastBet;
	ArrayList<Card> playerCards = new ArrayList<Card>();
	
	/*
	 * BET
	 */
	public void bet(int amount) {
		playerLastBet=amount;
		remainingStake=initialStake-amount;
	}
	
	/*
	 * playerLastBet getter
	 */
	public int getPlayerLastBest(){
		return playerLastBet;
	}
	
	/*
	 * Bet the minimum to continue playing (last Bet of the game)
	 */
	public void callBet(int lastBet) {
		this.bet(lastBet);
	}
	
	/*
	 *  Bet all you got
	 */
	public void allBet(){
		this.bet(initialStake);
	}
	
	

	/*
	 * Raise 
	 */
	public void raiseBet (int raise, int LastBet){
		this.bet(LastBet + raise);
	}
	
	/*
	 * fold
	 */
	public void fold(){
		this.bet(playerLastBet);
	}
	
    public void check (){
    	System.out.println(playerLastBet);
    }
    


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
    
    public Player(int initialStake){
        this.initialStake=initialStake;
    }
    
    public int getInitialStake(){
        return initialStake;
    }
    
    public int getPlayerLastBet(){
        return playerLastBet;
    }
    
    
    public int getRemainingStake(){
        return remainingStake;
    }
    
    
    
    
    
    
    
    
}



