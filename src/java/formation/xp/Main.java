package formation.xp;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
            System.out.println("Hello World!");
            System.out.println("Enter the number of Players:");
            Scanner sc = new Scanner(System.in);
            Game game = new Game(sc.nextInt());
            game.run();
	}
}