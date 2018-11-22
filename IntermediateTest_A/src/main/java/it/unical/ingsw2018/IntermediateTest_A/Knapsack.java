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
		items.add(item);
		currentValue+=item.getValue();
		currentWeight+=item.getWeight();
		if(currentWeight>capacity) {
			throw new KnapsackInsertionError();			
		}
	}
	public void removeItem(Item item) {
		items.remove(item);
		currentValue-=item.getValue();
		currentWeight-=item.getWeight();
	}
	
	public Item getBestItem() {
		int max=0;
		Item item=new Item(0,0);
		Iterator<Item> itr=items.iterator();
		while(itr.hasNext()) {
			int j=(itr.next().getValue())/(itr.next().getWeight());
			if(j>max) {
				max=j;
				item=itr.next();
			}
		}
		return item;
	}
    
}
