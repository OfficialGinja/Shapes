
/**
 * Arc.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of Keiran Hughes
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 * Arc is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Arc's bounding rectangle.
 */

public class Arc extends ClosedShape {
	private int i = 0;
	//The width of the Arc
	private int width;
	//The height of the Arc
	private int height;
	//Angle at which the Arc starts to be drawn
	private int startAngle;
	//Angle at which the Arc stops being drawn
	private int arcExtent;
	//Type of Arc (open, chord or round) that is inputed
	private String inputArcType;
	//Type of Arc formatted to be readable by my program
	private ArcType realArcType;
	
	/**
     * Creates an Arc.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the Arc.
     * @param height The height of the Arc.
     * @param startAngle Angle which the Arc Starts.
     * @param arcExtent Angle to which the Arc extends.
     * @param inputArcType Type of the Arc
     * @param colour The line colour or fill colour.
     * @param isFilled True if the Arc is filled with colour, false if opaque.
     */
	public Arc (int insertionTime, int x, int y, int vx, int vy, int width, int height, int startAngle, int arcExtent, String inputArcType, Color colour, boolean isFilled) {
		super (insertionTime, x, y, vx, vy, colour, isFilled);
		this.width = width;
		this.height = height;
		this.startAngle = startAngle;
		this.arcExtent = arcExtent;
		this.inputArcType = inputArcType;
	}
	
	/**
     * Method to convert an arc to a string.
     */
	public String toString () {
    	String result = "This is an arc\n";
    	result += super.toString ();
    	result += "Its height is " + this.height + " and its width is " + this.width + "\nIts start angle is " + this.startAngle + " and its arc extent is " + this.arcExtent + "\n" + ""
			+ "Its type is " + this.inputArcType + "\n";
    	return result;
	}
	
	/**
	 * @param width Resets the width.
	 */
 	public void setWidth (int width) {
		this.width = width;
	}

 	/**
 	 * @param height Resets the height.
 	 */
 	public void setHeight (int height) {
		this.height = height;
	}
	
	/**
	 * @param width Resets the start angle.
	 */
 	public void setStartAngle (int startAngle) {
		this.startAngle = startAngle;
	}

 	/**
 	 * @param height Resets the arc extent.
 	 */
 	public void setArcExtent (int arcExtent) {
		this.arcExtent = arcExtent;
	}
 	
	/**
 	 * @param height Resets the arc type.
 	 */
 	public void setInputArcType (String inputArcType) {
		this.inputArcType = inputArcType;
	}

 	/**
 	 * @return The width of the arc.
 	 */
 	public int getWidth() {
		return width;
	}
 	
 	/**
 	 * @return The height of the arc.
 	 */
 	public int getHeight() {
		return height;
	}
 	
 	/**
 	 * @return The start angle of the arc.
 	 */
 	public int getStartAngle() {
		return startAngle;
	}

 	/**
 	 * @return The extend angle of the arc .
 	 */
 	public int getArcExtent() {
		return arcExtent;
	}

 	/**
 	 * @return The type of the arc.
 	 */
 	public String getInputArcType() {
		return inputArcType;
	}
 	
 	/**
 	 * Draw the arc.
 	 * @param g The graphics object of the drawable component.
 	 */
	public void draw (GraphicsContext g) {
		g.setFill (colour);
		g.setStroke( colour );
		/**
		 * Converts the input arc type to a usable arc type.
		 * @param inputArcType The type of arc as inputed.
		 */
		switch (inputArcType) {
			case "open":
				realArcType = ArcType.OPEN;
				break;
			case "chord":
				realArcType = ArcType.CHORD;
				break;
			case "round":
				realArcType = ArcType.ROUND;
		}
		if (isFilled) {
			g.fillArc( xPos, yPos, width, height, startAngle, arcExtent, realArcType );
		} 
		else {
			g.strokeArc( xPos, yPos, width, height, startAngle, arcExtent, realArcType );
		}
	}
}
