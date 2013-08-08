package assignment8;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
import java.util.LinkedList;

public class ChainingHashTable extends HashTable
{
	private int capacity;
	private HashFunctor functor;
	private LinkedList<String>[] table;
	int collisions = 0;
	
	@SuppressWarnings("unchecked")
	public ChainingHashTable(int capacity, HashFunctor functor)
	{
		this.capacity = capacity;
		this.functor = functor;
		table = (LinkedList<String>[]) new LinkedList[capacity];
		// Initialize the table with LinkedLists
		for (int i = 0; i < capacity; i++)
			table[i] = new LinkedList<String>();
	}

	@Override
	public boolean add(String item) 
	{
		// No duplicates.  If it is already in the table return false
		if (contains(item))
		{
			return false;
		}
		int hashRFC = functor.hash(item) % capacity;  // hashRFC is hash "revised for capacity"
		table[hashRFC].add(item);
		
		// For testing purposes
		if (table[hashRFC].size() > 1)
				collisions++;
				
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() 
	{
		// Empty each LinkedList in the array
		for (int i = 0; i < capacity; i++)
			table[i] = new LinkedList<String>();
		size = 0;
	}

	@Override
	public boolean contains(String item) 
	{
		int hashRFC = functor.hash(item) % capacity;
		for (int i = 0; i < table[hashRFC].size() ; i++)
		{
			if (item.equals(table[hashRFC].get(i)))
				return true;
			
			

		}
		
		return false;
	}

	public LinkedList<String>[] getTable()
	{
		return this.table;
	}
	
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public int getSize()
	{
		return this.size;
	}
}
