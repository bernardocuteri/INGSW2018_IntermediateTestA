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
	
	public int getRapporto() {
		return (value/weight);
	}

	@Override
	public int compareTo(Item item) {
		if(this.getRapporto() >= item.getRapporto())
			return this.getRapporto();
		else
			return item.getRapporto();
	}
	
}
