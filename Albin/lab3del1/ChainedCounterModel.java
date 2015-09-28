package lab3del1;

public class ChainedCounterModel extends CounterModel{
	private CounterInterface nextCI;

	public ChainedCounterModel(int init, int modulus, CounterInterface next){
		super(modulus);
		
		//Set initial value
		for (int i = 0; i < init; i++){
			this.increment();
		}
		
		this.nextCI = next;
	}
	
	public void increment(){
		super.increment();
		if (this.getValue() == 0 && nextCI != null) nextCI.increment();
	}
}
