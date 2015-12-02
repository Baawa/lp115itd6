package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends AbstractForm {

	public Oval(int x, int y, int width, int height, Color c) 
			throws IllegalPositionException{
		super(x,y,width,height,c);
	}
	
	public Oval(GeometricalForm f, int width, int height, Color c){
		super(f,width,height,c);
	}
	
	@Override
	public int getArea() { return (int) (Math.PI*this.getWidth()/2*this.getHeight()/2); }

	@Override
	public void fill(Graphics g) { g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight()); }

	@Override
	public int getPerimeter() { 
		return (int)(2*Math.PI*(Math.sqrt((Math.pow(this.getWidth(), 2)+Math.pow(this.getWidth(), 2))/2)));
	}
}