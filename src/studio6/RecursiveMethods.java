package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {

		if(n==0) {
			return 0;
		}
		else{
			return Math.pow(0.5,n)+geometricSum(n-1);	
		}

	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {

		if(radius <= radiusMinimumDrawingThreshold) {
			return;
		}
		else {
			StdDraw.circle(xCenter, yCenter, radius);
			for(int i = 0; i<4; i++) {
				circlesUponCircles(xCenter+radius, yCenter, radius/3.0,radiusMinimumDrawingThreshold);
				circlesUponCircles(xCenter, yCenter+radius, radius/3.0,radiusMinimumDrawingThreshold);
				circlesUponCircles(xCenter-radius, yCenter, radius/3.0,radiusMinimumDrawingThreshold);
				circlesUponCircles(xCenter, yCenter-radius, radius/3.0,radiusMinimumDrawingThreshold);
			}
		}
	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {

		// FIXME create a helper method that can recursively reverse the given array
		int[] reversedArray = new int[array.length];
		if(array.length == 0) {
			return reversedArray;
		}
		else {
			return helper(array, reversedArray, 0);
		}
	}
	
	public static int[] helper(int[] array, int[] reversed, int n) {
		
		if(n>array.length/2){
			return reversed;
		}
		else {
			reversed[n] = array[array.length-1-n];
			reversed[array.length-1-n] = array[n];
			return helper(array, reversed, n+1);
		}
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {

		int lesser = 0;
		if(q<p)
		lesser = q;
		else
		lesser = p;
		if(q<1) {
			return 0;
		}
		else {
			return GCDhelper(p,q,lesser);
		}

	}
	
	public static int GCDhelper(int p, int q, int n) {
		if(p%n == 0 && q%n == 0) {
			return n;
		}
		else {
			return GCDhelper(p, q, n-1);
		}
	}

}
