package palindrome;


import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Class PalindromeTest demonstrates JUnit Test or string palindrome  
 * @version 1.01 14.03.2017
 * @author Yury Kovalchuk
 */
public class PalindromeTest  extends TestCase
{

    /**
     * Get JUnit test from command line 
     */
    public static void main(String[] args) throws Exception 
    {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(PalindromeTest.class);
        System.out.println("Run tests: " + result.getRunCount());
        System.out.println("Failed tests: " + result.getFailureCount());
        System.out.println("Ignored tests: " + result.getIgnoreCount());
        System.out.println("Success: " + result.wasSuccessful());
    }
    
	/**
	 * Method testing successful or string palindrome   
     */
	@Test
	public void testIsPalindromePass() 
	{
		assertTrue("string palindrome",Palindrome.isPalindrome(""));
		assertTrue("string palindrome",Palindrome.isPalindrome("raar"));
		assertTrue("string palindrome",Palindrome.isPalindrome("1221"));
		assertTrue("string palindrome",Palindrome.isPalindrome("Арбуз ел еж, а желе — зубр, а?"));
		assertTrue("string palindrome",Palindrome.isPalindrome("Арба да карбас — атас абракадабра!"));
		assertTrue("string palindrome",Palindrome.isPalindrome("Али Баба — раз араба бил, а?"));
		assertTrue("string palindrome",Palindrome.isPalindrome("Уж я веники не вяжу."));
		assertTrue("string palindrome",Palindrome.isPalindrome("Аргентина манит негра."));
	}

	/**
	 * Method testing failure or string palindrome   
     */
	@Test
	public void testIsPalindromeFail() 
	{
		assertFalse("string not palindrome",Palindrome.isPalindrome(null));
		assertFalse("string not palindrome",Palindrome.isPalindrome("rara"));
		assertFalse("string not palindrome",Palindrome.isPalindrome("1222"));
		assertFalse("string not palindrome",Palindrome.isPalindrome("Теша поле, муж умело пошет."));
		assertFalse("string not palindrome",Palindrome.isPalindrome("Актер у бати — табулетка."));
		assertFalse("string not palindrome",Palindrome.isPalindrome("И городу дорог огород у дароги."));
		assertFalse("string not palindrome",Palindrome.isPalindrome("Тела, бедро, кардебалет."));
	}
}
