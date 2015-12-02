package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends AbstractForm{

	private boolean isGoingUp;
	
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException{		
		// Skickar in: 
		// x - det minsta av x1,x2
		// y - det minsta av y1,y2
		// bredd - absolutbeloppet av skillnaden mellan x1,x2
		// höjd - absolutbeloppet av skillnaden mellan y1,y2
		// color - c
		super(Math.min(x1, x2),Math.min(y1, y2),Math.abs((x2-x1)),
				Math.abs(y2-y1),c);
		if(y2<y1){
			isGoingUp = true;
		}
		
	}
	
	public Line(GeometricalForm f1, GeometricalForm f2, Color c){
		// Skickar in: 
				// f - f1
				// bredd - absolutbeloppet av skillnaden mellan x1,x2
				// höjd - absolutbeloppet av skillnaden mellan y1,y2
				// color - c
				super(f1,Math.abs((f2.getX()-f1.getX())),
						Math.abs(f2.getY()-f1.getY()),c);
				if(f2.getY()<f1.getY()){
					isGoingUp = true;
				}
	}
	
	@Override
	public int getArea() { return 0; }

	@Override
	public void fill(Graphics g) {
		if(isGoingUp){
			g.drawLine(this.getX(), this.getY()+this.getHeight(),
					this.getX()+this.getWidth(), this.getY());
		}else 
			g.drawLine(this.getX(), this.getY(), 
				this.getX()+this.getWidth(), this.getY()+this.getHeight());
		}

	@Override
	public int getPerimeter() { return (int)(Math.sqrt(Math.pow(this.getWidth(), 2)+Math.pow(this.getHeight(), 2))); }
}
