package it.unical.ingsw2018.IntermediateTest_A;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Before;
import org.junit.BeforeClass;

import it.unical.ingsw2018.MavenSecondTestIngsw.InvalidPlayException;

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
	public void test1() {
		Item i1 = new Item(5,6);
		Item i2 = new Item(5,6);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		Assert.assertEquals(10, knapsack.getCurrentWeight());
		Assert.assertEquals(12, knapsack.getCurrentValue());
	}
	
	@Test
	public void test2() {
		Item i1 = new Item(5,6);
		Item i2 = new Item(5,6);
		Item i3 = new Item(5,6);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		Assert.assertEquals(15, knapsack.getCurrentWeight());
		Assert.assertEquals(18, knapsack.getCurrentValue());
		knapsack.removeItem(i2);
		Assert.assertEquals(10, knapsack.getCurrentWeight());
		Assert.assertEquals(12, knapsack.getCurrentValue());
	}
	
	@Test(expected=KnapsackInsertionError.class)
	public void test3() {
		Item i1 = new Item(102,6);
		knapsack.addItem(i1);
		
	}
	
	@Test
	public void test4() {
		Item i1 = new Item(10,4);
		Item i2 = new Item(10,2);
		Item i3 = new Item(10,4);
		Item i4 = new Item(10,4);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.addItem(i4);
		Assert.assertEquals(i2, knapsack.getBestItem());
		
	}
	
	@Test( timeout = 1000)
	public void test6() {
		Knapsack kn = new Knapsack(100000);
		Item tmp= new Item(2, 5);
		for (int i = 0; i < 1000; i++) {
			kn.addItem(tmp);
		}
	}
}
