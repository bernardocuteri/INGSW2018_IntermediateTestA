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
	
	public void addItem(Item item) throws Exception {
		int weight = item.getWeight();
		int value = item.getValue();
		
		if (currentWeight + weight > capacity) {
			throw new Exception("Can't fit item into the knapsack!");
		} else {
			currentWeight += weight;
			currentValue += value; 
			items.add(item);
		}
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		currentWeight -= item.weight;
		currentValue -= item.value; 
	}
	
	public Item getBestItem() {
		// vedi Item::compareTo(Item)
		return items.first();
	}
    
}
