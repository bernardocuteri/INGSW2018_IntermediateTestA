package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

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
	
	//verifico l'update dopo due items
	@Test
	public void update() {
		int currentPeso = knapsack.getCurrentWeight();
		int currentValore = knapsack.getCurrentValue();
		
		knapsack.addItem(new Item(8,6));
		knapsack.addItem(new Item(10,2));
		
		currentPeso += 18;
		currentValore += 8;
		assertEquals(currentPeso, knapsack.getCurrentWeight());
		assertEquals(currentValore, knapsack.getCurrentValue());
	}
	
	//verifico update dopo aggiunta di 3 elementi e rimozione di 1
	@Test
	public void update2() {
		int currentPeso = knapsack.getCurrentWeight();
		int currentValore = knapsack.getCurrentValue();
		
		Item i = new Item(10,10);
		knapsack.addItem(new Item(8,6));
		knapsack.addItem(new Item(10,2));
		knapsack.addItem(i);
		
		//rimuovo l'elemento
		knapsack.removeItem(i);
		
		currentPeso += 18;
		currentValore += 8;
		
		assertEquals(currentPeso, knapsack.getCurrentWeight());
		assertEquals(currentValore, knapsack.getCurrentValue());
	}
	
	//mi aspetto un'eccezione se sforo la capacity
	@Test(expected = KnapsackInsertionError.class)
	public void sforaCapacity() {
		knapsack.addItem(new Item(1000,10));
	}
	
	//BestItem dopo 4 items
	@Test
	public void bestItem() {
		Item i = new Item(10,10); //dovrebbe essere il best
		Item i2 = new Item(20,10);
		Item i3 = new Item(30,10);
		Item i4 = new Item(40,10); 
		knapsack.addItem(i);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.addItem(i4);
		
		assertEquals(i, knapsack.getBestItem());
	}
	
	//un metodo che verifica che l’inserimento nello zaino 
	//di 1000 item istanziati in modo casuale avvenga entro 1 secondo
	@Test(timeout = 1000)
	public void fastInsert() {
		Knapsack zaino = new Knapsack(1000000);
		for(int i = 0; i < 1000; i++) {
			int peso = (int) (Math.random()*10);
			int valore = (int) (Math.random()*5);
			zaino.addItem(new Item(peso,valore));
		}
	}
}
