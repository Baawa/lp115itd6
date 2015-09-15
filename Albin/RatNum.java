package lab2del2;

import java.util.Scanner;

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
	
	public RatNum(String r){
		rnum = this.parse(r).rnum;
	}
	
	public int getNumerator() {
		return Integer.valueOf(rnum.substring(0, rnum.indexOf("/")));
	}
	
	public int getDenominator() {
		return Integer.valueOf(rnum.substring(rnum.indexOf("/") + 1));
	}
	
	public String toString(){
		return rnum;
	}
	
	public double toDouble(){
		return (double)this.getNumerator() / this.getDenominator();
	}
	
	public static RatNum parse(String str){
		//if str contains / pick out the denominator and the Numerator and return, else return blank
		if (str.contains("/")){
			//Add whitespaces to string for scanner being able to do "nextInt"
			str = new StringBuilder(str).insert((str.indexOf("/")), " ").toString();
			str = new StringBuilder(str).insert((str.indexOf("/") + 1), " ").toString();
			Scanner scan = new Scanner(str);
			int t = scan.nextInt();
			scan.next(); //Skip the "/"
			int n = scan.nextInt();
			return new RatNum(t,n);
		}else throw new NumberFormatException("Incorrect input.");
	}
	
	public boolean equals(Object r){
		if (r == null) return false;
		
		if (r instanceof RatNum){
			RatNum rat = (RatNum) r;
			if (rat.getDenominator() == this.getDenominator() && rat.getNumerator() == this.getNumerator()) return true;
			else return false;
		}
		else return false;
	}
	
	public Boolean lessThan(RatNum r){
		if ((this.getNumerator()/this.getDenominator()) < (r.getNumerator()/r.getDenominator())) return true;
		else return false;
	}
	
	public RatNum add(RatNum r){
		int numerator = (this.getNumerator() * r.getDenominator()) + (r.getNumerator() * this.getDenominator());
		int denominator = (this.getDenominator() * r.getDenominator());
		return new RatNum(numerator, denominator);
	}
	
	public RatNum sub(RatNum r){
		int numerator = (this.getNumerator() * r.getDenominator()) - (r.getNumerator() * this.getDenominator());
		int denominator = (this.getDenominator() * r.getDenominator());
		return new RatNum(numerator, denominator);
	}
	
	public RatNum mul(RatNum r){
		int numerator = (this.getNumerator() * r.getNumerator());
		int denominator = (this.getDenominator() * r.getDenominator());
		return new RatNum(numerator, denominator);
	}
	
	public RatNum div(RatNum r){
		int numerator = (this.getNumerator() * r.getDenominator());
		int denominator = (r.getNumerator() * this.getDenominator());
		return new RatNum(numerator, denominator);
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
