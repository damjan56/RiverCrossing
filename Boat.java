package boat;

//The only difference between a Boat and a Zone is that the boat can hold 2 items, but a shore can hold 3
public class Boat extends Zone{

	//I made this a boolean so that I can check:
	//IF add to Zone A succeeds, then remove from Zone B can follow
	@Override
	public boolean addItem(Item i) {
		if(items.size() < 2) {
			items.add(i);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		if(items.contains(Item.WOLF) && items.contains(Item.SHEEP)) {
			return "W|S";
		}
		if(items.contains(Item.WOLF) && items.contains(Item.CABBAGE)) {
			return "W|C";
		}
		if(items.contains(Item.SHEEP) && items.contains(Item.CABBAGE)) {
			return "S|C";
		}
		
		if(items.contains(Item.WOLF)) {
			return "W|_";
		}
		if(items.contains(Item.SHEEP)) {
			return "S|_";
		}
		if(items.contains(Item.CABBAGE)) {
			return "C|_";
		}
		
		return "_|_";
	}
}
