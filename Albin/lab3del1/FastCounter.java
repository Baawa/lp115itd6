package lab3del1;

public class FastCounter extends CounterModel{
	private int step = 1;
	
	public FastCounter(int x){
		super(15);
		if (x < 1) throw new IllegalArgumentException("x can't be less than 1.");
		this.step = x;
	}
	
	public FastCounter(int x, int maxValue){
		super(maxValue);
		if (x < 1) throw new IllegalArgumentException("x can't be less than 1.");
		this.step = x;
	}
	
	public void upMany(){
		for (int i = 0; i < this.step; i++){
			this.increment();
		}
	}
	
	public void downMany(){
		for (int i = 0; i < this.step; i++){
			this.decrement();
		}
	}
	
	public int getStep(){
		return this.step;
	}
	
	public String toString(){
		return this.getValue() + " / " + this.getMaxValue() + " \t step = " + this.step;
	}
	
	public boolean equals(Object obj){
		if (obj.getClass() == this.getClass()){
			FastCounter cm = (FastCounter)obj;
			if (cm.getValue() == this.getValue() && cm.getMaxValue() == this.getMaxValue() && cm.getStep() == this.getStep()) return true;
		}
		return false;
	}
	
	

}
