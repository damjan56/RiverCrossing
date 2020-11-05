package boat;

import java.util.Scanner;

/*
 * Dictates user input and changes the state
 */
public class GameThread extends Thread {

	Game game;
	Listener listener;

	public GameThread(Game g) {
		game = g;
		listener = new Listener(g);
	}

	public void run() {
		System.out.println("started gamethread");
		Scanner scanner = new Scanner(System.in);
		String input;
		
		synchronized(game) {
			
			listener.start();
			
			game.print();
			System.out.println("Will you load (W)olf, (S)heep, or (C)abbage onto the boat, or (R)ow?");
			input = scanner.nextLine();
			
			while(! input.equalsIgnoreCase("r")) {
				if(input.equalsIgnoreCase("w")) {
					game.load(Item.WOLF);
				}
				if(input.equalsIgnoreCase("s")) {
					game.load(Item.SHEEP);
				}
				if(input.equalsIgnoreCase("c")) {
					game.load(Item.CABBAGE);
				}
				
				game.print();
				System.out.println("Will you load (W)olf, (S)heep, or (C)abbage onto the boat, or (R)ow?");
				input = scanner.nextLine();
			}

			try {
				game.row();
				game.wait();
				input = "";
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			while(!game.isOver()) {

				while(! input.equalsIgnoreCase("r")) {
					if(input.equalsIgnoreCase("w")) {
						game.load(Item.WOLF);
					}
					if(input.equalsIgnoreCase("s")) {
						game.load(Item.SHEEP);
					}
					if(input.equalsIgnoreCase("c")) {
						game.load(Item.CABBAGE);
					}
					
					game.print();
					System.out.println("Will you load (W)olf, (S)heep, or (C)abbage onto the boat, or (R)ow?");
					input = scanner.nextLine();
				}
				game.row();
				game.notifyAll();
				input = "";
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
