/*
 * A group of n men arranged in a
 * circle (1, 2, 3, ..., n). Every kth man will be eliminated around
 * the circle until only one survivor remains
 */

import java.util.*;

public class JosephusProblem
{
	public static void main(String[] args)
	{
		int n = 15; // number of men to be lined up
		int k = 3; // the kth man to be selected
		findSurvivor(n, k);
	}
	
	// use iterative approach to find the survivor
	// use queue to eliminate every kth man
	public static void findSurvivor(int n, int k)
	{
		Queue<Integer> circle = new ArrayDeque<>();
		int eliminated;
		
		for(int i = 1; i <= n; ++i)
			circle.add(i);
		
		if (n == 1)
		{
			System.out.println("No body is selected.");
			return;
		}
		
		while(circle.size() != 1)
		{
			for(int i = 1; i <= k; ++i)
			{
				eliminated = circle.poll();
				
				if(i == k)
				{
					System.out.println(eliminated + " is eliminated.");
					break;
				}
				// add the men that were not eliminated back to the queue
				circle.add(eliminated);
			}
		}
		
		System.out.println("The only survivor is: " + circle.peek());
	}
}