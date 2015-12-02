package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends AbstractForm {

	public Point(int x, int y, Color c) throws IllegalPositionException{
		super(x,y,1,1,c);
	}
	
	public Point(GeometricalForm f, Color c){
		super(f,1,1,c);
	}

	@Override
	public void fill(Graphics g) {
		g.drawLine(this.getX(), this.getY(), this.getX()+1, this.getY()+1);
	}

	@Override
	public int getPerimeter() {
		return 0;
	}

	@Override
	public int getArea() {
		return 0;
	}
	

}
