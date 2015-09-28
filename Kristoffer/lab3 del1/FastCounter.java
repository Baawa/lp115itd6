
public class FastCounter extends CounterModel implements CounterInterface{
	
	private int steps;
	public FastCounter(int modulus, int steps){
		super.modulus = modulus;
		this.steps = steps;
		if(steps<0){
			for(int i = 0;i<steps;i++){
				this.decrement();
			}
		}else{
			for(int i = 0;i<steps;i++){
				this.increment();
			}
		}
	}
	
	public void upMany(int steps){
		this.steps = steps;
		for(int i=0;i<steps;i++){
			this.increment();
		}
	}
	
	public void downMany(int steps){
		this.steps = steps;
		for(int i=0;i<steps;i++){
			this.decrement();
		}
	}
	
	public int getStep(){
		return steps;
	}
	
	public String toString(){
		return "Counter is: " + this.getValue() + " Modulus is: " + this.getModulus() + " Last step is: " + this.getStep();
	}
}
