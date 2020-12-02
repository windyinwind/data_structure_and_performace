/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			list1.remove(-1);
			fail("AddAtIndex: Add at low index");
		} catch(Exception e) {
			
		}
		
		try {
			list1.remove(11);
			fail("AddAtIndex: Add at low index");
		} catch(Exception e) {
			
		}
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		assertEquals("remove: check link after remove", list1.head, list1.head.next.prev);
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		try {
			list1.add(null);
			fail("addEnd : Can't add null");
		} catch(Exception e) {
			
		}
		
		
		emptyList.add(1);
		assertEquals("Add: add one element is correct", (Integer)1, emptyList.get(0));
		assertEquals("Add: add one element size is correct", (int) 1, emptyList.size());
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		int size = list1.size();
		assertEquals("List1 size is correct", 3, size);
		list1.remove(0);
		assertEquals("List1 size is 2 after remove 1 element", 2, list1.size());
		list1.add(110);
		assertEquals("List1 size is 3 afer add one element", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
       
		try {
			list1.add(-1, -111);
			fail("AddAtIndex: Add at low index");
		} catch(Exception e) {
			
		}
		
		try {
			list1.add(11, 11);
			fail("AddAtIndex: Add at low index");
		} catch(Exception e) {
			
		}
		
		try {
			list1.add(1, null);
			fail("AddAtIndex : Can't add null");
		} catch(Exception e) {
			
		}
		
		shortList.add(0, "test");
		assertEquals("addAtIndex: check value", shortList.get(0), "test");
		assertEquals("addAtIndex: check value behind new item", shortList.get(1), "A");
		assertEquals("addAtIndex: check size after addition", shortList.size(), 3);
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try {
			list1.set(-1, -111);
			fail("AddAtIndex: Add at low index");
		} catch(Exception e) {
			
		}
		
		try {
			list1.set(11, 11);
			fail("AddAtIndex: Add at low index");
		} catch(Exception e) {
			
		}
		list1.set(0, 110);
		assertEquals("set: check new value is set ", (Integer) 110, list1.get(0) );
		assertEquals("set: check size afeter value is set", 3, list1.size());
	    
	}
	
	
	// TODO: Optionally add more test methods.
	@Test
	public void testHeadTail() {
		assertEquals("Head Tail: check head",  list1.head, list1.head.next.prev);
		assertEquals("Head Tail: check tail", list1.tail, list1.tail.prev.next);
	}
	
}
