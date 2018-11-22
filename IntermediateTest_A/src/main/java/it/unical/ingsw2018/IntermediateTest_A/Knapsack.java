package it.unical.ingsw2018.IntermediateTest_A;

import java.util.TreeSet;

public class Knapsack 
{
  
	private int capacity;
    
	private TreeSet<Item> items;

	/*
	 * Somma dei pesi
	 */
	private int currentWeight;

	/*
	 * Somma dei valori
	 */
	private int currentValue;

	public Knapsack(int capacity) {
		this.capacity = capacity;
		this.currentWeight = 0;
		this.currentValue = 0;
		this.items = new TreeSet<Item>(new Item());
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

		int capacityTemp = (this.items.size() + item.weight);

		if( capacityTemp > this.capacity )
			throw new KnapsackInsertionError();

		this.items.add(item);
		this.aggiorna(item.value, item.weight);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
		this.aggiorna(-item.value, -item.weight);
	}

	private void aggiorna(int v, int w) {
		this.currentValue += v;
		this.currentWeight += w;
	}

	public Item getBestItem() {
		return this.items.first();
	}

}
