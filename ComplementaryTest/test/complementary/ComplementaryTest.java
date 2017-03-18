package complementary;

import javafx.util.Pair;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Class ComplementaryTest demonstrates JUnit test 
 * functionality methods of Complementary class
 * @version 1.01 15.03.2017
 * @author Yury Kovalchuk
 */
public class ComplementaryTest extends TestCase
{

    /**
     * Get JUnit test from command line 
     */
	public static void main(String[] args) throws Exception 
	{
		JUnitCore runner = new JUnitCore();
		Result result = runner.run(ComplementaryTest.class);
		System.out.println("Run tests: " + result.getRunCount());
		System.out.println("Failed tests: " + result.getFailureCount());
		System.out.println("Ignored tests: " + result.getIgnoreCount());
		System.out.println("Success: " + result.wasSuccessful());
	}

	/**
	 * Method testing successful get K-complementary pairs for input integer array   
	 */
	@Test
	public void testGetComplementaryPairsPass() 
	{
		// set testing values
		int[] intArray = new int[] { 1, 8, -3, 0, 1, 3, -2, 4, 5};
		int k = 6;
		
		System.out.println("K-complementary pairs :");
		
		// show K-complementary pairs
		for (Pair<Integer,Integer> pair : Complementary.getComplementaryPairs(intArray, k))
		{
			System.out.println("i - " + pair.getKey() + ",j - " + pair.getValue());
		}
		System.out.println("Total  pairs : " + Complementary.getComplementaryPairs(intArray, k).size());
		System.out.println();
		
		assertEquals("successful get K-complementary pairs", 7, 
				Complementary.getComplementaryPairs(intArray, k).size());
	}

	/**
	 * Method testing failure get K-complementary pairs for input integer array
	 */
	@Test
	public void testGetComplementaryPairsFail() 
	{
		// set testing values
		int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int k = 1;
		
		assertEquals("Not exist K-complementary pairs", 0, 
				Complementary.getComplementaryPairs(intArray, k).size());
	}
}
