package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends AbstractForm{

	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException{
		super(x,y,width,height,c);
	}
	
	public Rectangle(GeometricalForm f, int width, int height, Color c){
		super(f,width,height,c);
	}

	@Override
	public int getArea() {
		return (this.getWidth()*this.getHeight());
	}

	@Override
	public void fill(Graphics g) {
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public int getPerimeter() {
		return (this.getWidth()*2+this.getHeight()*2);
	}
}
