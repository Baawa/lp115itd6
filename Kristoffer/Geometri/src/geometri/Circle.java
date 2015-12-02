package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Oval{
	
	public Circle(int x, int y, int diameter, Color c) 
			throws IllegalPositionException{
		super(x,y,diameter,diameter,c);
	}
	
	public Circle(GeometricalForm f, int diameter, Color c){
		super(f,diameter,diameter,c);
	}

	@Override
	public int getPerimeter() {
		return (int)(Math.PI*this.getWidth());
	}
}
