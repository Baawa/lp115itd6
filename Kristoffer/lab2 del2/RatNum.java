package lab2;

public class RatNum {

	static int rest=0;
	int tx=0;
	int nx=0;
	
	public static int gcd(int t, int n){
		if(t==0 && n==0) throw new IllegalArgumentException();
		
		if(t<0) t=t/((-1)); // om t är negativ, gör positiv
		if(n<0) n=(n/(-1)); // om n är negativ, gör positiv
		
		while(true){
			if(t==0) return n;
			if(n==0) return t;
			rest = t % n;
			if(rest==0) return n;
			t=n;
			n=rest;
		}
	}
	public RatNum(){
		tx=0;
		nx=1;
	}
	public RatNum(int t){
		tx=(t/gcd(t,1));
		nx=(1/gcd(t,1));	
	}
	public RatNum(int t, int n){
		//om nämnare=0 throw
		if(n==0) throw new NumberFormatException("Denominator = 0"); 
		if(t<0 && n<0){ //om både t och n är -, gör båda +
			t=t/(-1);
			n=n/(-1);
		}
		if(n<0){// om endast n är -, gör t - och n +
			t=t/(-1); 
			n=n/(-1); 
		}
		tx=(t/gcd(t,n));
		nx=(n/gcd(t,n));
	}
	public RatNum(RatNum r){
		tx=r.tx;
		nx=r.nx;
	}
	public int getNumerator(){
		return tx;
	}
	public int getDenominator(){
		return nx;
	}
	//Overriding the toString of Object class
	@Override
	public String toString(){
		String result = tx+"/"+nx;
		return result;
	}
	public double toDouble(){
		double dresult = ((double)tx/(double)nx);
		return dresult;
	}
	public static RatNum parse(String s){
		int t,n;
		boolean isRat = false;
	
		if(s.contains("/")){
			String arr[] = s.split("/");
			if(arr.length<2){ throw new NumberFormatException("incorrect input");}
			t = Integer.parseInt(arr[0]);
			n = Integer.parseInt(arr[1]);
			isRat = true;
		}else if(!s.contains("/")){
			t = Integer.parseInt(s);
			n = 1;
			isRat = true;
		}else throw new NumberFormatException("incorrect input");
		if(isRat){
			if(t<0 || n<0){
				if(n<0){
					n = n/(-1);
					t = t/(-1);
				}
			}
			RatNum r = new RatNum(t,n);
			return r;
		}else throw new NumberFormatException("incorrect input");
	}
	public RatNum(String input){
		new RatNum(parse(input));	
	}
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
			} else if (obj == null) {
		            return false;
		        } else if (obj instanceof RatNum) {
		            RatNum rat = (RatNum) obj;
		            if (rat.getNumerator()==this.getNumerator() && 
		            		rat.getDenominator()==this.getDenominator()) {
		                return true;
		            }
		     }
		 return false;
		}
	public boolean lessThan(RatNum r){
		if(this.tx*r.nx<r.tx*this.nx){
			return true;
		}else return false;
	}
	public RatNum add(RatNum r){
		int newtx=this.tx*r.nx;
		int newtx2=r.tx*this.nx;
		int sumtx= newtx+newtx2;
		RatNum sumr = new RatNum(sumtx, (this.nx*r.nx));
		return sumr;
	}
	public RatNum sub(RatNum r){
		int diftx= (this.tx*r.nx)-(r.tx*this.nx);
		RatNum difr = new RatNum(diftx, (this.nx*r.nx));
		return difr;
	}
	public RatNum mul(RatNum r){
		RatNum pror = new RatNum((this.tx*r.tx), (this.nx*r.nx));
		return pror;
	}
	public RatNum div(RatNum r){
		RatNum kvoR = new RatNum((this.tx*r.nx), (this.nx*r.tx));
		return kvoR;
	}
}
