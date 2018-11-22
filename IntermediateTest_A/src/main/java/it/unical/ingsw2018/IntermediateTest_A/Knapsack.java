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
		this.items = new TreeSet<Item>();
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
		if(currentWeight+item.getWeight()>capacity)
			throw new KnapsackInsertionError();
		else {
			items.add(item);
			currentValue=currentValue+item.getValue();
			currentWeight=currentWeight+item.getWeight();
		}
	}
	
	public void removeItem(Item item) {
		if(items.remove(item))
		{
			currentValue=currentValue-item.getValue();
			currentWeight=currentWeight-item.getWeight();
		}
	}
    
	public Item getBestItem() {
		int max=0;
		Item i=null;
		for (Item item : items) {
			int temp=item.getValue()/item.getWeight();
			if(temp>max)
			{
				i=item;
				max=temp;
			}
		}
		
		return i;
	}
}
