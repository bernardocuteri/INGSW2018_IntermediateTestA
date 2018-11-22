package it.unical.ingsw2018.IntermediateTest_A;

import java.util.TreeSet;

public class Knapsack 
{
  
	private int capacity;
    
	private TreeSet<Item> items;
	
	private int currentWeight;

	private int currentValue;
	
	public Knapsack(int capacity) {
		this.capacity = capacity;
		this.currentWeight = 0;
		this.currentValue = 0;
		this.items = new TreeSet<>();
	}

	
	public int getCurrentValue() {
		return currentValue;
	}

	public int getCapacity() {
		return capacity;
	}

	public TreeSet<Item> getItems() {
		return items;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}
	
	public void reset() {
		items.clear();
		currentValue = 0;
		currentWeight = 0;
	}
	
	public void addItem(Item item) {
		if(currentWeight + item.getWeight() > capacity) throw new KnapsackInsertionError();
		else {
			items.add(item);
			currentValue += item.getValue();
			currentWeight += item.getWeight();
		}
	}
	
	//ipotizzo che ci sia sempre
	public void removeItem(Item item) {
		currentWeight -= item.getWeight();
		currentValue -= item.getValue();
		items.remove(item);
		
	}
	
	public Item getBestItem() {
		int rapporto = 0;
		Item best = null;
		
		for(Item i : items) {
			if(( i.getValue() / i.getWeight() ) > rapporto ) {
				rapporto = i.getValue() / i.getWeight();
				best = i;
			}
		}
		return best;
	}
    
}
