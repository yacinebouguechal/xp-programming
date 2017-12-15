/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;
import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.Collections;
/**
 *
 * @author bouguechal
 */
public class Game {
  private LinkedList<Card> m_deck;
  private List<Player> m_players;

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
          m_players.add(new Player("Player" + i));
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

public void updateLastBet(int amount) {
	lastBet=amount;	
}

    
}
