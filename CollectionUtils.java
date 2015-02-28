import java.util.*;

public  class CollectionUtils{
	
	public static List<Integer> map(List<Integer> list, ListMapper method){
		List<Integer> resultList = new ArrayList<Integer>();
		for (Integer i:list ) {
			resultList.add((int) method.incrementByOne(i));
		}
		return resultList; 
	}

}