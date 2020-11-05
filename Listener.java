package boat;

/*
 * Runs after every row, and checks for win / loss
 */
public class Listener extends Thread{

	Game game;
	
	public Listener(Game g) {
		game = g;
	}
	
	public void run() {
		
		synchronized(game) {
			
			while(! game.isOver()) {
				

				//case 0, all 3 items have been successfully transported
				if(game.getFar().size() == 3) {
					System.out.println("Transport successful! You win!");
					game.end();
				}
				//case 1, sheep & wolf are in the near shore
				else if(game.getNear().contains(Item.SHEEP) && game.getNear().contains(Item.WOLF)) {
					System.out.println("The wolf ate the sheep. Game over");
					game.end();
				}
				//case 2, sheep & cabbage are in the near shore
				else if(game.getNear().contains(Item.SHEEP) && game.getNear().contains(Item.CABBAGE)) {
					System.out.println("The sheep ate the cabbage. Game over");
					game.end();
				}
				//case 3. sheep & wolf are in the boat
				else if(game.getBoat().contains(Item.SHEEP) && game.getBoat().contains(Item.WOLF)) {
					System.out.println("The wolf ate the sheep. Game over");
					game.end();
				}
				//case 4, sheep & cabbage are in the boat
				else if(game.getBoat().contains(Item.SHEEP) && game.getBoat().contains(Item.CABBAGE)) {
					System.out.println("The sheep ate the cabbage. Game over");
					game.end();
				}
				//case 5, sheep & wolf are in the far shore
				else if(game.getFar().contains(Item.SHEEP) && game.getFar().contains(Item.WOLF)) {
					System.out.println("The wolf ate the sheep. Game over");
					game.end();
				}
				//case 6, sheep & cabbage are in the far shore
				else if(game.getFar().contains(Item.SHEEP) && game.getFar().contains(Item.CABBAGE)) {
					System.out.println("The sheep ate the cabbage. Game over");
					game.end();
				}
				else {
					System.out.println("Rowing");
				}

				game.notifyAll();
				
				if(! game.isOver()) {
					try {
						game.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
