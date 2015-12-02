package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Rectangle {

	public Square(int x, int y, int side, Color c) throws IllegalPositionException{
		super(x,y,side,side,c);
	}
	
	public Square(GeometricalForm f, int side, Color c){
		super(f,side,side,c);
	}
}
