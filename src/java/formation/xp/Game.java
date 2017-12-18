package formation.xp;
import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;


/**
 *
 * Manage the game progress
 */

public class Game {
	
	private LinkedList<Card> mDeck; //cards deck
	private List<Player> mPlayers; //list of players
	private int gameSum; //game sum
	private List<Card> mRevealed; //list of revealed cards
	private int lastBet; // amount of last bet
	
    /**
	 *
	 * GETTER mPlayers
	 */ 
    public List<Player> getPlayers() {
    	return this.mPlayers;
    }
    
    /**
	 *
	 * GETTER mDeck
	 */ 
    public List<Card> getDeck() {
        return mDeck;
    }
    
	/**
	 *
	 * GETTER gameSum
	 */
	public int getGameSum(){
		return this.gameSum;
	}
	
    /**
	 *
	 * GETTER lastBet
	 */ 
    public int getLastbet() {
    	return lastBet;
    }
    
    /**
	 *
	 * Create a game with the number of player
	 */ 
    public Game(int player_nb){ 
    	mDeck = new LinkedList<Card>();
    	for(Card.Suit suit : Card.Suit.values())
    		for(int value = 1; value<14; value++)
    			mDeck.add(new Card(suit, value));
    	Collections.shuffle(mDeck);
    	mPlayers = new ArrayList<Player>();
    	for(int i=0; i< player_nb; i++){
    		mPlayers.add(new Player("Player" + i, 1000));
    	}          
    }
    
    /**
	 *
	 * Give two cards to each player
	 */
    public void giveCards(){ 
    	for(Player player : mPlayers){
    		ArrayList<Card> hand = new ArrayList<Card>();
    		hand.add(mDeck.pop());
    		hand.add(mDeck.pop());
    		player.setHand(hand);
    	}
    }
    
    /**
	 *
	 * update the value of lastBet with the new amount
	 */
    public void updateLastBet(int amount) {
    	lastBet=amount;	
    }
    
    /**
	 *
	 * Manage a turn
	 */
    private int turn(int indexFirstBetter, int lastBet)
    {
        System.out.println("Taille mPlayer: "+ mPlayers.size());
        System.out.println("index : "+ indexFirstBetter);
        mPlayers.get(indexFirstBetter).makeTurn(lastBet);
        int indexLastBetter = indexFirstBetter;
        
        for(int i = (indexFirstBetter+1)%mPlayers.size(); i != indexLastBetter; i=(i+1)%mPlayers.size())
        {        
            System.out.println("maketurn");
            mPlayers.get(i).makeTurn(lastBet);
            if(mPlayers.get(i).getPlayerLastBet()>lastBet)
             {
                 indexLastBetter=i;
                 lastBet = mPlayers.get(i).getPlayerLastBet();
                 System.out.println("Best bet is: " + lastBet);
             }      
        }
        return lastBet;
    }
    
    /**
	 *
	 * Distribute gains
	 */
    private void distributeGains()
    {
        
    }

    /**
	 *
	 * Reveal a card
	 */
    private void revealCard(){
    	System.out.print("+++++++++++++++++++++++++++");
    	System.out.print("Revealing Card:\n");
    	this.mRevealed.add(mDeck.pop());
    	System.out.println(this.mRevealed.get(this.mRevealed.size()-1).toString());    
    }
    
    /**
	 *
	 * Run the game (main program)
	 */
    public void run() {
    	int blindAmount = 10;
    	for(int k=0; k<2; k++)
    	{
    		for(Player current : this.mPlayers){
    			current.resetBet(); //we reset the bet of all the player when the turn begins
    		}
    		mDeck = new LinkedList<Card>();
	        for(Card.Suit suit : Card.Suit.values())
	            for(int value = 1; value<14; value++)
	                 mDeck.add(new Card(suit, value));
	
	        Collections.shuffle(mDeck);	
	        Player littleBlind = mPlayers.get(0);
	        Player bigBlind = mPlayers.get(1);
	
	        this.mRevealed = new ArrayList<Card>();
	
	        littleBlind.bet(blindAmount);
	        bigBlind.bet(2*blindAmount);
	
	        int lastBet=2*blindAmount;
	
	        mDeck.pop();
	        giveCards();
	
	        lastBet = turn(2, lastBet);
	
	        mDeck.pop();
	        revealCard();
	        revealCard();
	        revealCard();
	
	        lastBet = turn(0, lastBet);
	
	        mDeck.pop();
	        revealCard();
	        lastBet = turn(0, lastBet);
	
	        mDeck.pop();
	        revealCard();
	        lastBet = turn(0,lastBet);
	
	        distributeGains();	
	    }
    }
  
    /**
	 *
	 * Kick a player if has no more stake
	 */
	public void kickPlayer(){
		for (Iterator<Player> it = mPlayers.iterator(); it.hasNext();){
			if (((Player) it.next()).getRemainingStake()==0){
				mPlayers.remove(it.next());
			}	 
		}
	}

	/**
	 *
	 * See the game sum
	 */
	public int seeGameSum(){
		gameSum=0;
		for (Iterator<Player> it = mPlayers.iterator(); it.hasNext();){
			gameSum += ((Player) it.next()).getPlayerLastBet();
		}
		System.out.println(gameSum);
		return this.gameSum;
	}

}
    


