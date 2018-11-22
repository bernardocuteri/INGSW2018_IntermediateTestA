package it.unical.ingsw2018.IntermediateTest_A;

import java.util.EmptyStackException;
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
    
	public void addItem(Item item)
	{
		if((item.getWeight() + getCurrentWeight()) < capacity)
		{
			items.add(item);
			currentWeight += item.getWeight();
			currentValue += item.getValue();
		}
		else
		{
			throw new EmptyStackException();
		}
	}
	
	public void removeItem(Item item)
	{
		int weight = item.getWeight();
		int value = item.getValue();
		items.remove(item);
		currentWeight = getCurrentWeight() - weight;
		currentValue = getCurrentValue() - value;
	}
	
	public Item getBestItem()
	{
		int report = 0;
		int max = 0;
		Item item = null;

		for(Item it : items)
		{
			report = it.getValue()/it.getWeight();
			
			if(report > max)
			{
				max = report;
				item = it;
			}
		}
		
		return item;
	}
}
