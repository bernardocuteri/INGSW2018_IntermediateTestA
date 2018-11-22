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
		if(currentWeight+item.weight<capacity) {
			items.add(item);
			currentValue+=item.value;
			currentWeight+=item.weight;
		}
		else
			throw new KnapsackInsertionError();
	}
	
	public void removeItem(Item item) {
			items.remove(item);
			currentValue-=item.value;
			currentWeight-=item.weight;
	}
	
	public Item getBestItem() {
		Item i = new Item(-1, 1);
		for (Item item : items) {
			if((item.value/item.weight)>(i.value/i.weight))
				i=item;
		}
		return i;
	}
}
