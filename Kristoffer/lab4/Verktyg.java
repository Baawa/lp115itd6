package newmemory;

import java.util.Random;

public class Verktyg {
	// SLUMPAR ORDNINGEN I GIVEN ARRAY
	public static void slumpOrdning(Object[] cards){
		Random rand = new Random();
		for (int j = 0; j < cards.length*2; j++){
			for (int i = 0; i < cards.length; i++){
				int randomNum = rand.nextInt(cards.length);
				Object[] temp = cards.clone();
				cards[randomNum] = cards[i];
				cards[i] = temp[randomNum];
				
			}
		}
	}
}