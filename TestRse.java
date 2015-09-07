public class TestRse{
	
	public static void main(String[] args){
		//True
		int[][] aa = {{1,2,3,4,5,6,7},
						{1,2,4,21},
						{7,21},
						{1,2,3,4,5,6,7},
						{1,2,4,21},
						{7,21}};
		
		//False
		int[][] ab = {{1,2},{3,4}};
		
		//True
		int[][] ac = {{1,2,-1}, {2}};
		
		//True
		int[][] ad = null;
		
		//False
		int[][] ae = {{1,0,2,7,-1}, null, {1,2,3,4}};
		
		//True
		int[][] af = {{}};
		
		//True
		int[][] ag = {{4,5,1}};
		
		//False
		int[][] ah = {{0, -1, -3, 500}, {}, {}, null, {4,5,6}};
		
		TestRse tester = new TestRse();
		
		Boolean isAlright = true;
		Boolean tmp;
		
		tmp = tester.testFunction(aa, true);
		isAlright = isAlright && tmp;
		
		tmp = tester.testFunction(ab, false);
		isAlright = isAlright && tmp;
		
		tmp = tester.testFunction(ac, true);
		isAlright = isAlright && tmp;
		
		tmp = tester.testFunction(ad, true);
		isAlright = isAlright && tmp;
		
		tmp = tester.testFunction(ae, false);
		isAlright = isAlright && tmp;
		
		tmp = tester.testFunction(af, true);
		isAlright = isAlright && tmp;
		
		tmp = tester.testFunction(ag, true);
		isAlright = isAlright && tmp;
		
		tmp = tester.testFunction(ah, false);
		isAlright = isAlright && tmp;
		
		if (isAlright){
			System.out.println("Rse Passed");
		}
		else System.out.println("Rse didn't pass");
	}
	
	private static boolean testFunction(int[][] m, boolean c) {
			//Check the value of the matrix and compare to the given bool
			//Return the correct bool
			boolean tmp = new Rse().allRowSumsEqual(m);
			if (tmp == c){
				return true;
			}
			else return false;
		}
}