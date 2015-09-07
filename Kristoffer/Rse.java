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
}