package palindrome;

/**
 * The Palindrome class provides static methods for
 *  verify string or string palindrome.
 * @version 1.01 14.03.2017
 * @author Yury Kovalchuk
 */
public class Palindrome {
	
	public Palindrome() { }

   /**
    * Verify input testing string or string palindrome   
    * @param testString input testing string
    * @return true - if string palindrome else false  
    */
	public static boolean isPalindrome(String testString) 
	{
		// Set begin position of testing string 
		int beginPosition = 0;

		// Verify correct input parameter of method
		if  (!(testString instanceof String)) return false;
          
		// Get string without specials chars and lower case
		testString = testString.toLowerCase().replaceAll("[^a-zà-ÿ0-9]+",""); 
		
		// Verify result row by zero length
		if (testString == null) 
		{
			System.out.println("Not correct input string.");
			return false;
		}

		// Get end position of testing string 
		int endPosition=testString.length()-1;

		// compare chars of string from outside to middle position
		while (beginPosition < endPosition) {
			if (testString.charAt(beginPosition) != testString.charAt(endPosition)) 
			{
				// testing string is not palindrome   
				return false;
			} 
			else 
			{
				beginPosition++;
				endPosition--;				
			}
		}
		// testing string is palindrome   
		return true;
	}
}
