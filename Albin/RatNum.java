package lab2del2;

public class RatNum {
	String rnum;
	
	public RatNum(){
		rnum = "0/1";
	}
	
	public RatNum(int a){
		rnum = a + "/1";
	}
	
	public RatNum(int a, int b){
		if (b==0) throw new NumberFormatException("Denominator = 0");
		int divisor = new RatNum().gcd(a, b);
		if (b < 0) {
			a = a / -1;
			b = b / -1;
		}
		rnum = (a/divisor) + "/" + (b/divisor);
	}
	
	public RatNum(RatNum r){
		rnum = r.rnum;
	}
	
	public int getNumerator() {
		return Integer.valueOf(rnum.substring(0, rnum.indexOf("/")));
	}
	
	public int getDenominator() {
		return Integer.valueOf(rnum.substring(rnum.indexOf("/") + 1));
	}
	
	public static int gcd(int m, int n){
		if (n == 0 && m == 0) throw new IllegalArgumentException();
		if (n == 0){
			if (m<0) return (m/-1);
			else return m;
		}
		
		while (true){
			int r = m%n;
			if (r == 0){
				if (n < 0) return (n/-1);
				else return n;
			}
			else{
				m = n;
				n = r;
			}
		}
	}
}
