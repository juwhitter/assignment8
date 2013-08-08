package assignment8;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
import java.util.*;

/**
 * An abstract class facilitating the implementation of a concrete hash table. 
 * @author Paymon Saebi & ??
 *
 */
public abstract class HashTable implements Set<String> 
{
	/**
	 * FILL IN MEMBER VARIABLES!
	 * 
	 * Any member variables that you would maintain in both your QuadProbeHashTable and
	 * your ChainingHashTable (such as, say, a size variable) probably belong here in
	 * the parent class. Should the variable(s) be public, private, or protected?
	 */
	
	protected int size = 0;
	
	public final boolean addAll(Collection<? extends String> items) 
	{
		// None have been added yet
		boolean wasAdded = false;
		//
		for (String s: items)
		{
			// If even one item was added, the HashTable was changed, so return true
			if (add(s))
				wasAdded = true;

		}
		return wasAdded;
	}

	public final boolean containsAll(Collection<? extends String> items) 
	{
		// If even one item was not in the HashTable return false
		for (String s: items)
			if (!contains(s))
				return false;
		
		// Return true if every item was in the HashTable
		return true;
	}

	public final boolean isEmpty() 
	{
		// If the size is 0, then it is empty
		return (this.size() == 0);
	}

	public final int size() 
	{
		return this.size;
	}
}
