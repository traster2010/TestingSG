package performanceTesterInpl;

/**
 * The FibCalcInpl class provide method for
 * calculates the Fibonacci number with the given index
 * @version 1.01 19.03.2017
 * @author Yury Kovalchuk
 */
public class FibCalcInpl implements FibCalc {

	/**
	 * Calculates the Fibonacci number with the given index.
	 * @param n index of Fibonacci number
	 * @return Fibonacci number
	 */
	public long fib(int n) {
		//initialization
		long fibNumber = 0;
		
		// get Fibonacci number by index
	    if (n <= 1) {
	    	fibNumber = n;
	    } else {
	    	fibNumber = fib(n-1) + fib(n-2);
	    }

	    //System.out.println("n - "+ n + " , fib - "+fibNumber);
	    
	    // return Fibonacci number 
	    return fibNumber;    
	}
}

