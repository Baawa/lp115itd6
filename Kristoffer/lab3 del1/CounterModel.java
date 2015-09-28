
public class CounterModel implements CounterInterface {

	private int count = 0;
	private static int nbrOfCounters = 0;
	int modulus= 10;
	
	public CounterModel(){
		nbrOfCounters++;
		modulus = 10;
	}
	
	public CounterModel(int modulus){
		if(!(modulus<0)){
		this.modulus = modulus;
		nbrOfCounters++;
		}else throw new IllegalArgumentException("modulus is negative");
	}
	
	public void increment(){
		if(modulus!=10)count = (count+1) % modulus;
		else count++;
	}
		
	public void decrement(){
		count--;
		if(count<0)count=modulus-1;
	}
	
	public String toString(){
		String strCount = "Counter is: "+this.getValue()+ "\tModulus is: " + this.getModulus();
		return strCount;
	}
	
	public boolean equals(Object obj){
		if (this == obj) {
		return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof CounterModel) {
			CounterModel c = (CounterModel) obj;
			if (c.getValue()==this.getValue()) {
				return true;
			}
		}
		return false;
	}
	
	public void reset(){count=0;}
	public int getValue(){return count;}
	public static int getNbrOfCounters(){return nbrOfCounters;}
	public int getModulus(){return modulus;}
}
