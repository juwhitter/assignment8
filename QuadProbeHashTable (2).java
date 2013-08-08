package assignment8;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
public class QuadProbeHashTable extends HashTable
{
	private int capacity;
	private HashFunctor functor;
	private String[] table;
	
	double loadCapMax = 0.5;
	int collisions;  // Used for testing number of collisions
	int collisionsContain;
	
	/**
	 * Constructor
	 * @param capacity
	 * @param functor
	 */
	public QuadProbeHashTable(int capacity, HashFunctor functor)
	{
		this.capacity = getNextPrime(capacity);
		this.functor = functor;
		this.table = new String[this.capacity];	
		collisions = 0;
		collisionsContain = 0;
	}

	
	@Override
	public boolean add(String item)
	{
		// If we have reached our load capacity, we must rehash into a new array with capacity of the next prime number
		if (((1.00 * size) / capacity) > loadCapMax)
		{
			grow();
		}
		
		// No duplicates.  If it is already in the table return false
		if (contains(item))
		{
			return false;
		}
	
		// Add the item
		int hashRFC = functor.hash(item) % capacity; // hashRFC is Hash that is 'Revised for Capacity'
		int indexToAdd = getNextEmptyHash(hashRFC);
		
		// Add the item to the probed index
		table[indexToAdd] = item;
		size++;  // Increment size by 1
		return true;
	}

	
	@Override
	public void clear()
	{
		// Set table to a new array of the capacity (now empty)
		table = new String[capacity];
		size = 0;
	}

	
	@Override
	public boolean contains(String item)
	{
		int hashRFC = functor.hash(item) % capacity;
		
		if (item.equals(table[hashRFC]))
			return true;
		
		collisionsContain++;
		// Continue probing until we find the item spot.
		for(int i = 0; i < capacity; i++)
		{
			// Quadratic probe
			int newIndex = ((hashRFC + (int) Math.pow(i, 2)) % capacity);
			// If this new spot is empty then return this index
			if (item.equals(table[newIndex]))
			{
				return true;
			}
			if (table[newIndex] == null)
			{
				return false;
			}
			
			collisionsContain++;
		}
		
		return false;
	}
		
	
	/**
	 * Gets the next empty hash available in the table
	 * @param hashRFC
	 * @return
	 */
	public int getNextEmptyHash(int hashRFC)
	{
		// If the hash is empty than we can add it
		if (table[hashRFC] == null)
			return hashRFC;
		
		collisions++;  // Test collision rates
		// Continue probing until we find an empty spot.
		for(int i = 1; true; i++)
		{
			// Quadratic probe
			int newIndex = (hashRFC + (int) Math.pow(i, 2)) % capacity;
			// If this new spot is empty then return this index
			if (table[newIndex] == null)
				return newIndex;
			collisions++;
		}
	}
	
	
	/**
	 * Get next empty hash available in the new tempTable we are creating within a grow() call
	 * @param tempTable
	 * @param hashRFC
	 * @return
	 */
	private int getNextEmptyHash(String[] tempTable, int hashRFC)
	{
		// If the hash is empty than we can add it
		if (tempTable[hashRFC] == null)
			return hashRFC;
		
		// Continue probing until we find an empty spot.
		for(int i = 1; true; i++)
		{
			// Quadratic probe
			int newIndex = (hashRFC + (int) Math.pow(i, 2)) % tempTable.length;
			// If this new spot is empty then return this index
			if (tempTable[newIndex] == null)
				return newIndex;
		}
	}	
	
	
	/**
	 * Grow the size of the table and rehash each element
	 */
	private void grow()
	{
		// Create new array with size of the new capacity
		int newCap = getNextPrime(this.capacity * 2);		
		String[] tempTable = new String[newCap];  // tempTable that will eventually be assigned to table
		
		// Rehash all items
		for (String s: table)
		{
			if (s == null)  // If s is null, then continue to the next string
				continue;
			int hashRFC = functor.hash(s) % newCap;  // Use the cap of the new tempTable
			int index = getNextEmptyHash(tempTable, hashRFC);
			tempTable[index] = s;			
		}
		
		// Set table to our new tempTable
		table = tempTable;
		// Now we can set the table capacity to the new capacity
		this.capacity = newCap;
	}
	
	
	public String[] getTable()
	{
		return this.table;
	}
	
	
	public int getCapacity()
	{
		return this.capacity;
	}
	
	
	public int getSize()
	{
		return size;
	}
	

	/**
	 * Gets the next prime number.
	 * @param capacity
	 * @return
	 */
	private int getNextPrime(int capacity)
	{		
		for (int i = capacity; true; i++ )
		{	
			if (isPrime(i))
			{
				return i;
			}	
		}
	}
	
	

	
	//Helper method for the getNextPrime
	private boolean isPrime(int x)
	{
	
		for (int i = 2; i <= Math.sqrt(x); i++)
		{
			if(x % i ==0)
				return false;
		}
		
		return true;
	}
}
