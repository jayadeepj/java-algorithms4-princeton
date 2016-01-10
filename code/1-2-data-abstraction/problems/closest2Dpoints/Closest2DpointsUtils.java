
public class Closest2DpointsUtils {
	
	public static void visualizeN2Dpoints(Point2D[] nPointArray)
	{
		System.out.print("\nGenerated points == > ");
		for (int i = 0; i < nPointArray.length; i++) {
			Point2D point2d = nPointArray[i];
			System.out.print(point2d.toString());
			point2d.draw();
		}
	}

	public static void initializeVisualizationParams()
	{
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 200);
		StdDraw.setYscale(0, 200);
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor(StdDraw.RED);
	}
	public static void visualizeClosestPair(Point2D[] closestPair)
	{
		StdDraw.setPenRadius(.001);
		StdDraw.setPenColor(StdDraw.BLACK);
		closestPair[0].drawTo(closestPair[1]);
	}


}
