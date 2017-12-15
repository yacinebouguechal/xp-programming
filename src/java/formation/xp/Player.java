/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;
import java.util.ArrayList;


/**
 * Manage Players' informations, bets, actions, stakes
 * 
 */

public class Player {
	
	private String mName; //player's name
	private ArrayList<Card> mHand; //player's cards
	private int initialStake; //initial stake of the player
	private int remainingStake; //player's remaining stake
	private int playerLastBet; //player's last bet
	
	

	/**
	 *
	 * Constructor with name only
	 */
   public Player(String name){
       mName=name;
   }
   
	/**
	 *
	 * Constructor with initial Stake only
	 */
   public Player(int initialStake){
       this.initialStake=initialStake;
   }
   
	/**
	 *
	 * Constructor with name and initial Stake
	 */
   public Player(String name, int initialStake){
   	this. mName=name;
       this.initialStake=initialStake;
   }
   
   
	/**
	 *
	 * GETTER for initialStake
	 */
   public int getInitialStake(){
       return initialStake;
   }
   
   /**
	 *
	 * GETTER for playerLastBet
	 */
   public int getPlayerLastBet(){
       return playerLastBet;
   }
   
   /**
	 *
	 * GETTER for remainingStake
	 */
   public int getRemainingStake(){
       return remainingStake;
   }
   
   /**
	 * GETTER for playerLastBet
	 * 
	 */
	public int getPlayerLastBest(){
		return playerLastBet;
	}
	
	/**
	 *
	 * GETTER for mHand
	 */
   public ArrayList<Card> getHand() {
       return mHand;
   }
   
   
	/**
	 *
	 * GETTER for mName
	 */
   public String getName() {
       return mName;
   }
   
	
   /**
	 *
	 *SETTER for remainingStake
	 */
    public void setRemainingStake(int stake){
    	remainingStake=stake;
    }   
    
    
    /**
	 *
	 * SETTER for mHand
	 */
   public void setHand(ArrayList<Card> mHand) {
       this.mHand = mHand;
   }

   

	
   /**
	 *
	 * SETTER for initialStake
	 */
   public void setInitialStake(int initAmount){
       this.initialStake =initAmount;
   }
  
   
	/**
	 *
	 * The player bets the amount specified
	 */
	public void bet(int amount) {
		playerLastBet=amount; // update the player's last bet
		remainingStake=initialStake-amount; //update the player's remaing stake
	}
	
	
	/**
	 *
	 * The player bets the minimum amount possible
	 */
	public void callBet(int lastBet) {
		this.bet(lastBet);
	}
	
	/**
	 *
	 * The player bets all his stake
	 */
	public void allBet(){
		this.bet(initialStake);
	}
	
	/**
	 *
	 * The player raises the bet 
	 */
	public void raiseBet (int raise, int LastBet){
		this.bet(LastBet + raise);
	}
	
	/**
	 *
	 * The player decides to fold
	 */
	public void fold(){
		this.bet(playerLastBet);
	}
	
	/**
	 *
	 * The player checks his last bet
	 */
    public void check (){
    	System.out.println(playerLastBet);
    }
    
    
    /**
	 *
	 * Check the remaining stake
	 */
    public int checkRemainingStake(){
        System.out.println(remainingStake);
        return remainingStake;
    }
    
 
}



