package assignment8;

import java.util.ArrayList;

import junit.framework.TestCase;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
public class TestHashTables extends TestCase 
{
	QuadProbeHashTable testQuad;
	ChainingHashTable testChain;

	protected void setUp() throws Exception
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testQuad()
	{
		HashFunctor functor = new BadHashFunctor();
		testQuad = new QuadProbeHashTable(1, functor);
		
		assertEquals(1, testQuad.getCapacity());
		assertEquals(0, testQuad.getSize());
		assertEquals(true, testQuad.add("a"));
		assertEquals(false, testQuad.add("a"));  // Cannot add a duplicate, also called grow() in add()
		assertEquals(2, testQuad.getCapacity());  // It should have grown after adding
		assertEquals(2, testQuad.getTable().length);  // The length of the table should be capacity
		assertEquals(1, testQuad.getSize());
		assertEquals("a", testQuad.getTable()[1]);
		
		// Compare hash values
		assertEquals(functor.hash("a"), functor.hash("b"));
		
		assertEquals(true, testQuad.add("b"));
		assertEquals(2, testQuad.getSize());
		assertEquals("b", testQuad.getTable()[0]);
		testQuad.add("c");
		assertEquals(5, testQuad.getCapacity());
		assertEquals(5, testQuad.getTable().length);
		assertEquals(3, testQuad.getSize());
		assertEquals(5, testQuad.getCapacity());
		assertEquals("b", testQuad.getTable()[1]);
		assertEquals("a", testQuad.getTable()[2]);
		assertEquals("c", testQuad.getTable()[0]);
		testQuad.add("d");
		assertEquals(11, testQuad.getCapacity());
		assertEquals(11, testQuad.getTable().length);
		assertEquals(4, testQuad.getSize());
		assertEquals("c", testQuad.getTable()[1]);
		assertEquals("b", testQuad.getTable()[2]);
		assertEquals("a", testQuad.getTable()[5]);
		assertEquals("d", testQuad.getTable()[10]); // Test that it is quadratic probing
		testQuad.add("e");
		assertEquals("e", testQuad.getTable()[6]);
		assertEquals(5, testQuad.getSize());
		testQuad.add("f");
		assertEquals("f", testQuad.getTable()[4]); // It "modded" the array correctly
		
		// Test contains
		assertEquals(true, testQuad.contains("a"));
		assertEquals(true, testQuad.contains("b"));
		assertEquals(true, testQuad.contains("c"));
		assertEquals(true, testQuad.contains("d"));
		assertEquals(true, testQuad.contains("e"));
		assertEquals(true, testQuad.contains("f"));
		assertEquals(false, testQuad.contains("k"));
		assertEquals(false, testQuad.contains("hello"));
		
		// Go back to adding
		testQuad.add("hi");
		assertEquals(7, testQuad.getSize());
		assertEquals(23, testQuad.getCapacity());
		assertEquals(23, testQuad.getTable().length);
		// Check locations now that an item with a different hash was located and it called grow()
		assertEquals("c", testQuad.getTable()[1]);
		assertEquals("b", testQuad.getTable()[2]);
		assertEquals("d", testQuad.getTable()[3]);
		assertEquals("f", testQuad.getTable()[5]);
		assertEquals("a", testQuad.getTable()[10]);
		assertEquals("e", testQuad.getTable()[17]);
		assertEquals("hi", testQuad.getTable()[6]);
		testQuad.add("by");
		assertEquals("by", testQuad.getTable()[11]);
		testQuad.add("sye");
		assertEquals("sye", testQuad.getTable()[4]);
		
		// Test an addAll() with a different test
		QuadProbeHashTable testQuad2 = new QuadProbeHashTable(1, functor);
		ArrayList<String> addAllTest = new ArrayList<String>();		
		addAllTest.add("a");
		addAllTest.add("b");
		addAllTest.add("c");
		addAllTest.add("d");
		addAllTest.add("e");
		addAllTest.add("f");
		addAllTest.add("hi");
		addAllTest.add("by");
		addAllTest.add("sye");
		
		assertEquals(true, testQuad.containsAll(addAllTest));
		assertEquals(true, testQuad2.addAll(addAllTest));
		assertEquals(testQuad.getCapacity(), testQuad2.getCapacity());
		assertEquals(testQuad.getTable().length, testQuad2.getTable().length);
		
		// Check each spot in both QuadHashTable
		for (int i = 0; i < testQuad.getCapacity(); i++)	
			assertEquals(testQuad.getTable()[i], testQuad2.getTable()[i]);
		
		assertEquals(true, testQuad2.containsAll(addAllTest));
		
		assertEquals(false, testQuad.addAll(addAllTest));
		assertEquals(false, testQuad2.addAll(addAllTest));
		// Ensure that the sizes are still the same
		assertEquals(23, testQuad.getCapacity());
		assertEquals(23, testQuad.getTable().length);
		
		// Check containsAll
		assertEquals(true, testQuad.containsAll(addAllTest));
		addAllTest.add("not");  // Add something that is not in the Hash Table
		assertEquals(false, testQuad.containsAll(addAllTest));
		testQuad.add("not");  // Now the Hash Table contains this string
		assertEquals(true, testQuad.containsAll(addAllTest));
		
		// Test isEmpty() and clear()
		assertEquals(false, testQuad.isEmpty());
		testQuad.clear();
		assertEquals(0, testQuad.getSize());
		assertEquals(23, testQuad.getCapacity());  // Capacity should remain the same
		assertEquals(23, testQuad.getTable().length);
		for (int i = 0; i < testQuad.getCapacity(); i++)  // Test that each element is null
			assertEquals(null, testQuad.getTable()[i]);
		
		// Test adding of several items and their locations now that it has been cleared
		testQuad.add("a");
		testQuad.add("b");
		testQuad.add("c");
		testQuad.add("d");
		testQuad.add("e");
		assertEquals(false, testQuad.isEmpty());
		// Test locations
		assertEquals("a", testQuad.getTable()[1]);
		assertEquals("b", testQuad.getTable()[2]);
		assertEquals("c", testQuad.getTable()[5]);
		assertEquals("d", testQuad.getTable()[10]);
		assertEquals("e", testQuad.getTable()[17]);
		
		testQuad = new QuadProbeHashTable(40, functor);
		assertEquals(41, testQuad.getCapacity());  // Should have been set to next prime number for capacity
		testQuad.add("a");
		testQuad.add("b");
		testQuad.add("c");
		testQuad.add("d");
		testQuad.add("e");
		testQuad.add("f");
		testQuad.add("g");
		testQuad.add("h");
		assertEquals("a", testQuad.getTable()[1]);
		assertEquals("b", testQuad.getTable()[2]);
		assertEquals("c", testQuad.getTable()[5]);
		assertEquals("d", testQuad.getTable()[10]);
		assertEquals("e", testQuad.getTable()[17]);
		assertEquals("f", testQuad.getTable()[26]);
		assertEquals("g", testQuad.getTable()[37]);
		assertEquals("h", testQuad.getTable()[9]);
		assertEquals(8, testQuad.getSize());  // Check the size and capacity
		assertEquals(41, testQuad.getTable().length);
		assertEquals(41, testQuad.getCapacity());
		//Reach the load factor to test grow
		assertEquals(true, testQuad.add("aa"));
		assertEquals(true, testQuad.add("ab"));
		assertEquals(true, testQuad.add("ac"));
		assertEquals(true, testQuad.add("ad"));
		assertEquals(true, testQuad.add("ae"));
		assertEquals(true, testQuad.add("af"));
		assertEquals(true, testQuad.add("afeoaihfeoi"));
		assertEquals(true, testQuad.add("afeafe"));
		assertEquals(true, testQuad.add("a1"));




	}
	
	
	public void testChain()
	{
		// Test adding and positions
		HashFunctor functor = new BadHashFunctor();
		testChain = new ChainingHashTable(1, functor);  // Test with capacity of 1 ( everything in 1 linked list)
		assertEquals(1, testChain.getCapacity());
		assertEquals(0, testChain.getSize());
		assertEquals(true, testChain.add("a"));
		assertEquals(false, testChain.add("a"));  // Duplicate
		testChain.add("b");
		testChain.add("c");
		testChain.add("d");
		testChain.add("e");
		testChain.add("f");
		testChain.add("hi");
		testChain.add("by");
		assertEquals(8, testChain.getSize());
		assertEquals(1, testChain.getCapacity());
		// Make sure the single linked list is full of ALL items
		assertEquals(8, testChain.getTable()[0].size());
		assertEquals("a", testChain.getTable()[0].get(0));
		assertEquals("b", testChain.getTable()[0].get(1));
		assertEquals("c", testChain.getTable()[0].get(2));
		assertEquals("d", testChain.getTable()[0].get(3));
		assertEquals("e", testChain.getTable()[0].get(4));
		assertEquals("f", testChain.getTable()[0].get(5));
		assertEquals("hi", testChain.getTable()[0].get(6));
		assertEquals("by", testChain.getTable()[0].get(7));
		
		// Test contains
		assertEquals(true, testChain.contains("a"));
		assertEquals(true, testChain.contains("c"));
		assertEquals(true, testChain.contains("hi"));
		assertEquals(false, testChain.contains("wrong"));
		
		testChain = new ChainingHashTable(40, functor);
		testChain.add("1");
		testChain.add("22");
		testChain.add("333");
		testChain.add("4444");
		testChain.add("55555");
		testChain.add("666666");
		testChain.add("7777777");
		testChain.add("1111");
		assertEquals(2, testChain.getTable()[4].size());  // Test that index 4 has 2 items
		assertEquals(1, testChain.getTable()[1].size());
		assertEquals(0, testChain.getTable()[0].size());
		
		assertEquals(false, testChain.isEmpty());
		testChain.clear();
		assertEquals(true, testChain.isEmpty());
		
		ArrayList<String> addAllTest = new ArrayList<String>();		
		addAllTest.add("a");
		addAllTest.add("b");
		addAllTest.add("c");
		addAllTest.add("d");
		addAllTest.add("e");
		addAllTest.add("f");
		addAllTest.add("hi");
		addAllTest.add("by");
		addAllTest.add("sye");
		assertEquals(true, testChain.addAll(addAllTest));
		assertEquals(false, testChain.addAll(addAllTest));
		assertEquals(true, testChain.containsAll(addAllTest));
		addAllTest.add("afhi");  // Add something that is not in the testChain
		assertEquals(false, testChain.containsAll(addAllTest));
	}
}
