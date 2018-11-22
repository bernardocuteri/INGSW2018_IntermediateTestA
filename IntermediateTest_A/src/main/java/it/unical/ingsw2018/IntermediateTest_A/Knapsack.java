package it.unical.ingsw2018.IntermediateTest_A;

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
		if (currentWeight + item.getWeight() > capacity) {
			throw new KnapsackInsertionError();
		} else {

			this.currentValue = item.getValue();
			this.currentWeight += item.getWeight();
			items.add(item);
		}
	}

	public void removeItem(Item item) {
		items.remove(item);
		this.currentWeight -= item.getWeight();
		this.currentValue = items.last().getValue();
	}

	public Item getBestItem() {
		int rapporto = 0;
		Item item = null;
		int max = 0;
		for (Item it : items) {
			rapporto = it.getValue() / it.getWeight();
			if (rapporto > max) {
				max = rapporto;
				item = new Item(it.getValue(), it.getWeight());
			}
		}
		return item;

	}

}
