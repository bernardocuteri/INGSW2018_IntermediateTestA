package it.unical.ingsw2018.IntermediateTest_A;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class KnapsackTest {

	private static Knapsack knapsack;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void init() {
		knapsack = new Knapsack(100);
	}

	@Before
	public void reset() {
		knapsack.reset();
	}

	//test in cui si verifica l'aggiornamento dello stato dello zaino dopo 2 oggetti inseriti
	@Test
	public void testStatus() {
		Item one = new Item(20,10);
		Item two = new Item(30,20);
		knapsack.addItem(one);
		knapsack.addItem(two);
		System.out.println(knapsack.getCurrentWeight());
		Assert.assertEquals(50, knapsack.getCurrentWeight());
		Assert.assertEquals(30, knapsack.getCurrentValue());
	}

	//test in cui si verifica che dopo aver inserito 3 item e rimosso uno lo status dello zaino sia corretto
	@Test
	public void testStatusAndRemove() {
		Item one = new Item(20,10);
		Item two = new Item(30,20);
		Item three = new Item(10,10);
		knapsack.addItem(one);
		knapsack.addItem(two);
		knapsack.addItem(three);
		knapsack.removeItem(three);
		Assert.assertEquals(50, knapsack.getCurrentWeight());
		Assert.assertEquals(30, knapsack.getCurrentValue());
	}

	//test in cui verifico il sollevamento dell'exception se supero il peso massimo
	@Test
	public void checkExceptionCapacity() {
		Item one = new Item(20,10);
		Item two = new Item(100,100);
		knapsack.addItem(one);
		knapsack.addItem(two);
		thrown.expectMessage("inserimento non consentito, peso massimo superato");
	}

	//TEST che verifica che il best item sia quello giusto dopo averne inseriti diversi
	@Test
	public void checkBestItem() {
		Item one = new Item(5,20);
		Item two = new Item(4,20);
		Item three = new Item(3,20);
		Item four = new Item(2,20);
		knapsack.addItem(one);
		knapsack.addItem(two);
		knapsack.addItem(three);
		knapsack.addItem(four);
		Assert.assertEquals(2,knapsack.getBestItem().getValue());
		Assert.assertEquals(20,knapsack.getBestItem().getWeight() );
	}

	//test che verifica che l’inserimento nello zaino di 1000 item istanziati in modo casuale avvenga entro 1 secondo
	@Test
	public void checkmille() {
		long startTime = System.nanoTime();
		for(i<0;i<1000;i++) {
			//inserisco i 1000 elementi casuali
		}
		long endTime = System.nanoTime();
		
		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		//verifico con  l'assert che duration sia minore di 1 secondo
	}

}
