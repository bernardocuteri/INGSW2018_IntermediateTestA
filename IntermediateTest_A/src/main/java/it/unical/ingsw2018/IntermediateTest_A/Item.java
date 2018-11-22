package it.unical.ingsw2018.IntermediateTest_A;

public class Item implements Comparable<Item>{

	int weight;
	int value;
	
	public Item(int weight, int value) {
		super();
		this.weight = weight;
		this.value = value;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Item arg0) {
		return Integer.compare(this.value, arg0.value) + Integer.compare(this.weight, arg0.weight);
	}
	
		
}

