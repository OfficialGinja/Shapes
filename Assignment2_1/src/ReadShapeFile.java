
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {
	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.



	/**
	 * Reads the data file used by the program and returns the constructed queue
	 *
	 * @param in the scanner of the file
	 *           
	 * @return the queue represented by the data file
	 */
	private static Queue readDataFile(Scanner in) {		
		Queue shapeQueue = new Queue();
		while (in.hasNextLine ()) {
			String curLine = in.nextLine();
			Scanner line = new Scanner(curLine);
			switch (line.next()) {
				case "circle":
					shapeQueue.enqueue(readCircle(line));
					break;
				case "oval":
					shapeQueue.enqueue(readOval(line));
					break;
				case "square":
					shapeQueue.enqueue(readSquare(line));
					break;
				case "rect":
					shapeQueue.enqueue(readRect(line));
					break;
				case "arc":
					shapeQueue.enqueue(readArc(line));
					
					break;
			}
			line.close();
		}
		//read in the shape files and place them on the Queue
		return shapeQueue;
	}
	/**
 	 * Creates and prints a circle.
 	 * @param in Input from the opened file.
 	 */
	private static Circle readCircle(Scanner in) {
		int positionX = in.nextInt ();
		int positionY = in.nextInt ();
		int velocityX = in.nextInt ();
		int velocityY = in.nextInt ();
		boolean filled = in.nextBoolean();
		int diameter = in.nextInt();
		Color shapeColour = Color.rgb(in.nextInt (),in.nextInt (),in.nextInt ());
		int insertionTime =  in.nextInt ();
		Circle circle = new Circle(insertionTime,positionX,positionY,velocityX,velocityY,diameter,shapeColour,filled);
		System.out.println(circle);
		return circle;
	}
	/**
 	 * Creates and prints an oval.
 	 * @param in Input from the opened file.
 	 */
	private static Oval readOval(Scanner in) {
		int positionX = in.nextInt ();
		int positionY = in.nextInt ();
		int velocityX = in.nextInt ();
		int velocityY = in.nextInt ();
		boolean filled = in.nextBoolean();
		int shapeWidth = in.nextInt();
		int shapeHeight = in.nextInt();
		Color shapeColour = Color.rgb(in.nextInt (),in.nextInt (),in.nextInt ());
		int insertionTime = in.nextInt();
		Oval oval = new Oval(insertionTime,positionX,positionY,velocityX,velocityY,shapeWidth,shapeHeight,shapeColour,filled);
		System.out.println(oval);
		return oval;
	}
	/**
 	 * Creates and prints a square.
 	 * @param in Input from the opened file.
 	 */
	private static Square readSquare(Scanner in) {
		int positionX = in.nextInt ();
		int positionY = in.nextInt ();
		int velocityX = in.nextInt ();
		int velocityY = in.nextInt ();
		boolean filled = in.nextBoolean();
		int diameter = in.nextInt();
		Color shapeColour = Color.rgb(in.nextInt (),in.nextInt (),in.nextInt ());
		int insertionTime =  in.nextInt ();
		Square square = new Square(insertionTime,positionX,positionY,velocityX,velocityY,diameter,shapeColour,filled);
		System.out.println(square);
		return square;
	}
	/**
 	 * Creates and prints a rectangle.
 	 * @param in Input from the opened file.
 	 */
	private static Rect readRect(Scanner in) {
		int positionX = in.nextInt ();
		int positionY = in.nextInt ();
		int velocityX = in.nextInt ();
		int velocityY = in.nextInt ();
		boolean filled = in.nextBoolean();
		int shapeWidth = in.nextInt();
		int shapeHeight = in.nextInt();
		Color shapeColour = Color.rgb(in.nextInt (),in.nextInt (),in.nextInt ());
		int insertionTime = in.nextInt();
		Rect rect = new Rect(insertionTime,positionX,positionY,velocityX,velocityY,shapeWidth,shapeHeight,shapeColour,filled);
		System.out.println(rect);
		return rect;
	}
	/**
 	 * Creates and prints an arc.
 	 * @param in Input from the opened file.
 	 */
	private static Arc readArc(Scanner in) {
		int positionX = in.nextInt ();
		int positionY = in.nextInt ();
		int velocityX = in.nextInt ();
		int velocityY = in.nextInt ();
		boolean filled = in.nextBoolean();
		int shapeWidth = in.nextInt();
		int shapeHeight = in.nextInt();
		int startAngle = in.nextInt();
		int arcExtent = in.nextInt();
		String arcType = in.next();
		Color shapeColour = Color.rgb(in.nextInt (),in.nextInt (),in.nextInt ());
		int insertionTime = in.nextInt();
		Arc arc = new Arc(insertionTime,positionX,positionY,velocityX,velocityY,shapeWidth,shapeHeight,startAngle,arcExtent,arcType,shapeColour,filled);
		System.out.println(arc);
		return arc;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 *
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue readFile(String filename) {
	    // HINT: You might want to open a file here.
		File inputFile = new File (filename);
	    Scanner in = null; //null is not sensible. Please change
	    try {
	    	in = new Scanner (inputFile);
	    }
	    catch (FileNotFoundException e) {
			System.out.println("Cannot open File");
			System.exit (0);
		}
	    return ReadShapeFile.readDataFile(in);

	}
}
