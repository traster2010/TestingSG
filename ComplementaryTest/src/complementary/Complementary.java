package complementary;

import java.util.ArrayList;

import javafx.util.Pair;

/**
 * The Complementary class provides methods for
 *  get K-complementary pairs.
 * @version 1.01 15.03.2017
 * @author Yury Kovalchuk
 */
public class Complementary {

	public Complementary() { }
	
	/**
	 * Get K-complementary pairs from input integer array   
	 * @param integerArray input integer array 
	 * @param k compared value   
	 * @return complementary pairs of sequences
	 */
	public static ArrayList<Pair<Integer,Integer>> getComplementaryPairs(int integerArray[], int k) 
	{
		//initialization list of K-complementary pairs
		ArrayList<Pair<Integer,Integer>> pairs = new ArrayList<Pair<Integer,Integer>>();

		//get list of K-complementary pairs
		for (int i = 0; i < integerArray.length; i++) 
		{
            for (int j = 0; j < integerArray.length; j++) 
            {
                if (integerArray[i] + integerArray[j] == k) 
                {
            		//filling list of K-complementary pairs
                	pairs.add(new Pair<Integer,Integer>(i,j));
                }
            }
        }

		//return K-complementary pairs of sequences
		return pairs;
	}
}
