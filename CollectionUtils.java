import java.util.*;

public  class CollectionUtils{
	
	public static <E> List<E> map(List<E> list, ListMapper method){
		List<E> resultList = new ArrayList();
		for (E i:list ) {
			resultList.add((E)method.increment(i));
		}
		return resultList; 
	}
	public static <E> List<E> filter(List<E> list, ListFilter method){
		List<E> resultList = new ArrayList();
		for (E i:list ) {
			if((boolean)method.filterLess(i))
			 resultList.add(i);
		}
		return resultList; 
	}
}