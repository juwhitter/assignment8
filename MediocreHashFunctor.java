package assignment8;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
public class MediocreHashFunctor implements HashFunctor
{

	@Override
	public int hash(String item)
	{
		int hash = 0;
		// Sum the askies
		for (int i = 0; i < item.length(); i++)
			hash = hash + (int) item.charAt(i);
		// Add it to length ^ 2
		hash = hash + item.length() * item.length();
		return hash;
	}

}
