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
	
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int CompareTo(Item it) {
		if(value/weight - it.value/it.weight ==0)
			return 0;
		else if (value/weight - it.value/it.weight>0)
			return 1;
		return -1;
	}
	
	public boolean equals(Object o) {
		Item it=(Item) o ;
		return this.value==it.value && this.weight==it.weight;
	}
	
	
}
