package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import java.util.Random;




public class KnapsackTest {
	
	private static Knapsack k;
	
	@BeforeClass
	public static void init() {
		k = new Knapsack(100);
	}
	
	@Before
	public void reset() {
		k.reset();
	}
	
	
	@Test
	public void verifyAfterTwoInsertions()
	{
		k.addItem(new Item(1, 2));
		k.addItem(new Item(3, 2));
		
		assertEquals(4, k.getCurrentWeight());
		assertEquals(4, k.getCurrentValue());
	}
	
	
	@Test
	public void verifyAfterThreeInsertions()
	{
		k.addItem(new Item(1, 2));
		k.addItem(new Item(3, 2));
		
		Item toRemove = new Item(3, 2);
		k.addItem(toRemove);
		k.removeItem(toRemove);
		
		assertEquals(4, k.getCurrentWeight());
		assertEquals(4, k.getCurrentValue());
	}
	
	@Test(expected = KnapsackInsertionError.class)
	public void verifyOverflow()
	{
		k.addItem(new Item(1, 2));
		k.addItem(new Item(3, 2));
		k.addItem(new Item(200, 2));
	}
	
	@Test
	public void verifyBestItem()
	{
		k.addItem(new Item(1, 2));
		k.addItem(new Item(2, 2));
		Item toReturn = new Item(1, 4);
		k.addItem(toReturn);
		k.addItem(new Item(2, 1));
		assertEquals(toReturn, k.getBestItem());
	}
	
	@Test (timeout = 1000)
	public void verifyInsertionOf1000Items(){
		
		Knapsack kn = new Knapsack(1000000000);
		Random rand = new Random();
		for (int i = 0; i < 1000; i++)
		{
			kn.addItem(new Item(rand.nextInt(10) + 1, rand.nextInt(10) + 1));
		}
			
	}

}
