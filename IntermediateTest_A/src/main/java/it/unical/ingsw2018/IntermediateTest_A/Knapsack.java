package it.unical.ingsw2018.IntermediateTest_A;

import java.util.TreeSet;

public class Knapsack 
{

	private int capacity;

	private TreeSet<Item> items;

	private int currentWeight;

	private int currentValue;

	public void addItem(Item item) {
		int pesoItem=item.getWeight();
		int pesoObiettivo =currentWeight+pesoItem;
		if(pesoObiettivo <=capacity ) {
            items.add(item);
			currentWeight =currentWeight+ item.getWeight();
			currentValue = currentValue + item.getValue();
		}
		else throw new RuntimeException("inserimento non consentito, peso massimo superato");

	}

	public void removeItem(Item item) {
		items.remove(item);
		currentWeight =currentWeight- item.getWeight();
		currentValue = currentValue - item.getValue();
	}

	public Item getBestItem() {
		int max=-1;
		Item bestItem=null;
		for(Item i : items) {
			if(i.getValue()/i.getWeight()>max) {
				max = (i.getValue()/i.getWeight());
				bestItem =i;
			}
		}
		return bestItem;
	}

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

}
