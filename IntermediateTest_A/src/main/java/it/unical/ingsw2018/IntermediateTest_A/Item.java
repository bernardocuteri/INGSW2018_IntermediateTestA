package it.unical.ingsw2018.IntermediateTest_A;

import java.util.Comparator;

public class Item  implements Comparator<Item>{

	int weight;
	int value;
	
	public Item() {
		
	}
	
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
	public int compare(Item o1, Item o2)
	{
		int v1 = o1.value/o1.weight;
		int v2 = o2.value/o2.weight;
		return (v1 <= v2) ? -1 : 1;
	}
	
	
}
