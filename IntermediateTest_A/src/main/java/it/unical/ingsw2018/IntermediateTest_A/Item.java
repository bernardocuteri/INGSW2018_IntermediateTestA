package it.unical.ingsw2018.IntermediateTest_A;

public class Item implements Comparable {

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

	public int getRapporto() {
		return value/weight;
	}
	
	@Override
	public int compareTo(Object o) {
		
		return 0;
	}
	
	
}
