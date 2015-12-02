package geometri;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractForm implements GeometricalForm {

	private int x,y,height,width;
	private Color c;
	
	public AbstractForm(int x, int y, int width, int height, Color c) 
			throws IllegalPositionException{
		if(valueIsOk(x,y)){
			this.x = x;
			this.y = y;
		}else throw new IllegalPositionException();	
		if (valueIsOk(width,height)) {
			this.height = height;
			this.width = width;
		}else if (width<0)
		this.c = c;
	}
	
	public AbstractForm(GeometricalForm f, int width, int height, Color c){
		this.x = f.getX();
		this.y = f.getY();
		this.height = height;
		this.width = width;
		this.c = c;
	}
	
	@Override
	abstract public int getArea();

	@Override
	public int compareTo(GeometricalForm f) {
		int result = this.getArea()-f.getArea();
		if(result == 0){
			result=this.getPerimeter()-f.getPerimeter();
		}
		return result;
	}

	@Override
	abstract public void fill(Graphics g);
	@Override
	public Color getColor(){
		return this.c;
	}
	@Override
	public int getWidth(){
		return this.width;
	}
	@Override
	public int getHeight(){
		return this.height;
	}
	@Override
	public int getX(){
		return this.x;
	}
	@Override
	public int getY(){
		return this.y;
	}

	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		if(valueIsOk(x,y)){
			this.x=x+dx;
			this.y=y+dy;
		}
		else throw new IllegalPositionException();
	}

	@Override
	abstract public int getPerimeter();
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if(valueIsOk(x,y)){
			this.x=x;
			this.y=y;
		}
		else throw new IllegalPositionException();
	}
	public boolean valueIsOk(int x,int y){
		return (x>=0&&y>=0);
	}
	@Override
	public boolean equals(Object o){
		if(this == o)return true; 
		if(o == null) return false;
		AbstractForm a=(AbstractForm)o;
		if(this.hashCode() == a.hashCode())return true;
		return false;
		
	}
	
	@Override
	public int hashCode(){
		return this.getHeight() + this.getWidth() + this.getColor().getRGB();
	}
	
}
