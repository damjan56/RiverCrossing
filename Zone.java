package boat;

import java.util.ArrayList;

public class Zone {
	protected ArrayList<Item> items;
	
	public Zone() {
		items = new ArrayList<Item>();
	}
	
	public Zone(ArrayList<Item> items) {
		super();
		this.items = items;
	}

	//I made this a boolean so that I can check:
	//IF add to Zone A succeeds, then remove from Zone B can follow
	public boolean addItem(Item i) {
		if(items.size() < 3) {
			items.add(i);
			return true;
		}
		return false;
	}
	
	public Item removeItem(Item i) {
		items.remove(i);
		return i;
	}

	public boolean contains(Item i) {
		if(items.contains(i)) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return items.size();
	}

	@Override
	public String toString() {
		String string = "";
		
		if(items.contains(Item.WOLF)) {
			string += "W|";
		} else {
			string += "_|";
		}
		if(items.contains(Item.SHEEP)) {
			string += "S|";
		} else {
			string += "_|";
		}
		if(items.contains(Item.CABBAGE)) {
			string += "C";
		} else {
			string += "_";
		}
		
		
		return string;
	}
}
