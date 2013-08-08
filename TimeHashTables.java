package assignment8;

import java.util.ArrayList;
/*
 * Julian Whitteron
 * Braeden Bodily
 */
public class TimeHashTables
{
	public static void main(String[] args)
	{
		// TESTING HASH FUNCTION COLLISIONS
		int timesToLoop = 1;
		int numberPlotPoints = 50;
		int startSize = 500;
		int incrementSize = 500;
		
		String letters = "abcdefghijklmnopqrstuvwxyz";  // Used to grab a random letter
		long totalStart = 0, totalEnd = 0;  // Total time to run ALL testing
		long start, mid, end; // Timing variables
		
		totalStart = System.nanoTime();
//		System.out.println("Test QuadProbe");
//		System.out.println("Size N,      BadHashFunctorAdd,     nanoseconds,     BadHashFunctorContain,     nanoseconds,    MediocreHashFunctorAdd,      nanoseconds,     MediocrehashFunctorContain,     nanoseconds,      GoodhashFunctorAdd,      nanoseconds,     GoodHashFunctorContain,     nanoseconds");
		
//		// Let the system pause and get ready to do testing.
//		try 
//		{
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {e.printStackTrace();}
//		
//		// (PLOT POINTS) Get numberPlotPoints in increments of incrementSize
//		for (int i = startSize; i < startSize + (incrementSize * numberPlotPoints); i = i + incrementSize)
//		{	
//			int badCollisionsAdd = 0;
//			long badTimeAdd = 0;
//			int badCollisionsContain = 0;
//			long badTimeContain = 0;
//			
//			int mediocreCollisionsAdd = 0;
//			long mediocreTimeAdd = 0;
//			int mediocreCollisionsContain = 0;
//			long mediocreTimeContain = 0;
//			
//			int goodCollisionsAdd = 0;
//			long goodTimeAdd = 0;
//			int goodCollisionsContain = 0;
//			long goodTimeContain = 0;
//
//			for (int h = 0; h < timesToLoop; h++)
//			{
//				HashFunctor functor = new BadHashFunctor();
//				QuadProbeHashTable test = new QuadProbeHashTable((i * 2) + 3, functor);  // Ensure no grow() calls
//				
//				// Create an array with random strings
//				ArrayList<String> randomStrings = new ArrayList<String>();
//				// Fill the randomStrings
//				for (int j = 0; j < i; j++)
//				{
//					String s = "";
//					// Build the random string
//					for (int k = 0; k < 30; k++)
//					{
//						// Create a chance that the string will stop being built
//						if (Math.random() < 0.05)
//							break;
//						
//						s = s + letters.charAt((int) (Math.random() * 26));
//					}
//					
//					// Fill randomStrings
//					randomStrings.add(s);
//				}
//				
//				//TEST ADDING
//				// Collisions for BAD
//				start = System.nanoTime();
//				test.addAll(randomStrings);
//				end = System.nanoTime();
//				badCollisionsAdd += test.collisions;
//				badTimeAdd = (badTimeAdd + (end - start));
//				//TEST CONTAINS
//				test.collisionsContain = 0;  // Set this to 0 as add may have called the contain method()
//				start = System.nanoTime();
//				test.containsAll(randomStrings);
//				end = System.nanoTime();
//				badCollisionsContain += test.collisions;
//				badTimeContain = (badTimeContain + (end - start));
//				
//				
//				// Collisions for MEDIOCRE
//				functor = new MediocreHashFunctor();
//				test = new QuadProbeHashTable((i * 2) + 3, functor);
//				start = System.nanoTime();
//				test.addAll(randomStrings);
//				end = System.nanoTime();
//				mediocreCollisionsAdd += test.collisions;
//				mediocreTimeAdd = (mediocreTimeAdd + (end - start));
//				//TEST CONTAINS
//				test.collisionsContain = 0;  // Set this to 0 as add may have called the contain method()
//				start = System.nanoTime();
//				test.containsAll(randomStrings);
//				end = System.nanoTime();
//				mediocreCollisionsContain += test.collisions;
//				mediocreTimeContain = (mediocreTimeContain + (end - start));
//				
//				
//				// Collisions for GOOD
//				functor = new GoodHashFunctor();
//				test = new QuadProbeHashTable((i * 2) + 3, functor);
//				start = System.nanoTime();
//				test.addAll(randomStrings);
//				end = System.nanoTime();
//				goodCollisionsAdd += test.collisions;
//				goodTimeAdd = (goodTimeAdd + (end - start));
//				//TEST CONTAINS
//				test.collisionsContain = 0;  // Set this to 0 as add may have called the contain method()
//				start = System.nanoTime();
//				test.containsAll(randomStrings);
//				end = System.nanoTime();
//				goodCollisionsContain += test.collisions;
//				goodTimeContain = (goodTimeContain + (end - start));
//			}				
//			
//			// Print out results
//			System.out.println(i + ",          " + (badCollisionsAdd / timesToLoop) + ",           " + (badTimeAdd / timesToLoop) + ",          " + (badCollisionsContain / timesToLoop) + ",           " + (badTimeContain / timesToLoop) +  ",           " + (mediocreCollisionsAdd / timesToLoop) + ",                    " + (mediocreTimeAdd / timesToLoop) +  ",           " + (mediocreCollisionsContain / timesToLoop) + ",           " + (mediocreTimeContain / timesToLoop) + ",         " + (goodCollisionsAdd / timesToLoop) + ",                 " + (goodTimeAdd / timesToLoop) + ",         " + (goodCollisionsContain / timesToLoop) + ",           " + (goodTimeContain / timesToLoop));
//		}
		
//		System.out.println();
//		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
//		System.out.println("TEST CHAIN");
//		System.out.println();
//		
//		
//		//TEST CHAIN
//		System.out.println("Size N,  BadCollisionsContain,  BadTime,  MediocreCollisionsContain,  MediocreTime,  GoodCollisionsContain,  GoodTime");
//		try 
//		{
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {e.printStackTrace();}
//		for (int i = startSize; i < startSize + (incrementSize * numberPlotPoints); i = i + incrementSize)
//		{
//			int badCollisions = 0;
//			int mediocreCollisions = 0;
//			int goodCollisions = 0;
//			
//			long badTimeCon = 0;
//			long mediocreTimeCon = 0;
//			long goodTimeCon = 0;
//			
//			for (int h = 0; h < timesToLoop; h++)
//			{
//				HashFunctor functor = new BadHashFunctor();
//				ChainingHashTable test = new ChainingHashTable((i / 2), functor);
//				
//				// Create an array with random strings
//				ArrayList<String> randomStrings = new ArrayList<String>();
//				// Fill the randomStrings
//				for (int j = 0; j < i; j++)
//				{
//					String s = "";
//					// Build the random string
//					for (int k = 0; k < 30; k++)
//					{
//						// Create a chance that the string will stop being built
//						if (Math.random() < 0.05)
//							break;
//						
//						s = s + letters.charAt((int) (Math.random() * 26));
//					}
//					
//					// Fill randomStrings
//					randomStrings.add(s);
//				}
//				
//				// Add All
//				// BADHASH
//				test.addAll(randomStrings);  // Add the items to ChainHash
//				start = System.nanoTime();
//				test.containsAll(randomStrings);  // Time for containsAll
//				end = System.nanoTime();
//				badTimeCon = badTimeCon + (end - start);
//				badCollisions = badCollisions + test.collisions;
//				
//				// MediocreHASH
//				functor = new MediocreHashFunctor();
//				test = new ChainingHashTable((i * 2) + 5, functor);
//				test.addAll(randomStrings);
//				start = System.nanoTime();
//				test.containsAll(randomStrings);
//				end = System.nanoTime();
//				mediocreTimeCon = mediocreTimeCon + (end - start);
//				mediocreCollisions = mediocreCollisions + test.collisions;
//				
//				// MediocreHASH
//				functor = new GoodHashFunctor();
//				test = new ChainingHashTable((i * 2) + 5, functor);
//				test.addAll(randomStrings);
//				start = System.nanoTime();
//				test.containsAll(randomStrings);
//				end = System.nanoTime();
//				goodTimeCon = goodTimeCon + (end - start);
//				goodCollisions = goodCollisions + test.collisions;			
//			}
//			
//			System.out.println(i + ",     " + (badCollisions / timesToLoop) + ",     " + (badTimeCon / timesToLoop) + ",     " + (mediocreCollisions / timesToLoop) + ",     " + (mediocreTimeCon / timesToLoop) + ",     " + (goodCollisions / timesToLoop) + ",     " + (goodTimeCon / timesToLoop));
//		}
		
//		System.out.println();
//		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
//		System.out.println("BIG(O) for each HashFunctor");
//		System.out.println("StringSize,   Avg. BadTime,   Avg MediocreTime,   Avg GoodTime,");
//		
//		// Test big-O for different stringSizes
//		try 
//		{
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {e.printStackTrace();}
//		
//		for (int stringSize = 100; stringSize < 100000; stringSize += 500)
//		{
//			System.out.print(stringSize);  // Current size of strings being made
//			
//			ArrayList<String> tenRandomStrings = new ArrayList<String>();
//			// Create 10 random strings of stringSize			
//			for (int i = 0; i < 10; i++)
//			{
//				// Build the random string
//				String s = "";
//				for (int k = 0; k < stringSize; k++)
//				{
//					// Create a chance that the string will stop being built
//	
//					
//					s = s + letters.charAt((int) (Math.random() * 26));
//				}
//				// Fill randomStrings
//				tenRandomStrings.add(s);
//			}
//			
//			HashFunctor functor = new BadHashFunctor();
//			
//			// Time BADFunctor
//			start = System.nanoTime();
//			for (int i = 0; i < 10; i++)
//				functor.hash(tenRandomStrings.get(i));
//			mid = System.nanoTime();
//			for (int i = 0; i < 10; i++);  // Time for-loop
//			end = System.nanoTime();
//			
//			System.out.print(",   " + ((mid - start - (end - mid)) / 10));
//			
//			
//			// Time MediocreFunctor
//			functor = new MediocreHashFunctor();
//			start = System.nanoTime();
//			for (int i = 0; i < 10; i++)
//				functor.hash(tenRandomStrings.get(i));
//			mid = System.nanoTime();
//			for (int i = 0; i < 10; i++);  // Time for-loop
//			end = System.nanoTime();
//			
//			System.out.print(",   " + ((mid - start - (end - mid)) / 10));
//			
//			
//			// Time GoodFunctor
//			functor = new GoodHashFunctor();
//			start = System.nanoTime();
//			for (int i = 0; i < 10; i++)
//				functor.hash(tenRandomStrings.get(i));
//			mid = System.nanoTime();
//			for (int i = 0; i < 10; i++);  // Time for-loop
//			end = System.nanoTime();
//			
//			System.out.println(",   " + ((mid - start - (end - mid)) / 10) + ",");
//			
//			
//		}
		
		System.out.println();
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		System.out.println("Testing for different loadCaps for good Hash Functor");
		System.out.println("Size N, LoadCap,  collisions,  nanoseconds");
		
		// Test different load capacities for both QuadProbe and HashTable
		for (double i = 0.1; i < 0.9; i = i + 0.05)
		{
			System.out.print("20000, " + i + ",   ");
			HashFunctor functor = new GoodHashFunctor();
			QuadProbeHashTable testQuad = new QuadProbeHashTable(1, functor);
			testQuad.loadCapMax = i;
			
			ArrayList<String> randomStrings = new ArrayList<String>();
			// Fill the randomStrings
			for (int j = 0; j < 20000; j++)
			{
				String s = "";
				// Build the random string
				for (int k = 0; k < 30; k++)
				{
					// Create a chance that the string will stop being built
					if (Math.random() < 0.05)
						break;
					
					s = s + letters.charAt((int) (Math.random() * 26));
				}
				
				// Fill randomStrings
				randomStrings.add(s);
			}
			
			start = System.nanoTime();
			testQuad.addAll(randomStrings);
			end = System.nanoTime();
			System.out.print(testQuad.collisions + ",     " + (end - start));
			
			// Test chain with a capacity of the same percent
			ChainingHashTable testChain = new ChainingHashTable((int)(i * 20000), functor);
			start = System.nanoTime();
			testChain.addAll(randomStrings);
			end = System.nanoTime();
			
			System.out.println(",   " + testChain.collisions + ",     " + (end - start));
			
			
		}
			
		totalEnd = System.nanoTime();
		
		System.out.println();
		System.out.println("Total time for testing in nanoseconds was:   " + (totalEnd - totalStart));
		

		
	}
}
