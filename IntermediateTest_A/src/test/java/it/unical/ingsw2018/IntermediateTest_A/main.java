package it.unical.ingsw2018.IntermediateTest_A;
import it.unical.ingsw2018.IntermediateTest_A.Knapsack;
public class main {

	public static void main(String[] args) {
		Item item1 = new Item(1, 1);
		Item item2 = new Item(2, 1);
		Item item3 = new Item(200, 1);
		
		Knapsack knapsack = new Knapsack(100);
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		System.out.println(knapsack.getCurrentWeight());



	}

}
