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
	
	public void addItem(Item item)
	{
		if (item.getWeight() + currentWeight <= capacity)
		{
			items.add(item);
			currentValue += item.getValue();
			currentWeight += item.getWeight();
		}
		else
		{
			throw new KnapsackInsertionError();
		}
	}
	
	public void removeItem(Item item)
	{
		currentValue -= item.getValue();
		currentWeight -= item.getWeight();
		items.remove(item);
	}
    
	
	public Item getBestItem()
	{
		double max = 0.0;
		for(Item it: items)
		{
			double current = it.getValue() / it.getWeight();
			if(current >= max)
			{
				max = current;
			}
		}
		
		for (Item it: items)
		{
			if (it.getValue() / it.getWeight() == max)
				return it;
		}
		return null;
	}
}
