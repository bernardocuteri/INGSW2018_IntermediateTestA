package it.unical.ingsw2018.IntermediateTest_A;

import java.util.Comparator;
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
		this.items = new TreeSet<>(new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return 1;
			}
		});
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
		System.out.println(items.add(item));
		currentWeight+=item.getWeight();
		currentValue+=item.getValue();
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		currentWeight-=item.getWeight();
		currentValue-=item.getValue();
	}
	
	public Item getBestItem() {
		int bestValue=0;
		Item bestItem = null;
		boolean firstTry=true;
		for(Item i : items) {
			int currentValue1 = i.getValue()/i.getWeight();
			if(firstTry) {
				firstTry=false;
				bestItem=i;
				bestValue = currentValue1;
				continue;
			}
			
			if(currentValue1>bestValue) {
				bestItem=i;
				bestValue=currentValue1;
			}
		}
		return bestItem;
		//Per restituire l'elemento migliore in tempo costante basterebbe verificare 
		//a tempo di inserimento il rapporto dell'elemento da inserire e tenere come radice dell'albero
		//sempre l'elemento migliore, ma non c'è tempo di studiare la classe treeset
	}
    
}
