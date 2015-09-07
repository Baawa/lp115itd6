//Grupp 16, Kristoffer Ek, Albin Bååw
public class TestRse {
	
	static int [][] a = { {1, 2, 1, 2, 1, 2},
			 {4, 0, 0, 2, 2, 1},
			 {1, 1, 1, 1, 1, 4} };

	static int [][] b = { 	{1, 2, 3, 4},
	 		{5, 6, 7, 8},
	 		{1, 1, 1, 1} };
	
	public static void main(String[] args) {
		System.out.print(Rse.allRowSumsEqual(a));
		System.out.println();
		System.out.print(Rse.allRowSumsEqual(b));

	}

}
