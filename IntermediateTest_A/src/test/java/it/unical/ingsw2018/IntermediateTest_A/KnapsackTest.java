package it.unical.ingsw2018.IntermediateTest_A;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	@Test
	public void WeigthTest() {
		Item item1 = new Item(10, 10);
		Item item2 = new Item(20, 20);
		int valoreAttesoWeigth = knapsack.getCurrentWeight() + item1.getWeight() + item2.getWeight();
		int valoreAttesoValue = knapsack.getCurrentValue() + item1.getValue() + item2.getValue();
		knapsack.addItem(item1); knapsack.addItem(item2);
		Assert.assertEquals(valoreAttesoWeigth, knapsack.getCurrentWeight());
		Assert.assertEquals(valoreAttesoValue, knapsack.getCurrentValue());
	}
	
	@Test
	public void WeigthTest2() {
		Item item1 = new Item(10, 10);
		Item item2 = new Item(20, 20);
		Item item3 = new Item(30, 30);
		int valoreAttesoWeigth = knapsack.getCurrentWeight() + item1.getWeight() + item2.getWeight();
		int valoreAttesoValue = knapsack.getCurrentValue() + item1.getValue() + item2.getValue();
		knapsack.addItem(item1); knapsack.addItem(item2); knapsack.addItem(item3); knapsack.removeItem(item3);
		Assert.assertEquals(valoreAttesoWeigth, knapsack.getCurrentWeight());
		Assert.assertEquals(valoreAttesoValue, knapsack.getCurrentValue());
	}
	
	@Test(expected=KnapsackInsertionError.class)
	public void ExceptionTest() {
		Item item = new Item(100000, 100000);
		knapsack.addItem(item);
	}
	
	@Test
	public void bestItemTest() {
		Item item1 = new Item(1, 10);
		Item item2 = new Item(2, 10);
		Item item3 = new Item(3, 10);
		Item item4 = new Item(40, 1);
		knapsack.addItem(item1); knapsack.addItem(item2); knapsack.addItem(item3); knapsack.addItem(item4);
		Assert.assertEquals(item4, knapsack.getBestItem());
	}
	
	@Test(timeout=1000)
	public void timeTest() {
		Knapsack k1 = new Knapsack(10000);
		for (int i = 0; i < 1000; i++) {
			int randomValue = (new Random()).nextInt(10) + 1;
			int randomWeigth = (new Random()).nextInt(10) + 1;
			k1.addItem(new Item(randomValue, randomWeigth));
		}
	}
}
