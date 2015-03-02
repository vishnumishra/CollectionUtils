import java.util.*;

public  class CollectionUtils{				
	public static <E,K> List<K> map(List<E> list, ListMapper<E,K> method){ //or use ListMapper without <E,K> 
		List<K> resultList = new ArrayList<K>();
		for (E i:list ) {
			resultList.add((K)method.increment(i));
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
	public static <E,K> K reducer(List<E> list, ListReducer<E,K> method , K initial){
		K result =null ;
		// result =  method.sqrtAdder(initial,);
		// for (int i=0;i<list.lenght;i++ ) {
		// 	if(i==0)
		// 		result = initial;
		// 	result =  method.sqrtAdder(result,i);
		// }
		for (E i:list ) {
			if(result == null)
				result = initial;
			result =  method.sqrtAdder(result,i);
		}
		return result;
	}
}