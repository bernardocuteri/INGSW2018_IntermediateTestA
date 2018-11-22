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
	
	public void addItem(Item item) {
		
		if(currentWeight + item.getWeight() < capacity) {
			items.add(item);
			currentWeight += item.getWeight();
			currentValue += item.getValue();
		}		
		else throw new KnapsackInsertionError();
		
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		currentWeight -= item.getWeight();
		currentValue -= item.getValue();
	}
	
	public Item getBestItem() {
		int maxRapp = 0;
		Item temp = new Item(100, 20);
		
		for(Item item : items) {
			if((item.getWeight() / item.getValue()) > maxRapp) {
				maxRapp = (item.getWeight() / item.getValue());
				temp = item;
			}
		}
		
		return temp;
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
    
}
