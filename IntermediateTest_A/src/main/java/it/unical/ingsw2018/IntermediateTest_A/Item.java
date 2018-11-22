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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (value != other.value)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public int compareTo(Item o) {
		
		return Integer.compare(this.value, o.getValue());
	}
	
	
	
}
