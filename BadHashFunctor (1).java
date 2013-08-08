package assignment8;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
public class BadHashFunctor implements HashFunctor
{
	@Override
	public int hash(String item)
	{						
		return item.length();
	}

}
