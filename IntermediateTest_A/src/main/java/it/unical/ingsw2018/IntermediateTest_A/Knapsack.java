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
		if ((this.currentValue += item.getValue()) > this.capacity)
			throw new KnapsackInsertionError();
		this.items.add(item);
		this.currentWeight += item.getWeight();
	}

	public void removeItem(Item item) {
		this.items.remove(item);
		this.currentValue -= item.getValue();
		this.currentWeight -= item.getWeight();
	}

	public Item getBestItem() {
		Item tmp = null;
		int max = 0;
		for (Item i : items)
			if (i.getValue() / i.getWeight() > max)
				tmp = i;
		return tmp;
	}
}
