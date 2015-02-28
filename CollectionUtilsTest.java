import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


interface ListMapper{
	public int incrementByOne(int num);
}

class Mapper implements ListMapper {
	public int incrementByOne(int number){
		return number+1;
	};
}

public class CollectionUtilsTest{

	@Test
	public void list_mapper_increment_the_number_by_one(){
		List<E> list = new ArrayList<E>();
		list.add(5);
		list.add(15);
		list.add(45);
		ListMapper mapper = new Mapper();
		List<E> list_1 = CollectionUtils.map(list,mapper);
		assertEquals(6,(int)list_1.get(0));
	}
	// @Test
	// public void list_mapper_increment_the_number_by_one(){
	// 	List<E> list = new ArrayList<E>();
	// 	list.add(5);
	// 	list.add(15);
	// 	list.add(45);
	// 	ListMapper mapper = new Mapper();
	// 	List<E> list_1 = CollectionUtils.map(list,mapper);
	// 	assertEquals(6,(int)list_1.get(0));
	// }
}