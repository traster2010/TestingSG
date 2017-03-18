package mostRepeatPhrasesFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * The MostRepeatPhrasesFile class provides methods for
 *  get most repeated phrases in file.
 * @version 1.01 16.03.2017
 * @author Yury Kovalchuk
 */
public class MostRepeatPhrasesFile {

	public MostRepeatPhrasesFile() { }
	
	/**
	 * Filling Map by reverse sorted repeat phrases     
	 * @param fileName name file of phrases  
	 * @param filePhrasesInRow count phrases in row of file    
	 * @return Map with reverse sorted repeat phrases 
	 */
    public Map<String, Integer> fillRepeatPhrases(String fileName, int filePhrasesInRow)
    {
        Map<String, Integer> phrasesMap = new HashMap<>();
        String[] phrasesRowFile = new String[filePhrasesInRow];
        
        // read file of phrases 
        try (BufferedReader in
        		   = new BufferedReader(new FileReader(fileName))) 
        {
        	String rowFile = null;
            while((rowFile = in.readLine()) != null)
            {	
            	// Split phrases in array
            	phrasesRowFile = rowFile.toLowerCase().split("\\|");
            	// get each phrase from array
            	for (String phrase : phrasesRowFile )
            	{
                	// not insert into map empty phrase
                	if (phrase.length() !=0)
                	{
                    	// if phrase exist in map - increment count, else add phrase
	            		if (phrasesMap.containsKey(phrase))
	            		{
	            			phrasesMap.put(phrase, phrasesMap.get(phrase)+1);
	            		} else {
	            			phrasesMap.put(phrase, 1);
	            		}
                	}
            	}
            }
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        } 
        
        // get reverse sorted filled map phrases
        return phrasesMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                  Map.Entry::getKey, 
                  Map.Entry::getValue, 
                  (value1, value2) -> value1, 
                  LinkedHashMap::new ));
    }
 
	/**
	 * Get list most repeat phrases     
	 * @param fileName name file of phrases  
	 * @param filePhrasesInRow count phrases in row of file    
	 * @param maxMostRepeatPhrases max count most repeat phrases  for return   
	 * @return list most repeat phrases   
	 */
    public List<String> getMostRepeatPhrases(String fileName, int filePhrasesInRow, int maxMostRepeatPhrases)
    {
    	int countRepeatPhrases=1;
    	List<String> mostRepeatPhrases = new ArrayList<>();

    	// filling Map by reverse sorted filled map phrases   
    	Map<String, Integer> filledPhrasesMap = fillRepeatPhrases(fileName,filePhrasesInRow);
    	
    	// filling list reverse sorted phrases
        for(Map.Entry<String, Integer> entryPhrases : filledPhrasesMap.entrySet())
        {
        	mostRepeatPhrases.add(entryPhrases.getKey());
        	
        	// if list  contain max most repeat phrases return list 
        	if (countRepeatPhrases < maxMostRepeatPhrases)
        	{
        		countRepeatPhrases++;
        	} else {
        		return mostRepeatPhrases;
        	}
        }
        
        //  return list max most repeat phrases
        return mostRepeatPhrases;
    }
}
