
public class TestCounter{

	public static void main(String[] args) {
		CounterModel r1 = new CounterModel();
		CounterModel r2 = new CounterModel();
		CounterModel r3 = new CounterModel();
		CounterModel r1m4 = new CounterModel(4);
		CounterModel r2m4 = new CounterModel(4);
		CounterModel r3m4 = new CounterModel(4); 
		CounterModel r4 = r1;
		//inc och dec
		r1.increment();
		r1.decrement();
		r1.decrement();//borde ge 9
		r2.increment();
		r2.increment();//borde ge 2
		r3.increment();
		r3.increment();// borde ge 2
		//inc och dec på CounterModels med modulus=4
		r1m4.increment();
		r1m4.increment();
		r1m4.increment();
		r1m4.increment();//borde ge 0
		r2m4.decrement();//borde ge 3
		r3m4.increment();
		r3m4.decrement();//borde ge 0
		/*
		//getValue test
		System.out.println("r1= "+r1.getValue()+"\tBorde ge 9");
		System.out.println("r2= "+r2.getValue()+"\tBorde ge 2");
		System.out.println("r3= "+r3.getValue()+"\tBorde ge 2");
		System.out.println("r4= "+r4.getValue()+"\tBorde ge 9");
		System.out.println("r1m4= "+r1m4.getValue()+"\tBorde ge 0");
		System.out.println("r2m4= "+r2m4.getValue()+"\tBorde ge 3");
		System.out.println("r3m4= "+r3m4.getValue()+"\tBorde ge 0");
		System.out.println("Number of Counters= "+CounterModel.getNbrOfCounters()+"\tBorde ge 6");
		System.out.println();
		//Equals tester
		System.out.println("Equals tester:");
		System.out.println("Is r1 equal to r2? "+r1.equals(r2)+"\tBorde ge false");
		System.out.println("Is r2 equal to r3? "+r2.equals(r3)+"\t\tBorde ge true");
		System.out.println("Is r2 equal to r4? "+r2.equals(r4)+"\tBorde ge false");
		System.out.println("Is r1 equal to r4? "+r1.equals(r4)+"\t\tBorde ge true");
		System.out.println("Is r1m4 equal to r2m4? "+r1m4.equals(r2m4)+"\tBorde ge false");
		System.out.println("Is r2m4 equal to r3m4? "+r2m4.equals(r3m4)+"\tBorde ge false");
		System.out.println("Is r1m4 equal to r3m4? "+r1m4.equals(r3m4)+"\tBorde ge true");
		System.out.println();
		//toString Tester
		System.out.println("toString tester:");
		System.out.println("r1.toString= " + r1.toString());
		System.out.println("r2.toString= " + r2.toString());
		System.out.println("r1m4.toString= " + r1m4.toString());
		System.out.println("r2m4.toString= " + r2m4.toString());
	
		//Max-värde negativt TEST
		System.out.println();
		System.out.println("Test med negativt max-värde som input:");
		try{
			CounterModel rNeg = new CounterModel(-5);
		}catch(IllegalArgumentException e){System.out.println(e);}
		*/
		
		//TEST med ett fält med Counters
		CounterModel[] arr = {new CounterModel(60),
							new CounterModel(50),
							new CounterModel(40),
							new CounterModel(30),
							new CounterModel(20),
							new CounterModel(8)};
		
		System.out.println("Test av fält med 6 st Counters");
		for(int i=0;i<arr.length;i++){
			for(int x=0;x<35;x++){
				arr[i].increment();
			}
		}
		System.out.println("Varje Counter ökar med 35");
		System.out.println("Utskrift av varje Counter:");
		for(int i=0;i<arr.length;i++){
			System.out.println("Element nummer "+i+"= "+arr[i].toString());
		}
		
		FastCounter fc = new FastCounter(15,5);
		System.out.println(fc.toString());
		
		fc.upMany(6);
		System.out.println(fc.toString());
		System.out.println(fc.getStep());
		
	}
		public void changeCounter(CounterModel c){
			c.increment();
		}

}
