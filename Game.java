package boat;

import java.util.ArrayList;

public class Game {
	private Zone near;
	private Zone far;
	private Boat boat;
	boolean over;
	boolean isNear;
	
	public Game() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(Item.CABBAGE);
		items.add(Item.SHEEP);
		items.add(Item.WOLF);
		
		near = new Zone(items);
		far = new Zone();
		boat = new Boat();
		over = false;
		isNear = true;
	}
	
	public Game(Zone n, Zone f, Boat b) {
		near = n;
		far = f;
		boat = b;
	}
	
	public Zone getNear() {
		return near;
	}
	public void setNear(Zone near) {
		this.near = near;
	}
	public Zone getFar() {
		return far;
	}
	public void setFar(Zone far) {
		this.far = far;
	}
	public Boat getBoat() {
		return boat;
	}
	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	public boolean isOver() {
		return over;
	}
	public void end() {
		over = true;
	}
	
	public void print() {
		if(isNear) {
			System.out.println("NEAR      BOAT          FAR");
			System.out.println();
			System.out.println(" _ _ _   / _~_~ ~ ~ ~ / _ _ _");
			System.out.println("|" + near + "| / |" + boat + "|> ~ ~ / |" + far + "|");
			System.out.println("       /  ~ ~ ~ ~ ~ /");
		} else {
			System.out.println("NEAR           BOAT    FAR");
			System.out.println();
			System.out.println(" _ _ _   / ~ ~ ~_~_~  / _ _ _");
			System.out.println("|" + near + "| / ~ ~ <|" + boat + "| / |" + far + "|");
			System.out.println("       / ~ ~ ~ ~ ~  /");
		}
	}

	//The white zone is for the loading and unloading of passengers and cargo only
	public void load(Item i) {
		if(isNear) {
			if(near.contains(i)) {
				if(boat.addItem(i)) {
					near.removeItem(i);
				} else {
					System.out.println("Boat is full!");
				}
			} else if(boat.contains(i)) {
				boat.removeItem(i);
				near.addItem(i);
			} else {
				System.out.println(i + " not found");
			}
		} else {
			if(far.contains(i)) {
				if(boat.addItem(i)) {
					far.removeItem(i);
				} else {
					System.out.println("Boat is full!");
				}
			} else if(boat.contains(i)) {
				boat.removeItem(i);
				far.addItem(i);
			} else {
				System.out.println(i + " not found");
			}
		}  
	}
	
	public void row() {
		isNear = ! isNear;
	}
}
