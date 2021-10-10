/**
 * Square.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of Keiran Hughes
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding square.
 */

public class Square extends ClosedShape {
	//The length of the square.
	private int length;
	
	/**
     * Creates a square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The length of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
	public Square (int insertionTime, int x, int y, int vx, int vy, int length, Color colour, boolean isFilled) {
		super (insertionTime, x, y, vx, vy, colour, isFilled);
		this.length = length;
	}
	
	/**
     * Method to convert a square to a string.
     */
	public String toString () {
    	String result = "This is a square\n";
    	result += super.toString ();
	result += "Its length is " + this.length + "\n";
    	return result;
	}
	
	/**
	 * @param length Resets the length.
	 */
	public void setLength (int length) {
    	this.length = length;
    }
	
	/**
 	 * @return The width of the square.
 	 */
	public int getWidth() {
		return length;
	}

 	/**
 	 * @return The height of the square.
 	 */
 	public int getHeight() {
		return length;
	}
 	
 	/**
 	 * Draw the square.
 	 * @param g The graphics object of the drawable component.
 	 */
 	public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect( xPos, yPos, length, length );
    	} 
    	else {
    		g.strokeRect( xPos, yPos, length, length );
	    }
    }
}
