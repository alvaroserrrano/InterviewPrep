package findItinerary;
import java.util.HashMap;
import java.util.Map;
public class findItinerary {
	//Given a list of tickets find the itinerary in order
	/*
	 * Input:
	"Chennai" -> "Banglore"
	"Bombay" -> "Delhi"
	"Goa"    -> "Chennai"
	"Delhi"  -> "Goa"

	 * Output: 
	Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
	 */
	
	
	//First, create hashMap of given pair of tickers
	//Second. we find the starting point by creating a reverse HashMap
	//If key is not present in the reverse map, that is the starting point
	//Third, traverse original map to find itinerary
	// Driver function 
    public static void main(String[] args) 
    { 
        Map<String, String> dataSet = new HashMap<String, String>(); 
        dataSet.put("Chennai", "Banglore"); 
        dataSet.put("Bombay", "Delhi"); 
        dataSet.put("Goa", "Chennai"); 
        dataSet.put("Delhi", "Goa"); 
  
        printResult(dataSet); 
    } //main
	
    private static void printResult(Map<String, String> dataSet) {
    	//Store reverse of given map
    	Map<String, String> reverseMap = new HashMap<String, String>();
    	//Fill reverse map
    	for(Map.Entry<String, String> entry : dataSet.entrySet())
    		reverseMap.put(entry.getValue(), entry.getKey());
    	//Find starting point
    	String start = null;
    	for(Map.Entry<String, String> entry : dataSet.entrySet()) {
    		if(!reverseMap.containsKey(entry.getKey())) {
    			start = entry.getKey();
    			break;
    		}
    	}
    	//If there is no starting point--> Sth worng with input
    	if(start == null) {
    		System.out.println("Invalid Input"); 
            return; 
    	}
    	//Once we have a starting point we go next
    	String to = dataSet.get(start);
    	while(to != null) {
    		System.out.print(start + "->" + to + ", ");
    		start = to;
    		to = dataSet.get(to)
;    	}
    }//method
    
}//class
