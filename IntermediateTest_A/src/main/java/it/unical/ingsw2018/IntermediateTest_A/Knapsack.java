package it.unical.ingsw2018.IntermediateTest_A;

import java.util.Iterator;
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
		if(items.size()+1 > capacity)
		{
	        throw new IllegalStateException("queue full");
		}
		else
		{
			items.add(item);
			currentWeight = currentWeight + item.getWeight();
			currentValue = currentValue + item.getValue();
		}
		
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		currentWeight = currentWeight - item.getWeight();
		currentValue = currentValue - item.getValue();
		
	}
	
	public Item getBestItem() {
		Item I = null;
		Iterator<Item> itr = items.iterator();
		while(itr.hasNext()) {
			if(I == null)
				I=itr.next();
			else if((itr.next().getValue()/itr.next().getWeight()) >= (I.getValue()/I.getWeight()))
					I = itr.next();
		}
		return I;
		
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
