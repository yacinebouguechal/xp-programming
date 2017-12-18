package formation.xp;
import java.util.Scanner;

/**
*
* Main class
*/

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Agile Poker!");
		System.out.println("Enter the number of Players:");
		Scanner sc = new Scanner(System.in);
		Game game = new Game(sc.nextInt());
	game.run();
	}
}