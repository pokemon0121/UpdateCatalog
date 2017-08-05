import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String[][] catalog = new String[][] {{"Books", "Classics", "Fiction"},
		           {"Electronics", "Cell Phones", "Computers", "Ultimate item"},
				   {"Grocery", "Beverages", "Snacks"},
 				   {"Snacks", "Chocolate", "Sweets"},
				   {"root", "Books", "Electronics", "Grocery"}};
		
		String[][] updates = new String[][] {{"Snacks","Marmalade"}, 
			{"Fiction ","The Chronicles of Narnia"}, 
			{"Fiction ","Fiction stories"}, 
			{"Snacks","Tuc"}, 
			{"root","T-shirts-men"}, 
			{"T-shirts-men","My little pony t-shirt"}, 
			{"Fiction ","Harry Potter"}, 
			{"root","T-shirts"}, 
			{"T-shirts","CodeFights"}, 
			{"Fiction stories","Frozen heart"}, 
			{"Fiction stories","Marvel films"}, 
			{"Marvel films","Ant-man"}, 
			{"Marvel films","Avengers"}};
		
		String[][] r = catalogUpdate(catalog, updates);
		
		for (String[] ra : r) {
			for (String s : ra) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
	}

	public static void print(List<String> l) {
		for (String str : l) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
	
	public static String[][] catalogUpdate(String[][] catalog, String[][] updates) {
	    Map<String, List<String>> catalogMap = new HashMap<>();
	    // convert to map
	    for (String[] s : catalog) {
	        List<String> items = new ArrayList<>(Arrays.asList(s));
	        catalogMap.put(s[0], items.subList(1, items.size()));
	    }
	    // update the map
	    for (String[] s : updates) {
	        List<String> items = catalogMap.get(s[0]);	        
	        List<String> newItems = new ArrayList<>(Arrays.asList(s));
	        if (items == null) {
	            catalogMap.put(s[0], newItems.subList(1, newItems.size()));
	        }
	        else {
	        	print(newItems.subList(1, newItems.size()));
	            items.addAll(newItems.subList(1, newItems.size()));
	            Collections.sort(items);
	            catalogMap.put(s[0], items);
	        }
	    }
	    // sort and convert back to String[][]
	    List<String> names = new ArrayList<>();
	    names.addAll(catalogMap.keySet());
	    Collections.sort(names);
	    String[][] r = new String[names.size()][];
	    for (int n = 0; n < names.size(); n++) {    	
	        String[] items = new String[catalogMap.get(names.get(n)).size() + 1];
	        items[0] = names.get(n);
	        for (int i = 1; i <= catalogMap.get(items[0]).size(); i++) {
	            items[i] = catalogMap.get(items[0]).get(i - 1);
	        }
	        r[n] = items;
	    }
	    return r;
	}
}
