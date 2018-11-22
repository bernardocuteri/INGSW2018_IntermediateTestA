package it.unical.ingsw2018.IntermediateTest_A;

import org.junit.Test;

public class KnapsackExceptionsTest {

	@Test(expected=KnapsackInsertionError.class)
	public void outOfCapacityTest() {
		Knapsack knapsack = new Knapsack(0);
		Item item1 = new Item(10, 10);
		knapsack.addItem(item1);
	}
}
