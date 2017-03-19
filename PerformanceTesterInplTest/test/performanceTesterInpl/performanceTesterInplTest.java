package performanceTesterInpl;

import static org.junit.Assert.assertNotEquals;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Class PerformanceTesterInplTest demonstrates JUnit test 
 * functionality methods of PerformanceTesterInpl class
 * @version 1.01 19.03.2017
 * @author Yury Kovalchuk
 */
public class PerformanceTesterInplTest extends TestCase {
	PerformanceTester performTester ;
	int n;				// index Fibonacci 
	int executionCount; // how many times the task should be executed in total
	int threadPoolSize; // how many threads to use
	
	/**
     * Get JUnit test from command line 
     */
	public static void main(String[] args) throws Exception 
	{
		JUnitCore runner = new JUnitCore();
		Result result = runner.run(PerformanceTesterInplTest.class);
		System.out.println("Run tests: " + result.getRunCount());
		System.out.println("Failed tests: " + result.getFailureCount());
		System.out.println("Ignored tests: " + result.getIgnoreCount());
		System.out.println("Success: " + result.wasSuccessful());
	}
	

	public void setUp() throws Exception {
		
    	// initialization
        performTester = new PerformanceTesterInpl();
		n = 30;
		executionCount = 15;
		threadPoolSize = 5;
    }
    
	public void testRunPerformance() throws Exception 
	{

		PerformanceTestResult performTestResult = performTester.runPerformanceTest(
        		( ) -> { new FibCalcInpl().fib(n); },executionCount,threadPoolSize);
        
        System.out.println("Shortest single execution took time : " + performTestResult.getMinTime() );
        System.out.println("Longest single execution took  time : " + performTestResult.getMaxTime() );
        System.out.println("Performance test took in total time : " + performTestResult.getTotalTime() );
        
        assertNotEquals("return MaxTime",0, performTestResult.getMaxTime() );
        assertNotEquals("return TotalTime",0, performTestResult.getTotalTime() );
	}

}
