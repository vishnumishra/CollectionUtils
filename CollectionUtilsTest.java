import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


interface ListMapper<E,K>{
	public K increment(E num);
}

interface ListFilter<E>{
	public boolean filterLess(E num);
}

interface ListReducer<E,K>{
	public K sqrtAdder(K previous,E curren);
}

class Reducer implements ListReducer<Integer,Double> {
	public Double sqrtAdder(Double previous,Integer current){
		return previous+Math.sqrt(current);
	};
}


class FilterInt implements ListFilter<Integer> {
	public boolean filterLess(Integer number){
		return number >= 10;
	};
}

class FilterString implements ListFilter<String> {
	public boolean filterLess(String str){
		return str.length() > 5;
	};
}

class MapInt implements ListMapper<Integer,Integer> {
	public Integer increment(Integer number){
		return number+1;
	};
}

class SquareRoot implements ListMapper<Integer,Double> {
	public Double increment(Integer number){
		return Math.sqrt(number);
	};
}

class MapString implements ListMapper<String,String> {
	public String increment(String str){
		return str+" incremented";
	};
}

public class CollectionUtilsTest{

	@Test
	public void list_mapper_increment_the_number_by_one(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(15);
		list.add(45);
		ListMapper mapper = new MapInt();
		List<Integer> list_1 = CollectionUtils.map(list,mapper);
		assertEquals(6,(int)list_1.get(0));
	}
	@Test
	public void list_mapper_the_sqrt_of_the_number(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(15);
		list.add(45);
		ListMapper mapper = new SquareRoot();
		List<Double> list_1 = CollectionUtils.map(list,mapper);
		assertEquals((double)Math.sqrt(5),(double)list_1.get(0),0);
		assertEquals((double)Math.sqrt(15),(double)list_1.get(1),0);
		assertEquals((double)Math.sqrt(45),(double)list_1.get(2),0);
	}

	@Test
	public void list_mapper_add_incremented_to_string(){
		List<String> list = new ArrayList<String>();
		list.add("param");
		list.add("karam");
		list.add("dhram");
		ListMapper mapper = new MapString();
		List<String> list_1 = CollectionUtils.map(list,mapper);
		assertEquals("param incremented",(String)list_1.get(0));
		assertEquals("karam incremented",(String)list_1.get(1));
	}

	@Test
	public void list_filter_remove_the_number_less_then_10(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(8);
		list.add(45);
		ListFilter filterObj = new FilterInt();
		List<Integer> list_1 = CollectionUtils.filter(list,filterObj);
		assertEquals(45,(int)list_1.get(0));
	}

	@Test
	public void list_filter_remove_the_string_which_length_less_then_five(){
		List<String> list = new ArrayList<String>();
		list.add("param");
		list.add("parmatma");
		list.add("vishnu");
		ListFilter filterObj = new FilterString();
		List<String> list_1 = CollectionUtils.filter(list,filterObj);
		assertEquals("parmatma",(String)list_1.get(0));
		assertEquals("vishnu",(String)list_1.get(1));
	}


	@Test
	public void list_reduce_reduce_the_list_and_give_the_resualt(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(8);
		Reducer reduceObj = new Reducer();
		double result = CollectionUtils.reducer(list,reduceObj,Math.sqrt(3));
		assertEquals((double)(Math.sqrt(3)+Math.sqrt(5)+Math.sqrt(8)),result,0);
	}
}