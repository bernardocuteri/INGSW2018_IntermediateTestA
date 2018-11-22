package it.unical.ingsw2018.IntermediateTest_A;

import java.util.Comparator;

public class Item {

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
//	private Comparator<int> comparatore = new Comparator <Item>() {
//		@Override
//		public int compare(Item a, Item b) {
//			if(a.getWeight() == b.getWeight() && a.getValue() ==b.getValue())
//				return -1;
//			
//			return 1;
//		}
//	};
	
	public int compareTo(Item i) {
		
		if(weight-i.weight==0 && value -i.value==0) {
			return 0;
		}
		return 1;
		
	}


}
