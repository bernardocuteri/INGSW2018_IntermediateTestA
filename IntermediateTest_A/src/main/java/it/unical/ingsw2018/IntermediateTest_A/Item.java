package it.unical.ingsw2018.IntermediateTest_A;

public class Item implements Comparable{

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
	public int compareTo(Object i) {
		if( this.value == ((Item) i).getValue() && this.weight == ((Item) i).getWeight())
		return 0;
		else return 1;
	}

	
	
	
	
	
}
