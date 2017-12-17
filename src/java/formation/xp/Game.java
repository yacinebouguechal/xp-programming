/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;
import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;
/**
 *
 * @author bouguechal
 */
public class Game {
  private LinkedList<Card> m_deck;
  private List<Player> m_players;
  private int gameSum;
    public List<Player> getplayers() {
        return m_players;
    }

  public List<Card> getDeck() {
        return m_deck;
    }
    
  public Game(int player_nb){ //Create a game with the number of player
      m_deck = new LinkedList<Card>();
      for(Card.Suit suit : Card.Suit.values())
          for(int value = 1; value<14; value++)
              m_deck.add(new Card(suit, value));
      
      Collections.shuffle(m_deck);
      
      m_players = new ArrayList<Player>();
      for(int i=0; i< player_nb; i++){
          m_players.add(new Player("Player" + i, 1000));
      }
      
               
  }
  
  public void giveCards(){ //Give two cards to all players
      for(Player player : m_players){
          ArrayList<Card> hand = new ArrayList<Card>();
          hand.add(m_deck.pop());
          hand.add(m_deck.pop());
          player.setHand(hand);
      }
  }
  
//public static int lastBet;
  
  private int lastBet;

  public int getLastbet() {
      return lastBet;
  }

  public List<Player> getPlayers() {
      return this.m_players;
  }
  
public void updateLastBet(int amount) {
	lastBet=amount;	
}
    
    

private int turn(int index_first_better, int last_bet)
    {
        System.out.println("Taille m_player: "+ m_players.size());
        System.out.println("index : "+ index_first_better);
        m_players.get(index_first_better).makeTurn(last_bet);
        int index_lastbetter = index_first_better;
        
        
        
        for(int i = (index_first_better+1)%m_players.size(); i != index_lastbetter; i=(i+1)%m_players.size())
        {
            
            System.out.println("maketurn");
            m_players.get(i).makeTurn(last_bet);
             if(m_players.get(i).getPlayerLastBet()>last_bet)
             {
                 index_lastbetter=i;
                 last_bet = m_players.get(i).getPlayerLastBet();
             }      
        }
        return last_bet;
    }
    
private void distrubute_gains()
{
        
}
    
    
public void run() {

    int blind_amount = 10;
    for(int k=0; k<2; k++)
    {
        for(Player current : this.m_players){
            current.resetBet(); //we reset the bet of all the player when the turn begins
        }
        m_deck = new LinkedList<Card>();
        for(Card.Suit suit : Card.Suit.values())
            for(int value = 1; value<14; value++)
                 m_deck.add(new Card(suit, value));

        Collections.shuffle(m_deck);

        Player little_blind = m_players.get(0);
        Player big_blind = m_players.get(1);



        List<Card> revealed = new ArrayList<Card>();

        little_blind.bet(blind_amount);
        big_blind.bet(2*blind_amount);

        int last_bet=2*blind_amount;

        m_deck.pop();
        giveCards();

        last_bet = turn(2, last_bet);

        m_deck.pop();
        revealed.add(m_deck.pop());
        revealed.add(m_deck.pop());
        revealed.add(m_deck.pop());

        last_bet = turn(0, last_bet);

        m_deck.pop();
        revealed.add(m_deck.pop());
        last_bet = turn(0, last_bet);

        m_deck.pop();
        revealed.add(m_deck.pop());
        last_bet = turn(0,last_bet);

        distrubute_gains();

    }


}
  

public void kickPlayer(){
	for (Iterator<Player> it = m_players.iterator(); it.hasNext();){
		 if (((Player) it.next()).getRemainingStake()==0){
			 m_players.remove(it.next());
		 }	 
	}
}


public int seeGameSum(){
	gameSum=0;
	for (Iterator<Player> it = m_players.iterator(); it.hasNext();){
		 gameSum += ((Player) it.next()).getPlayerLastBet();
		// System.out.println(((Player) it.next()).getPlayerLastBet());
	}
	System.out.println(gameSum);
	return this.gameSum;
}

public int getGameSum(){
	return this.gameSum;
}
}
    


