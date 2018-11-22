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
	public int compareTo(Object arg0) {
		if(arg0 instanceof Item) {
			Item temp = (Item)arg0;
			if( this.value/this.weight > temp.value/temp.weight) {
				return -1;
			}
			else if( this.value/this.weight == temp.value/temp.weight) {
				return -1;
			}
		}
		return 1;
	}
	
	
}
