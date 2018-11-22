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
		if((this.getCurrentWeight()+item.getWeight())>this.getCapacity())
			throw new KnapsackInsertionError();
		
		items.add(item);
		currentWeight+=item.getWeight();
		currentValue+=item.getValue();
		
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		currentWeight-=item.getWeight();
		currentValue-=item.getValue();
	}
	
	public Item getBestItem() {
		
		Iterator<Item> itr=items.iterator();
		Item tmp=null;
		float max=0;
		float rapporto;
		
		while(itr.hasNext()) {
			Item tmp2=itr.next();
			rapporto=tmp2.getValue()/tmp2.getWeight();
			
			if(rapporto>max)
				tmp=tmp2;
		
		}
		
		return tmp;
	}
	
    
}
