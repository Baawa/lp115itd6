public class Rse{
	
	public static void main(String[] args){
	}
	
	public static boolean allRowSumsEqual(int[][] m){
		if (m == null) return true;
		
		int result = 0;
		for (int i = 0; i < m.length; i++){
			int r1 = new Rse().rowSum(m[i]);
			if ((result == (r1 * i))){
				result = result + r1;
			}
			else return false;
		}
		return true;
	}
	public static int rowSum(int[] v){
		if (v == null) return 0;
		
		int l = v.length;
		int result = 0;
		
		for (int i = 0; i < l; i++){
			if ((int)(v[i]) != 0){
			result = result + (int)(v[i]);
			}
		}
		
		return result;
	}
}