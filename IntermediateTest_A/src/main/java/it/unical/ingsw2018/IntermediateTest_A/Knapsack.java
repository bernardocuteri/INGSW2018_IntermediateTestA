package it.unical.ingsw2018.IntermediateTest_A;
import org.junit.*;

import junit.framework.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class Knapsack 
{
	//peso massimo dello zaino
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

	
	public void addItem(Item i) {
		if (this.currentWeight + i.getWeight() > this.capacity )
			throw new KnapsackInsertionError();
		this.items.add(i);
		this.currentWeight += i.getWeight();
		this.currentValue += i.getValue();
	}
	
	public void removeItem(Item i) {
		this.items.remove(i);
		this.currentValue -= i.getValue();
		this.currentWeight -= i.getWeight();
	}
	
	public Item getBestItem() {
		
		float max = 0;
		Item massimo = new Item(0,0);
		Iterator<Item> itr = this.items.iterator();
		
		while(itr.hasNext()) {
			Item i = itr.next();
			if (i.getValue() / i.getWeight() > max ) {
				max = i.getValue() / i.getWeight();
				massimo = i;
			}
		}
		return massimo;
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
