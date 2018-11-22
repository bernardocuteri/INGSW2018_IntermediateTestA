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
	
	public void addItem(Item item) throws KnapsackInsertionError {
		
		if((this.getCurrentWeight()+item.getWeight())<=this.getCapacity())
		{
			items.add(item);
			this.currentWeight+=item.getWeight();
			this.currentValue+=item.getValue();
			
		}
		
		else 
			
			throw new KnapsackInsertionError();
	}
	
	
	
	 public void removeItem(Item item) {
		 
		 items.remove(item);
		 this.currentValue-=item.getValue();
		 this.currentWeight-=item.getWeight();
	 }
	
	


	 public Item getBestItem() {
		 
		 double max=0;
		 Item max_item=null;
		 Iterator<Item> iterator=items.iterator();
		 
		   while (iterator.hasNext()) {
			   
			   Item i=iterator.next();
		       double actual_max=i.getValue()/i.getWeight();
		       if(actual_max>max)
		       {   
		    	   max=actual_max;
		    	   max_item=i;
		       }	
		   	}
		   return max_item;
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
