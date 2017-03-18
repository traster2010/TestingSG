package mostRepeatPhrasesFile;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


/**
 * Class MostRepeatPhrasesFileTest demonstrates JUnit test 
 * functionality methods of MostRepeatPhrasesFile class
 * @version 1.01 16.03.2017
 * @author Yury Kovalchuk
 */
public class MostRepeatPhrasesFileTest extends TestCase
{
	MostRepeatPhrasesFile mostRepPhrases = new MostRepeatPhrasesFile();
	String fileName;
	int filePhrasesInRow, maxMostRepeatPhrases;


    /**
     * Get JUnit test from command line 
     */
	public static void main(String[] args) throws Exception 
	{
		JUnitCore runner = new JUnitCore();
		Result result = runner.run(MostRepeatPhrasesFileTest.class);
		System.out.println("Run tests: " + result.getRunCount());
		System.out.println("Failed tests: " + result.getFailureCount());
		System.out.println("Ignored tests: " + result.getIgnoreCount());
		System.out.println("Success: " + result.wasSuccessful());
	}

  
	@Before
	public void setUp() throws Exception 
	{
		// set name file of phrases (put file with phrases this location)  
		fileName = "C:\\TestFile.txt";
		// set count phrases in row of file 
		filePhrasesInRow = 50;
		// set max count most repeat phrases for return
		maxMostRepeatPhrases =100000;
	}

	/**
	 * Method testing successful get most repeat phrases in file   
	 */
	@Test
	public void testGetMostRepeatPhrases()
	{
		// get list max most repeat phrases
		List<String> mostRepPhrasesList = mostRepPhrases.getMostRepeatPhrases(fileName,filePhrasesInRow,maxMostRepeatPhrases);
		
		System.out.println("List "+maxMostRepeatPhrases+" most repeat phases in file: ");
		
		// print list max most repeat phrases
		for(String phrases : mostRepPhrasesList) 
		{
			System.out.println("- "+phrases);
		}
		System.out.println();

		// verify list max most repeat phrases
		assertNotEquals("Got filled list", 0,mostRepPhrasesList.size());
		
	}
}
