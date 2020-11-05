package boat;

/**
 * @Author Damjan Nesic
 * @Version 1.0
 * This Program represents the classic river-crossing problem, wherein a rower must transport a wolf, a sheep, and a head of cabbage across a river
 * The wolf will eat the sheep if they are left alone together. A sheep will eat the cabbage if they are left alone together
 * The near shore and far shore can hold all three items, but the boat can only hold two (not including the rower)
 * 
 * Key things to watch out for:
 * "GameThread" and "Listener" are separate threads. GameThread reacts to user input, and Listener checks for win or lose conditions
 * "Game" entirely encapsulates the game *state*. We can think of Game as a "model class" with "business logic"
 * Therefore, both GameThread and Listener will need to have synchronized blocks on Game
 * I do not want to check for win/loss at an inopportune time
 * Take a look at the careful use of wait() and notifyAll()
 * This is synchronous programming (not asynchronous) and can be achieved with a single thread
 */

public class BoatGame {
	
	public static void main(String[] args) {
		Game game = new Game();

		GameThread g = new GameThread(game);
		
		g.start();
	}
}
