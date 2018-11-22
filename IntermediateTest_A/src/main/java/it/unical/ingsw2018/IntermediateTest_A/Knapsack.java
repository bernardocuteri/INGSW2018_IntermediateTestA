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
		if(currentWeight+item.getWeight()>=capacity)
		{
			System.out.println("ciao");
			throw new KnapsackInsertionError();
			
		}
		
		
		else {
			System.out.println("else");
			items.add(item);
			System.out.println("aggiunto");
				
				
			currentValue+=item.getValue();
			currentWeight+=item.getWeight();
		}
			
		
	}
	
	public void removeItem(Item e) {
		items.remove(e);
		currentValue-=e.getValue();
		currentWeight-=e.getWeight();
	}
	
	public Item getBestItem() {
		
		Item e=null;
		int max =0;
		for(Item i:items)
		{
			if(i.getValue()/i.getWeight()>max)
			{
				max=i.getValue()/i.getWeight();
				e=i;
			}
		}
		return e;
	}
    
}
