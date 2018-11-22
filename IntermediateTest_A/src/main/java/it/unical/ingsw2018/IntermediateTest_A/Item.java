package it.unical.ingsw2018.IntermediateTest_A;

public class Item implements Comparable  {

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
	public int compareTo(Object o) {
		
		if(!(o instanceof Item))
			return -1;
		
		Item other = (Item) o;
		if (value != other.value)
			return -1;
		if (weight != other.weight)
			return 1;
		return 0;
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
	
	
}
