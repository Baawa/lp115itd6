package lab2;
import java.io.*;
import java.util.*;
// modifierad 2011-09-18 EH
class RatNumTest3 {

	public static String ratNumToString(RatNum r) {
		int num = r.getNumerator();
		int denom = r.getDenominator();
		if (num == 0) {
			return "0";
		}
		String s = "";
		int whole = num / denom;
		int fraction = num % denom;
		if (whole != 0) {
			s = whole + " ";
			fraction = Math.abs(fraction);
		}
		if (fraction != 0)
			s =  s + fraction + "/" + denom;
		return s;
	}


	private static void divTester() {
		// Testar equals och clone
		RatNum x = new RatNum(6,2);
		RatNum y = new RatNum(0);
		RatNum z = new RatNum(0,1);
		RatNum w = new RatNum(75,25);  
		Object v = new RatNum(75,25); 
		String str = new String("TEST");

		System.out.println();
		System.out.println(">>>> Test av equals: Vi har inte gått igenom equals ännu ");
		System.out.println("så du behöver inte klara dessa tester än");
		//System.out.println("equals test 1 ");
		if (x.equals(y) || !y.equals(z) || !x.equals(w)) {
			System.out.println("RatNumTest3: FEL 1 i equals!!");
		}
		//System.out.println("equals test 2 ");
		if ( !w.equals(v)  ) { //  w skall vara lika med v
			// med equals(RatNum r) så väljs dock objects equals
			// eftersom parameterprofilen stämmer där och då blir dom olika
			System.out.println("RatNumTest3: FEL 2 i equals!!");
		}
		//.out.println("equals test 3 ");
		if ( !v.equals(w) ) { // dyn. bindningen ger RatNums equals
			// men med equals(RatNum r) så blir det som ovan
			System.out.println("RatNumTest3: FEL 3 i equals!!");
		}
		//.out.println("equals test 4 ");
		try {
			if ( w.equals(null)  ) { //skall inte vara lika
				System.out.println("RatNumTest3: FEL 4.1 i equals!!");
			}
		} catch (NullPointerException e) { // men skall klara null
			System.out.println("RatNumTest3: FEL 4.2 i equals!!");
		}
		//System.out.println("equals test 5 ");
		if ( w.equals(str) ) { // skall ge false
			// med equals(RatNum r) får man återigen Objects equals
			// och den ger rätt svar här
			System.out.println("RatNumTest3: FEL 5 i equals!!");
		}	
		System.out.println("<<<< Slut på equals tester");
		/*
		try {
			y = (RatNum) x.clone();
		}
		catch (Exception ce) {}
		if (!y.equals(x) || y==x)
			System.out.println("RatNumTest3: FEL I clone!!");
		*/
		// Testar toDouble         
		for (int i=1; i<=9; i++) {
			for (int j=0; j <= 2*i; j++) {
				if( Math.abs(new RatNum(j, i).toDouble() - (double)j/i) > 1.0e-13) {
					System.out.println("RatNumTest3: FEL i toDouble!! för " + j + "/" + i);
				}
			}
		}  
	} // end divTester

	public static String testExpr(String s) {
		// @require s.length > 0
		//String result = "";
		Scanner sc = new Scanner(s);
		String[] a = new String[3];
		int i;
		for(i=0; i<3 && sc.hasNext(); i++) {
			a[i] = sc.next();
			System.out.println(a[i]);
		}
		if (i != 3 || sc.hasNext())  
			return("Felaktigt uttryck!");
		else {
			try {            
				RatNum r1 = RatNum.parse(a[0]);
				String op = a[1];
				char c = op.charAt(0);
				RatNum r2 = RatNum.parse(a[2]);
				if (op.length() != 1 || "+-*/=<".indexOf(c) < 0)
					return("Felaktig operator!");
				else {
					RatNum res = null;
					if (c == '+'){
						res = r1.add(r2);}
					else if (c == '-')
						res = r1.sub(r2);
					else if (c == '*')
						res = r1.mul(r2);
					else  if (c == '/')
						res = r1.div(r2);
					else if (c == '=')
						return( Boolean.toString(r1.equals(r2)) );
					else if (c == '<')
						return( Boolean.toString(r1.lessThan(r2)) );
					if ("+-*/".indexOf(c) >= 0) 
						if (res == null)
							return("Fel i add, sub, mul eller div");
					else        
						return(res.toString());
				}
			}
			catch (NumberFormatException e) {
				return("NumberFormatException: " + e.getMessage());
			}         
		}
		return ("Okänt fel");
	} // end testExpr


	public static void main(String[] arg) throws IOException {
		RatNumTest2.divTester();
		divTester();
		StringBuilder stringToPrint;
		String correctAnswer;
		// om det finns argumet så är det testfilen => auto test
		boolean machine; // keep track of if testing is human or machine
		String filename = "";
		Scanner in;
		//System.exit(0); // debug
		if (arg.length > 0) {
			machine = true;
			filename = arg[0];
			in = new Scanner(new File(filename));
			System.out.println("automatic testing - reading " + filename);
			System.out.println("given expression\t given result");
		} else {
			machine = false;
			in = new Scanner(System.in);
			System.out.println("Skriv uttryck på formen a/b ? c/d, där ? är något av tecknen + - * / = <");
		}
		// read input
		while (true) {
			if (!machine) {System.out.print("> ");  System.out.flush();}
			if (machine && !in.hasNext() ) {System.exit(0);} // no input left
			String s = in.nextLine();
			if ( s == null || s.length()==0 ) {
				break;
			}
			correctAnswer = "";
			stringToPrint = new StringBuilder();
			if (machine) {
				// split input in question - correct answer
				int i = s.indexOf("-->");
				if (i<1) {
					System.out.println("##### Error - No answers found in file - cannot correct");
					System.exit(0);
				}
				correctAnswer = s.substring(i+4);
				s = s.substring(0,i);
				System.out.println("\t##s= " + s + "* correct answer=" + correctAnswer + " debug"); // debug
			}
			String givenAnswer = testExpr(s);
			stringToPrint.append(s + "\t--> " + givenAnswer );
			if (machine && !correctAnswer.equals(givenAnswer)) {
				//System.out.println( "====================================================" );
				//System.out.println("\t##*"+givenAnswer+"* " + "*"+correctAnswer+ "*" + ratNumToString(new RatNum(givenAnswer)) + "* debug"); // debug
				// test if answer given as a/B +
				// strängen till NumberFormatException kan vara olika
				if ( correctAnswer.equals(ratNumToString(new RatNum(givenAnswer)))
					|| ( correctAnswer.indexOf("NumberFormatException") != -1  
						 && givenAnswer.indexOf("NumberFormatException") != -1 ) 
					) {
					; // do nothing
				} else {
					stringToPrint.append(" ###### Error, correct answer is= " + correctAnswer);
				}
			}
			System.out.println(stringToPrint.toString());
		} // end while
	} // end main
} // end RatNumTest3
