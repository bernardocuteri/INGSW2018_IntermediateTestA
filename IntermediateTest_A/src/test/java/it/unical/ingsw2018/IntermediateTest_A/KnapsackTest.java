package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import java.util.Random;

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
	
	@Test(expected=KnapsackInsertionError.class)
	public void capacityError() {
		knapsack.addItem(new Item(101,20));
	}
	
	@Test
	public void bestItemTest() {
		knapsack.addItem(new Item(5,2));
		knapsack.addItem(new Item(6,2));
		knapsack.addItem(new Item(1,2));
		knapsack.addItem(new Item(4,2));
		assertEquals(new Item(1,2) , knapsack.getBestItem());
	}
	
	@Test(timeout=1000)
	public void instertThousand() {
		Knapsack knapsack=new Knapsack(1000000);
		Random random=new Random();
		for(int i=0;i<1000;i++) {
			knapsack.addItem(new Item(random.nextInt(10)+1,random.nextInt(10)+1));
		}
	}
	
	@Test
	public void testTwoItem() {
		int currWeight=knapsack.getCurrentWeight();
		int currValue=knapsack.getCurrentValue();
		knapsack.addItem(new Item(30,30));
		knapsack.addItem(new Item(45,30));
		currWeight=currWeight+30+45;
		currValue=currValue+30+30;
		assertEquals(currWeight , knapsack.getCurrentWeight());
		assertEquals(currValue , knapsack.getCurrentValue());
	}
	
	@Test
	public void testThreeItem() {
		int currWeight=knapsack.getCurrentWeight();
		int currValue=knapsack.getCurrentValue();
		knapsack.addItem(new Item(3,3));
		knapsack.addItem(new Item(4,3));
		knapsack.addItem(new Item(5,3));
		currWeight=currWeight+3+4+5;
		currValue=currValue+3+3+3;
		assertEquals(currWeight , knapsack.getCurrentWeight());
		assertEquals(currValue , knapsack.getCurrentValue());
	}
	
}
