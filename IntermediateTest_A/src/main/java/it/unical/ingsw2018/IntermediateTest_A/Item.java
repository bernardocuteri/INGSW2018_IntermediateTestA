package it.unical.ingsw2018.IntermediateTest_A;

public class Item implements Comparable<Item> {

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
	// Voglio che il best item sia accessibile come primo elemento del TreeSet
	public int compareTo(Item o) {
		double my_ratio = (double) value / (double) weight;
		double his_ratio = (double) o.value / (double) o.weight; 
		if (my_ratio > his_ratio) {
			// TreeSet mette l'elemento più piccolo in cima
			return -1;	
		} else if (my_ratio == his_ratio) {
			return 0;
		} else {
			return 1; 
		}
	}
	
	
}
