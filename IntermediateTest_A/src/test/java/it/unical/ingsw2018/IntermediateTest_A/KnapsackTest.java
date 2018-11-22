package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnapsackTest {
	
	private static double epsilon = 0.0001; 
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
	// PUNTO 1
	public void twoInsertTest() {
		Item arachidi = new Item(10, 10);
		Item noci = new Item(10, 20); 
		try {
			knapsack.addItem(arachidi);
			knapsack.addItem(noci);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(20, knapsack.getCurrentWeight(), epsilon);
		assertEquals(30, knapsack.getCurrentValue(), epsilon);
	}
	
	@Test
	// PUNTO 2
	public void updateKnapsackTest() {
		Item arachidi = new Item(10, 10);
		Item noci = new Item(10, 20);
		Item nocciole = new Item(10, 30);
		
		
		try {
			knapsack.addItem(arachidi);
			knapsack.addItem(nocciole);			
			knapsack.addItem(noci);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(30, knapsack.getCurrentWeight(), epsilon);
		assertEquals(60, knapsack.getCurrentValue(), epsilon);
		
		knapsack.removeItem(nocciole);
		
		assertEquals(20, knapsack.getCurrentWeight(), epsilon);
		assertEquals(30, knapsack.getCurrentValue(), epsilon);
	}
	
	@Test(expected=Exception.class)
	// PUNTO 3
	public void maxCapacityExceededTest() throws Exception {
		Item arachidi = new Item(101, 1);
		knapsack.addItem(arachidi);
	}
	
	@Test
	// PUNTO 4
	public void bestItemTest() {
		Item arachidi = new Item(1, 1);
		Item nocciole = new Item(1, 2);
		Item pistacchi = new Item(1, 3);
		Item noci = new Item(1, 4);
		
		try {
			knapsack.addItem(arachidi);
			knapsack.addItem(nocciole);			
			knapsack.addItem(noci);
			knapsack.addItem(pistacchi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(noci, knapsack.getBestItem());
	}
	
	@Test(timeout=1000)
	// PUNTO 5
	public void performanceTest() {
		Knapsack big_knapsack = new Knapsack(1000);
		try {
			for (int i = 0; i < 1000; ++i) {
				// Peso fisso per assicurarmi ci entrino tutti
				big_knapsack.addItem(new Item(1, (int) Math.random()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
