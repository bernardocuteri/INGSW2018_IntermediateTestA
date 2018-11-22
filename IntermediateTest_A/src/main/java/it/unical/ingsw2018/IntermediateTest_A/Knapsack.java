package it.unical.ingsw2018.IntermediateTest_A;

import java.util.Iterator;
import java.util.TreeSet;

public class Knapsack {
  
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
		//try {
			if(item.getWeight() + this.currentWeight <= this.capacity) {
				items.add(item);
				this.currentValue += item.getValue();
				this.currentWeight += item.getWeight();
			}
			System.out.println("current weight: " + this.getCurrentWeight());
			System.out.println("Current value: " + this.getCurrentValue());
			
		/*} catch(Exception e) {
			System.out.println(e);
			System.out.println("Impossibile aggiungere un item allo zaino");
		}*/
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public Item getBestItem() {
		Item bestItem = new Item(0,0);
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			if((double)(it.next().getValue()/it.next().getWeight()) > (double)(bestItem.getValue()/bestItem.getWeight())) {
				bestItem = it.next();
			}
		}
		return bestItem;
	}
    
}
