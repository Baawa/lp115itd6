//Grupp 16, Kristoffer Ek, Albin Bååw
public class Rse {
	static int sum=0;
	static boolean isEqual=false;
	static int row[];
	static int temp=0;
	
	public static boolean allRowSumsEqual(int[][] m){
		for(int i=0;i<m.length;i++){
			row=null;
			row= m[i];
			if(temp==rowSum(row)){
				isEqual = true;
			}else{
				isEqual = false;
			}
			temp=rowSum(row);
		}
		return isEqual;
	}
	public static int rowSum(int[] v){
		sum=0;
		if(row==null){
			sum=0;
		}else{
		for(int numb : row){
		sum+=numb;
		}
		}
		return sum;
	}
	
	static void print(int[][] m) {
		if ( m==null ) {
			System.out.print("[ null ]");
		} else if ( m.length == 0 ) {
			System.out.print("[ - ]");
		} else {
			System.out.print("[ ");
			for ( int row=0; row<m.length; row++ ) {
				if ( m[row]==null ) {
					System.out.print("null ");
				} else {
					System.out.print("{ ");
					if ( m[row].length == 0 ) {
						System.out.print("- ");
					} else {
						for ( int col=0; col<m[row].length; col++ ) {
							System.out.print( m[row][col] + " " ) ;
						}
					}
					System.out.print("} ");
				}
			}
			System.out.print("]");
		}
	}
}