package it.unical.ingsw2018.IntermediateTest_A;

import org.junit.Before;
import org.junit.BeforeClass;

public class KnapsackTest {
	
	private static Knapsack knapsack;
	
	@BeforeClass
	public static void init() {
		knapsack = new Knapsack(100);
	}
	
	@Before
	public void reset() {
		knapsack.reset();
	}
}
