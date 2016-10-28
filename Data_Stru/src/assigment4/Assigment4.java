package assigment4;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by liuyufei on 26/10/16.
 */
public class Assigment4 {

    public static void main(String[] args) {
    	Map<String,Integer> result = new HashMap<>();
    	File f = new File(Assigment4.class.getResource("assignment4.txt").getFile());
    	Scanner scanner = null;
        try {
            scanner = new Scanner(f);
            while(scanner.hasNext()){
            	String line = scanner.nextLine();
            	String[] line_result = line.split("\\s");
            	for(String word:line_result){
            		if(result.containsKey(word)){
            			result.put(word, result.get(word)+1);
            		}else{
            			result.put(word,1);
            		}
            	}
            }
        }catch (IOException e) {
            System.out.println("Unable to create: " + e.getMessage());
        } finally {
            if (scanner != null) scanner.close();
        }
        print3Entries(result);
        sortByValue(result);
    }

    private static void print3Entries(Map<String,Integer> result){
    	Set<Map.Entry<String, Integer>> entries = result.entrySet();
    	Iterator<Map.Entry<String, Integer>> iterable = entries.iterator();
    	int MAX = 3;
    	int counter = 1;
    	while (iterable.hasNext()) {
			Map.Entry<String, Integer> entry =  iterable.next();
			System.out.println(entry.getKey()+"=>"+entry.getValue());
			if((counter++)==MAX){
				break;
			}
		}
    }

    private static void sortByValue(Map<String,Integer> map){
    	 Map<String, Integer> result =  map.entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                 .collect(Collectors.toMap(
                   Map.Entry::getKey,
                   Map.Entry::getValue,
                   (e1, e2) -> e1,
                   LinkedHashMap::new //need to record the order of insertion via LinkedHashMap!!!
                 ));
    	 System.out.println(result);
    }

}
