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
	
	@Test
	public void state() {
		System.out.println(String.valueOf(knapsack.getCurrentWeight()));
		Item i = new Item(30,20);
		System.out.println("elemento creato");
		knapsack.addItem(i);
		System.out.println("elementoaggiunto");
		
		assertEquals(i.getWeight(),knapsack.getCurrentWeight());
		assertEquals(i.getValue(),knapsack.getCurrentValue());
	}
	
	@Test
	public void state2() {
		Item i=new Item(10,10);
		Item g=new Item(10,10);
		Item h=new Item(10,10);
		knapsack.addItem(i);
		knapsack.addItem(g);
		knapsack.addItem(h);
		knapsack.removeItem(h);
		assertEquals(20,knapsack.getCurrentValue());
		assertEquals(20,knapsack.getCurrentWeight());
		
	}
	
	@Test (expected=KnapsackInsertionError.class)
	public void sforio() {
		Item i=new Item(1000,10);
		knapsack.addItem(i);
	}
	
	@Test
	public void bestItem() {
		Item i=new Item(1,10);
		Item g=new Item(2,10);
		Item h=new Item(3,10);
		Item l=new Item(4,10);
		knapsack.addItem(i);
		knapsack.addItem(g);
		knapsack.addItem(h);
		knapsack.addItem(l);
		assertEquals(1,knapsack.getBestItem().weight);
		assertEquals(10, knapsack.getBestItem().value);
	}
	
	@Test(timeout = 1000)
	public void rand() {
		int n=50;
		Random random = new Random();
		Knapsack k = new Knapsack(10000000);
		for(int i=0;i<1000;i++)
		{
			k.addItem(new Item(random.nextInt(n)+1,random.nextInt(n)+1));
		}
		
	}
}
