package it.unical.ingsw2018.IntermediateTest_A;

import java.util.TreeSet;

public class Knapsack {

	private int capacity;
	private TreeSet<Item> items;
	private int currentWeight;
	private int currentValue;
	
	//Best item in tempo costante
	private Item bestItem;
	private float bestItemRatio;

	public Knapsack(int capacity) {
		this.capacity = capacity;
		this.currentWeight = 0;
		this.currentValue = 0;
		this.items = new TreeSet<>();
		
		//Di default = 0, il primo (e unico) item è il primo bestItem
		bestItemRatio = 0;
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
		if (currentWeight + item.getWeight() > capacity)
			throw new KnapsackInsertionError();
		else {
			items.add(item);
			currentWeight += item.getWeight();
			currentValue += item.getValue();
			
			if ((item.getValue() * 1.0f) / item.getWeight() > bestItemRatio) {
				bestItem = item;
				bestItemRatio = (item.getValue() * 1.0f) / item.getWeight();
			}
		}
	}
	
	public void removeItem(Item item) {
		if (!items.contains(item)) return;
		
		currentWeight -= item.getWeight();
		currentValue -= item.getValue();
		items.remove(item);
	}
	
	public Item getBestItem() {
		return bestItem;
	}

}
