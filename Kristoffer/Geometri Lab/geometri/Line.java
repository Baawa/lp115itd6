package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends AbstractForm{

	boolean isGoingUp;
	
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{		
		super(getPos(x1, x2),getPos(y1,y2),Math.abs((x2-x1)),Math.abs((y2-y1)),c);
		System.out.println("x1,y1 "+x1 +" "+ y1 + "x2,y2 "+x2 +" "+ y2);
		
	}
	
	public Line(GeometricalForm f1, GeometricalForm f2, Color c){
		super(f1, Math.abs(f2.getX()-f1.getX()), Math.abs((f2.getY()-f1.getY())), c);
		if(f2.getY()<f1.getY()) isGoingUp =true;
	}

	public static int getPos(int z1, int z2){
		if (z1<=z2) return z1;
		else { 
			isGoingUp = true;
			return z2;
		}
	}
	
	@Override
	public int getArea() { return 0; }

	@Override
	public void fill(Graphics g) {
		if(isGoingUp){
			g.drawLine(this.getX(), this.getY()+this.getHeight(), this.getX()+this.getWidth(), this.getY());
			isGoingUp = false;
		}else g.drawLine(this.getX(), this.getY(), this.getX()+this.getWidth(), this.getY()+this.getHeight());
		}

	@Override
	public int getPerimeter() { return (int)(Math.sqrt(Math.pow(this.getWidth(), 2)+Math.pow(this.getHeight(), 2))); }
}
