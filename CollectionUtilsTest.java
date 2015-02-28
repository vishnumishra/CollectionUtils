import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


interface ListMapper<E>{
	public E increment(E num);
}

interface ListFilter<E>{
	public boolean filterLess(E num);
}

class FilterInt implements ListFilter<Integer> {
	public boolean filterLess(Integer number){
		return number >= 10;
	};
}

class MapInt implements ListMapper<Integer> {
	public Integer increment(Integer number){
		return number+1;
	};
}

class MapString implements ListMapper<String> {
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
	public void list_mapper_add_incremented_to_string(){
		List<String> list = new ArrayList<String>();
		list.add("param");
		list.add("karam");
		list.add("dhram");
		ListMapper mapper = new MapString();
		List<String> list_1 = CollectionUtils.<String>map(list,mapper);
		System.out.println(list_1.get(0));
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
}