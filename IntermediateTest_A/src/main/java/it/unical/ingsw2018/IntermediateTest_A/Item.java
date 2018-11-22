package it.unical.ingsw2018.IntermediateTest_A;

import java.util.Comparator;

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
	public int compareTo(Item o) {
		if(this.weight<o.weight)
		return -1;
		else if(this.weight==o.weight)
			return 0;
		
		return 1;
		
	}


	
	
}
