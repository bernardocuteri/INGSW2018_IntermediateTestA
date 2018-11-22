package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnapsackTest {

	private static Knapsack knapsack;

	@BeforeClass
	public static void init()
	{
		knapsack = new Knapsack(100);
	}

	@Before
	public void reset()
	{
		knapsack.reset();
	}

	/**
	 * un metodo che verifica che lo stato (peso e valore) dello zaino si aggiorni
	 * correttamente dopo l’inserimento di 2 item
	 */
	@Test
	public void aggiornamentoDopInserimentoFunziona()
	{
		knapsack.addItem(new Item(10, 2));
		knapsack.addItem(new Item(20, 3));

		assertEquals(5, knapsack.getCurrentValue());
		assertEquals(30, knapsack.getCurrentWeight());
	}

	/**
	 * un metodo che verifica che lo stato dello zaino si aggiorni correttamente
	 * dopo l’inserimento di 3 item e la rimozione di uno di essi
	 */
	@Test
	public void aggiungoTerzoERimuovoUnoFunziona() {
		Item item = new Item(10, 2);
		Item item1 = new Item(20, 3);
		Item item2 = new Item(30, 4);
		
		knapsack.addItem(item);
		knapsack.addItem(item1);
		knapsack.addItem(item2);

		assertEquals(9, knapsack.getCurrentValue());
		assertEquals(60, knapsack.getCurrentWeight());

		knapsack.removeItem(item2);
		assertEquals(5, knapsack.getCurrentValue());
		assertEquals(30, knapsack.getCurrentWeight());
	}

	/**
	 * un metodo che verifica che verifica il sollevamento 
	 * dell’eccezione dopo lo sforamento della capacità dello zaino
	 */
	@Test(expected=KnapsackInsertionError.class)
	public void eccezioneSforamentoLanciata() {
		knapsack.addItem(new Item(1000, 1));
	}

	/**
	 * un metodo che verifica getBestItem dopo l’inserimento di 4 item
	 */
	@Test
	public void bestItemFunziona() {
		Item i = new Item(10, 2);
		Item i1 = new Item(20, 3);
		Item i2 = new Item(30, 30);
		Item i3 = new Item(40, 3);
		
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.addItem(i);
		assertEquals(i2, knapsack.getBestItem());
	}
	
	
	/**
	 * un metodo che verifica che l’inserimento nello zaino 
	 * di 1000 item istanziati in modo casuale avvenga entro 1 secondo
	 */
	@Test(timeout=1000)
	public void inserimentoInUnSecondo() {
		Knapsack knapsack = new Knapsack(1000000);
		Random random = new Random();
		for( int i = 0; i < 1000; i++ ) {
			int v = random.nextInt(10)+1;
			int w = random.nextInt(20)+1;
			knapsack.addItem(new Item(w,v));
		}
	}

}
