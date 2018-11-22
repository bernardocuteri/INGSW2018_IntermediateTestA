package it.unical.ingsw2018.IntermediateTest_A;

public class Item implements Comparable<Item> {

	int weight;
	int value;
	double rapporto;
	
	public Item(int weight, int value) {
		super();
		this.weight = weight;
		this.value = value;
		this.rapporto = this.value / this.weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Item i) {
		if (this.rapporto < i.getRapporto())
			return 0;
		return 1;
	}
	
	public double getRapporto() {
		return rapporto;
	}

}
