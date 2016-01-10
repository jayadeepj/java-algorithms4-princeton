import java.util.Arrays;
import java.util.Random;


/**
 * @author jayadeepj
 * Closest 2D points in Cartesian plane (Divide & Conquer Algorithm)
 * 
 * The solution is implemented using 2 approaches
 * 
 * 1. Divide & Conquer Algorithm O(N log N)
 * 2. Brute Force  O(N^2)
 *
 */
public class Closest2Dpoints {

	private static Random random; 
	private static double closestPairDistance=Double.MAX_VALUE;

	public static void main(String[] args) {

		int N =50;
		Point2D[] nPointArray = generateNRandom2Dpoints(N);
		Closest2DpointsUtils.initializeVisualizationParams();
		Closest2DpointsUtils.visualizeN2Dpoints(nPointArray);
		
		System.out.println("\n*******************************************************************************************");
		Point2D[] closestPair= new Point2D[2]; 
		double minDistanceByBruteForce= findClosestPairDistance2(nPointArray, closestPair);
		
		System.out.print("\nClosest Pair distance By Brute Force == > "+minDistanceByBruteForce +" between ==>");
		for (int i = 0; i < closestPair.length; i++) {
			Point2D point2d = closestPair[i];
			System.out.print(point2d);

		}
		Closest2DpointsUtils.visualizeClosestPair(closestPair);
		System.out.println("\n*******************************************************************************************");

		closestPair = new Point2D[2];
		double minDistanceByDivideAndConquer= findClosestPairDistance1(nPointArray,closestPair);
		
		System.out.print("\nClosest Pair distance  By Divide & Conquer== > "+minDistanceByDivideAndConquer +" between ==>");
		for (int i = 0; i < closestPair.length; i++) {
			Point2D point2d = closestPair[i];
			System.out.print(point2d);

		}
		System.out.println("\n*******************************************************************************************");
	}

	/**
	 * Generate random points beween (0.0,0.0 to 20.0,20.0)
	 * Check for repetition of points (Just to avoid ugly scenarios!!)
	 * */

	public static Point2D[] generateNRandom2Dpoints(int N)
	{
		Point2D[] nPointArray = new Point2D[N];
		random = new Random();
		boolean isAlreadyExist = false;

		for (int i = 0; i < nPointArray.length; i++) {
			isAlreadyExist = false;
			Point2D newPoint2D= new Point2D(random.nextInt(200),random.nextInt(200));
			for (int j = 0; j < i; j++) {
				Point2D currentPoint2d = nPointArray[j];
				if((currentPoint2d.x()==newPoint2D.x())&&(currentPoint2d.y()==newPoint2D.y()))
				{
					isAlreadyExist = true;;
					break;
				}
			}

			if(!isAlreadyExist)
				nPointArray[i] = newPoint2D;
			else
				i--;
		}

		return nPointArray;
	}


	/**
	 * Divide & Conquer approach O(N log N)
	 * 
	 * Step 1: Sort the Array by X coordinate
	 * Step 2: Find the median index of x to divide the set by half
	 * Step 3: Divide the set into 2 sets P & Q in cartesian plane
	 *         i.e. points to the left of xmid and points to the right of xmid
	 * Step 4: delta = Min {ClosestPair(P),ClosestPair(Q)}
	 * Step 5: find pDeltaPointArray subset of P between  xmid-delta & xmid sorted by Y coordinate
	 * Step 6: find qDeltaPointArray subset of P between  xmid & xmid+delta  sorted by Y coordinate
	 * Step 7: for every point in pDeltaPointArray, find the closest point by Y coordinate in qDeltaPointArray
	 * Step 8: Extending Step 7 find the nearest possible 16 (can be 8 as well) by by Y coordinate in qDeltaPointArray
	 * Step 9: Take new delta = Min{ClosestPair(P),ClosestPair(Q),distance from  each point in pDeltaPointArray to each of the the nearest possible 16 in qDeltaPointArray}
	 * Step 10: return the new delta
	 * 
	 * **/

	public static double findClosestPairDistance1(Point2D[] nPointArray, Point2D[] closestPair)
	{

		Arrays.sort(nPointArray, Point2D.X_ORDER);

		if(nPointArray.length==2)
		{
			double distance = nPointArray[0].distanceTo(nPointArray[1]);
			if (distance<closestPairDistance)
			{
				closestPair[0] = nPointArray[0];
				closestPair[1] = nPointArray[1];
			}
			return distance;
		}
		else if(nPointArray.length<2)
			return Double.MAX_VALUE;

		int pLength = (int)nPointArray.length/2;
		int qLength = nPointArray.length - pLength ;
		Point2D[] pPointArray = new Point2D[pLength];
		Point2D[] qPointArray = new Point2D[qLength];

		double xmid = splitArrayByHalf(nPointArray, pPointArray, qPointArray);

		/* Recursive Call*/
		double delta = Math.min(findClosestPairDistance1(pPointArray,closestPair), findClosestPairDistance1(qPointArray,closestPair));

		Point2D[] pDeltaPointArray = fetchSortedSubsetByX(pPointArray, (xmid-delta), xmid);

		Point2D[] qDeltaPointArray = fetchSortedSubsetByX(qPointArray,  xmid, (xmid+delta));
		double tempDistance = 0.0;
		for (int i = 0; i < pDeltaPointArray.length; i++) {
			Point2D[] closest16PointArray = findClosest16AtOtherSideByY(pDeltaPointArray[i], qDeltaPointArray);

			for (int j = 0; j < closest16PointArray.length; j++) {
				Point2D closest16Point = closest16PointArray[j];
				tempDistance = closest16Point.distanceTo(pDeltaPointArray[i]);
				if(tempDistance< delta)
				{
					delta=tempDistance;
					if(delta<closestPairDistance)
					{
						closestPair[0] = pDeltaPointArray[i];
						closestPair[1] = closest16Point;
						
					}
				}
			}
		}

		if(delta<closestPairDistance)
			closestPairDistance = delta;
		
		

		return delta;

	}

	public static Point2D[] findClosest16AtOtherSideByY(Point2D selectedPoint2d,Point2D[] qDeltaPointArray)
	{
		double closestYcoordDistance = Double.MAX_VALUE;
		double yCoordDistance = 0.0;

		int closestPoint2dByYIndex = 0;

		for (int i = 0; i < qDeltaPointArray.length; i++) {
			Point2D point2d = qDeltaPointArray[i];
			yCoordDistance = Math.abs(point2d.y()-selectedPoint2d.y());
			if(yCoordDistance < closestYcoordDistance)
			{
				closestYcoordDistance = yCoordDistance;
				closestPoint2dByYIndex =i;
			}
		}

		/*Find the 8 data points on the up & down direction (Y coordinate) */
		int indexStart=((closestPoint2dByYIndex - 8)<=0) ? 0 :(closestPoint2dByYIndex - 8);
		int indexEnd = ((closestPoint2dByYIndex + 8)>=(qDeltaPointArray.length-1)) ?(qDeltaPointArray.length-1) :  (closestPoint2dByYIndex + 8);


		Point2D[] closest16PointArray = new Point2D[indexEnd-indexStart+1];


		int k=0;
		for (int i = indexStart; i <=indexEnd; i++) {
			closest16PointArray[k]= qDeltaPointArray[i];
			k++;
		}

		return closest16PointArray;

	}

	public static double splitArrayByHalf(Point2D[] nPointArray, Point2D[] pPointArray, Point2D[] qPointArray)
	{

		int pLength = 0;
		int qLength =0;

		for (int i = 0; i <nPointArray.length; i++) {
			Point2D point2d = nPointArray[i];
			if(i < (int)nPointArray.length/2)
			{
				pPointArray[pLength] = point2d;
				pLength++;
			}
			else
			{
				qPointArray[qLength] = point2d;
				qLength++;
			}
		}

		double xmid = (qPointArray[0].x()+pPointArray[pPointArray.length-1].x())/2;

		return xmid;
	}
	public static void splitArrayByX(Point2D[] nPointArray, double xmid, Point2D[] pPointArray, Point2D[] qPointArray  )
	{

		int pLength = 0;
		int qLength =0;

		for (int i = 0; i < nPointArray.length; i++) {
			Point2D point2d = nPointArray[i];
			if(point2d.x()<=xmid)
			{
				pPointArray[pLength] = point2d;
				pLength++;
			}
			else
			{
				qPointArray[pLength] = point2d;
				qLength++;
			}
		}
	}

	public static Point2D[] fetchSortedSubsetByX(Point2D[] nPointArray, double x1, double x2 )
	{
		int xSubsetLength = 0;
		for (int i = 0; i < nPointArray.length; i++) {
			Point2D point2d = nPointArray[i];
			if(point2d.x()>=x1 && point2d.x()<=x2 )
				xSubsetLength++;
		}

		Point2D[] xSubsetPointArray = new Point2D[xSubsetLength];
		xSubsetLength =0;

		for (int i = 0; i < nPointArray.length; i++) {
			Point2D point2d = nPointArray[i];
			if(point2d.x()>=x1 && point2d.x()<=x2 )
			{
				xSubsetPointArray[xSubsetLength] = point2d;
				xSubsetLength++;
			}
		}
		Arrays.sort(xSubsetPointArray, Point2D.Y_ORDER);
		return xSubsetPointArray;

	}

	/*Brute -Force approach  O(N^2) */
	public static double findClosestPairDistance2(Point2D[] nPointArray,Point2D[] closestPair)
	{
		closestPair[0] = nPointArray[0];
		closestPair[1] = nPointArray[1];

		for (int i = 0; i < nPointArray.length-1; i++) {
			for (int j = i+1; j < nPointArray.length ; j++) {

				Point2D point1 = nPointArray[i];
				Point2D point2 = nPointArray[j];

				if(point1.distanceTo(point2) < closestPair[0].distanceTo(closestPair[1]) )
				{
					closestPair[0] = point1;
					closestPair[1] = point2;
				}
			}
		}

	
		return closestPair[0].distanceTo(closestPair[1]);
	}



}

