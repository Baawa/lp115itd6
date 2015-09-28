package lab3del1;

public class TestCounter {
	
	public static String incrementDecrementTest(){
		CounterModel cm = new CounterModel(60);
		boolean tmp = true;
		
		//Increment test
		while(cm.getValue() < 59){
			cm.increment();
		}
		tmp = tmp && (cm.getValue() == 59);
		cm.increment();
		tmp = tmp && (cm.getValue() == 0);
		
		//decrement test
		cm.decrement();
		tmp = tmp && (cm.getValue() == 59);
		for (int i = 0; i < 50; i++){
			cm.decrement();
		}
		tmp = tmp && (cm.getValue() == 9);
		
		if (tmp) return "Increment/decrement test passed!";
		return "Increment/decrement test failed!";
	}
	
	public static String equalsTest(){
		CounterModel cm = new CounterModel(50);
		boolean tmp = true;
		
		CounterModel dm = new CounterModel(50);
		tmp = tmp && cm.equals(dm);
		
		cm.increment();
		tmp = tmp && !cm.equals(dm);
		
		dm.increment();
		tmp = tmp && cm.equals(dm);
		
		CounterModel em = new CounterModel(60);
		cm.reset();
		tmp = tmp && !cm.equals(em);
		
		int[] f = {1,2,3,4};
		tmp = tmp && !cm.equals(f);
		
		if (tmp) return "Equals test passed!";
		return "Equals test failed!";
	}
	
	//Del(g)
	public static void delg(CounterModel cm){
		cm.increment();
		boolean tmp = true;

		System.out.println(cm.toString());
		for (int i = 2; i < cm.getMaxValue()+1; i++){
			cm.increment();
			System.out.println(cm.toString() + " \ti = " + i);
			if (i == cm.getMaxValue()) tmp = tmp && (cm.getValue() == 0);
			else tmp = tmp && (cm.getValue() == i);
		}
		
		if (tmp) System.out.println("Del(g) test passed!");
		else System.out.println("Del(g) test failed!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start test!");
		System.out.println(incrementDecrementTest());
		System.out.println(equalsTest());
		
		//Del (f)
		CounterModel[] cm = {new CounterModel(24), new CounterModel(60), new CounterModel(60)};
		for (int i = 0; i < 3600; i++){
			cm[2].increment();
			if (cm[2].getValue() == 0){
				cm[1].increment();
				if (cm[1].getValue() == 0){
					cm[0].increment();
				}
			}
			System.out.println(cm[0].getValue() + ":" + cm[1].getValue() + ":" + cm[2].getValue());
		}
		
		delg(new CounterModel(100));
		
		/*
		ChainedCounterModel hm = new ChainedCounterModel(0,100,null);
		ChainedCounterModel mm = new ChainedCounterModel(0,60,hm);
		ChainedCounterModel sm = new ChainedCounterModel(0,60,mm);
		for (int i = 0; i < 3600; i++){
			System.out.println(hm.getValue() + ":" + mm.getValue() + ":" + sm.getValue());
			sm.increment();
		}
		System.out.println(hm.getValue() + ":" + mm.getValue() + ":" + sm.getValue());
		*/
	}
	
}
