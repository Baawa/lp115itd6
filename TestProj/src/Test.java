import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean on = true;
		

		Random rand = new Random();
		int x = rand.nextInt(101);
		int guesses = 0;
		
		System.out.println("Choose a number between 1 and 100, if you guess right, you win!");
		System.out.println("Your number: ");
		
		while (on){
			
			Scanner in = new Scanner(System.in);
			
			int y = in.nextInt();
			
			guesses++;
			
			if (x == y){
				System.out.println("You win!");
				System.out.println("Number of guesses:" + guesses);
				break;
			}
			else{
				System.out.println("Wrong! Try again!");
				if (x > y){
					System.out.println("The number you want is higher");
				}
				else{
					System.out.println("The number you want is lower");
				}
			}
		}
		
	}

}
