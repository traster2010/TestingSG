package performanceTesterInpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The PerformanceTesterInpl class provides methods for
 * run a performance test of the given task
 * @version 1.01 19.03.2017
 * @author Yury Kovalchuk
 */
public class PerformanceTesterInpl implements PerformanceTester {

	/**
	 * Runs a performance test of the given task.
	 * @param task which task to do performance tests on
	 * @param executionCount how many times the task should be executed in total
	 * @param threadPoolSize how many threads to use
	 * @return resulting times for task
	 */
	public PerformanceTestResult runPerformanceTest(Runnable task,int executionCount,int threadPoolSize) throws InterruptedException
	{   
		//initialization
		Map<Thread, Long[]> testResult = new HashMap<>();
        long minTime = 0;
        long maxTime = 0;
		long totalTime = 0;
		int runnerIndex = 0;

		// create threads with logic execute task
        while ( runnerIndex < threadPoolSize) 
        {
            Runnable runner = ( ) -> {
            		int taskIndex = 0;
            		Thread currentThread = Thread.currentThread();
                    Long[] timeExecutions = testResult.get(currentThread);
                    while ( taskIndex < timeExecutions.length) 
                    {
                        long timeRun = System.currentTimeMillis();
                        task.run();
                        long timeEnd = System.currentTimeMillis();
                        timeExecutions[taskIndex] = timeEnd - timeRun;
                        taskIndex++; 
                    }
            };
            testResult.put(new Thread(runner), new Long[executionCount]);
        	runnerIndex++;
        }

        // starting threads
        for (Thread thread : testResult.keySet()) {
            thread.start();
        }

        // get times execution of tasks in temporary list
        ArrayList<Long> timesTestResult = new ArrayList<>();
        for (Entry<Thread, Long[]> testEntry : testResult.entrySet()) {
        	Thread threadEntry=testEntry.getKey();
        	threadEntry.join();
            for (Long timeTest : testEntry.getValue())
            	timesTestResult.add(timeTest);
        }

        // get resulting times for task
        for (Long timeTest : timesTestResult) {
            if (minTime == 0)  minTime = timeTest; else minTime = Math.min( minTime,timeTest);
            maxTime = Math.max(maxTime, timeTest);
            totalTime += timeTest;
        }

        // return resulting times for task
        return new PerformanceTestResult(totalTime, minTime, maxTime);
	}
	
}
