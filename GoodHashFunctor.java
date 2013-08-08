package assignment8;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
public class GoodHashFunctor implements HashFunctor
{

	@Override
	public int hash(String item) 
	{
		int hash = 0;
		// Sum the askies
		int sum = 0;
		for (int i = 0; i < item.length(); i++)
			sum = sum + (int) item.charAt(i);
		
		// Allow hash to get relatively large
		hash = (sum * item.length() + sum * (item.length() + 3)) * sum + (sum - item.length());
		
		return Math.abs(hash);
	}

}
