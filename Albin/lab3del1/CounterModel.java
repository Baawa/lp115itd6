package lab3del1;

public class CounterModel {
	private int maxVal = 99;
	private int num = 0;
	private static int nbrofc = 0;

	public CounterModel(){
		nbrofc++;
	}
	
	public CounterModel(int maxValue){
		if (maxValue < 0) throw new IllegalArgumentException();
		nbrofc++;
		this.maxVal = maxValue;
	}
	
	public void increment(){
		this.num = ((this.num+1)%this.maxVal);
	}
	
	public void decrement(){
		this.num--;
		if (this.num < 0) this.num = this.maxVal-1;
	}
	
	public void reset(){
		this.num = 0;
	}
	
	public int getValue(){
		return this.num;
	}
	
	public int getMaxValue(){
		return this.maxVal;
	}
	
	public int getNbrOfCounters(){
		return nbrofc;
	}
	
	public String toString(){
		return (this.num + " / " + this.maxVal);
	}
	
	public boolean equals(Object obj){
		if (obj.getClass() == this.getClass()){
			CounterModel cm = (CounterModel)obj;
			if (cm.getValue() == this.getValue() && cm.getMaxValue() == this.getMaxValue()) return true;
		}
		return false;
	}
}
