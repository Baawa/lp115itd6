//Grupp 16, Kristoffer Ek, Albin Bååw
public class Rse {
	static boolean isEqual=false;
	static int result=0;
	
	public static boolean allRowSumsEqual(int[][] m){
		if(m==null || m.length<=1) return true;
		
		int temp = rowSum(m[0]);
		
		for(int[] i : m){
			if(temp==rowSum(i)) isEqual=true;
			else return false;
		}
		return isEqual;
	}
	public static int rowSum(int[] v){
		result=0;
		if(v!=null){
		for(int num : v) {
			result += num;
		}
		}else return 0;
		return result;
	}
}