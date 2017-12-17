package formation.xp;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests for the different user stories
 * 
 */

public class GeneralTest extends TestCase {
	
	@Test
	/**
	 * Test the bet method
	 * 
	 */
	public void testBet() {
        Player toto = new Player(100);
	toto.bet(30);
        assertEquals(toto.getPlayerLastBet(),30);
        assertEquals(toto.getRemainingStake(),70);
        }
	
	
	@Test
	/**
	 * Test the bet method that checks the player's remaing stake
	 * 
	 */
	public void testRemainingStake() {
		Player toto = new Player(100);
		toto.bet(30);
        assertEquals(toto.checkRemainingStake(),70);
        }
	
	
	@Test
	/**
	 * Test the bet method that checks the player's remaing stake
	 * 
	 */
	public void testGameSum() {
		Game game = new Game(5);
		for (Iterator<Player> it = game.getPlayers().iterator(); it.hasNext();){
			 ((Player) it.next()).bet(10);
		}
		assertEquals(game.seeGameSum(),50);
        }
	
	
	@Test
	public void testKickPlayer() {
		Game game = new Game(3);
		Iterator<Player> it = game.getplayers().iterator(); 
		it.next().setRemainingStake(0);
		game.kickPlayer();
		
		assertEquals(game.getplayers().size(),2);
     }
	
	
	@Test
	public void test_player() {
		Player toto = new Player("toto",1000);
                assertEquals(toto.getName(),"toto");
                ArrayList<Card> my_hand = new ArrayList<Card>();
                my_hand.add(new Card(Card.Suit.SPADES,1));
                my_hand.add(new Card(Card.Suit.SPADES,2));
                toto.setHand(my_hand);
                System.out.print(toto.toString());
                assertEquals(toto.toString(),"Player: toto\nInitialStake: 1000\nRemaining Stake: 1000\nHand:\n*Ace of Spades\n*2 of Spades\n");
        }
        
	
	
	
    @Test
	public void test_card(){
                Card ace_spades = new Card(Card.Suit.SPADES,1);
                assertEquals(ace_spades.getSuit(),Card.Suit.SPADES);
                assertEquals(ace_spades.getValue(),1);
                assertEquals(ace_spades.toString(),"Ace of Spades");
        }
   @Test
    public void test_game(){
                Game game = new Game(5);
                assertEquals(game.getDeck().size(),52);
                assertEquals(game.getplayers().get(4).getName(),"Player4");
                game.giveCards();
                assertEquals(game.getplayers().get(2).getHand().size(),2);
    }
    
    
    
        
}
