package formation.xp;

import org.junit.Test;

import junit.framework.TestCase;

public class GeneralTest extends TestCase {
	
	@Test
	public void test_bet() {
		Player toto = new Player(100);
		toto.bet(30);
        assertEquals(toto.getPlayerLastBet(),30);
        assertEquals(toto.getRemainingStake(),70);
        }
	
	
	
	
	@Test
	public void test_player() {
		Player toto = new Player("toto");
                assertEquals(toto.getName(),"toto");
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
