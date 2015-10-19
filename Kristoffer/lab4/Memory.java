package newmemory;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.Random;
//Klass med ActionListener för om ett nytt eller avsluta klickas
class ButtonListener implements ActionListener{
	private Memory game;
	public ButtonListener(Memory gem){
		this.game = gem;
	}
	public void actionPerformed(ActionEvent e){
		String str = e.getActionCommand();
		if (str.equals("newgame")){ //nytt klickas
			this.game.randomRAndC();
			this.game.nyttSpel();
			this.game.resetBoard();
		}
		if (str.equals("endgame")){ // avsluta klickas
			System.exit(0);
		}
	}
}
// Klass med ActionListener för om ett kort klickas
class CardListener implements ActionListener{
	public static int count = 0; // håller reda på antal kort som klickas
	private Kort prevcard; // håller det föregående klickade kortet
	private Memory game;
	public CardListener(Memory gem){ // Konstruktor
		this.game = gem;
	}

	// om ett kort klickas körs nedanstående
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		// KORT 1 AV 2 KLICKAS
		if (count == 0){
			if (source instanceof Kort) {
				prevcard = (Kort) source;
				prevcard.setIcon(prevcard.icon);
				count = 1; 	// öka counter
				return;
			}
		}
		// KORT 2 AV 2 KLICKAS OCH DET EJ ÄR SAMMA SOM KORT 1 AV 2
		// SAMT ATT 3 ST KORT INTE HAR KLICKATS
		if (count == 1 && e.getSource() != prevcard){
			Kort lastcard = (Kort) source;
			lastcard.setIcon(lastcard.icon);
			count = 2;
			// KOLLAR IFALL DE KLICKADE KORTEN HAR SAMMA BILD
			if (lastcard.sammaBild(prevcard)){
				prevcard.setVisible(false);
				lastcard.setVisible(false);
				prevcard.setOpaque(true);
				lastcard.setOpaque(true);
				lastcard.setBackground(Color.WHITE);
				prevcard.setBackground(Color.WHITE);
				lastcard.removeActionListener(this);
				prevcard.removeActionListener(this);
				// POÄNG GES TILL RÄTT SPELARE
				if (game.getPlayer() == Memory.Spelare.PLAYER1){
					game.p1points += 1;
					game.p1plabel.setText("" + game.p1points);
				}
				if (game.getPlayer() == Memory.Spelare.PLAYER2){
					game.p2points += 1;
					game.p2plabel.setText("" + game.p2points);
				}
				game.deccards();
				if (game.getcards() == 0){ // kollar ifall spelet är slut
					String stri;
					if (game.p2points < game.p1points) {
						stri = "Spelare 1 har vunnit!";
					}
					else  stri = "Spelare 2 har vunnit!";
					Object[] options = {"Nej.",
                    "Ja."};
					// FRÅGA IFALL MAN VILL SPELA IGEN
					int n = JOptionPane.showOptionDialog(game.f,
					"Grattis!\n" + stri + "\n Vill ni spela igen?",
					"Nytt SPEL???",
    			JOptionPane.YES_NO_CANCEL_OPTION,
    			JOptionPane.QUESTION_MESSAGE,
    			null,
    			options,
    			options[1]);
					System.out.println("" + n);
					if (n == 0) System.exit(0);
					if (n == 1){ // STARTAR NYTT SPEL IFALL JA
						this.game.randomRAndC();
						this.game.nyttSpel();
						this.game.resetBoard();
					}
				}
			}
			new Timer(1500, new ActionListener(){ // TIMER
	  		public void actionPerformed(ActionEvent evt) {
				// OM DET INTE ÄR SAMMA KORT SÅ VISA BÅDA KORTEN I 1,5 SEK	
	  			if (!lastcard.sammaBild(prevcard)){
						lastcard.setEnabled(true);
						prevcard.setEnabled(true);
						game.changePlayer();
					}
					lastcard.setIcon(null);
					prevcard.setIcon(null);
					count = 0; // ÅTERSTÄLLER COUNTER

	    		((Timer) evt.getSource()).stop();
	  		}
			}).start(); // STARTAR TIMER
		}
	}
}


public class Memory {
	public enum Spelare {PLAYER1, PLAYER2}
	public Spelare player;
	public JFrame f;
	private JPanel mainPanel;
	private JPanel leftpanel;
	private JPanel bottompanel;
	private JPanel cardspanel;
	private int c;
	private int r;
	private int totalamount;
	private JPanel p1pppanel;
	private JPanel p2pppanel;
	public int p1points;
	public int p2points;
	public JLabel p1plabel;
	public JLabel p2plabel;

	public static void main(String[] arg) {
		Memory game = new Memory();
		game.initBoard(); //skapar grafiken och frågar efter värden 
		game.nyttSpel(); // skapar kort och placerar dem på spelplanen
		game.resetBoard(); 
	}

	public void initBoard(){
		f = new JFrame("Memory");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// v-v-v-v KONTROLL AV INMATADE VÄRDEN v v v v
		String columns = (String)JOptionPane.showInputDialog(f,
		"Choose the number of columns",
		"Game options",JOptionPane.PLAIN_MESSAGE,null,null,null);
		String rows = "";
		//If a string was returned, say so.
		if ((columns != null) && (columns.length() > 0)) {
			rows = (String)JOptionPane.showInputDialog(f,
			"Choose the number of rows",
			"Game options",JOptionPane.PLAIN_MESSAGE,null,null,null);
		}

		c = Integer.parseInt(columns);
		r = Integer.parseInt(rows);
		// frågar efter nya värden ifall dessa inte är giltiga
		while ((c*r) > 36 || (c*r) < 4 || c > 6 || r > 6 || !((c*r) % 2 == 0)){
			columns = (String)JOptionPane.showInputDialog(f,
			"The number of cards can't be more than 36 or less than 4\n"+
			"The number of rows and columns can't be more than 6 each\n"+
			"The number of cards can't be uneven, e.g. 25"+
			"\nChoose the number of columns",
			"Game options",JOptionPane.PLAIN_MESSAGE,null,null,null);
			rows = "";
			//If a string was returned, say so.
			if ((columns != null) && (columns.length() > 0)) {
				rows = (String)JOptionPane.showInputDialog(f,
				"Choose the number of rows",
				"Game options",JOptionPane.PLAIN_MESSAGE,null,null,null);
			}
			c = Integer.parseInt(columns);
			r = Integer.parseInt(rows);
		} // ^ ^ ^ ^ SLUT PÅ KONTROLL AV VÄRDEN ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ 

		//  v v IMPLEMENTERAR DESIGNEN (LAYOUTS, BUTTONS, LABELS... M.M) v v 
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		f.add(mainPanel); // lägger till en panel som innehåller allt.

		// v vSKAPAR EN PANEL MED SPELARE (Sätts till vänster i mainPanel)v v
		leftpanel = new JPanel();
		leftpanel.setBackground(Color.WHITE);
		leftpanel.setLayout(new GridLayout(2,1));
		mainPanel.add(leftpanel, BorderLayout.WEST);
		p1pppanel = new JPanel();
		p1pppanel.setLayout(new GridLayout(2,1));
		leftpanel.add(p1pppanel);
		JPanel p1panel = new JPanel();
		p1panel.setOpaque(false);
		p1pppanel.add(p1panel);
		JLabel pl1 = new JLabel("Spelare 1");
		p1pppanel.add(pl1);
		JLabel ptext = new JLabel("Poäng: ");
		p1panel.add(ptext);
		p1plabel = new JLabel("0");
		p1panel.add(p1plabel);

		p2pppanel = new JPanel();
		p2pppanel.setLayout(new GridLayout(2,1));
		leftpanel.add(p2pppanel);
		JLabel pl2 = new JLabel("Spelare 2");
		p2pppanel.add(pl2);
		JPanel p2panel = new JPanel();
		p2panel.setOpaque(false);
		p2pppanel.add(p2panel);
		
		JLabel p2text = new JLabel("Poäng: ");
		p2panel.add(p2text);
		p2plabel = new JLabel("0");
		p2panel.add(p2plabel);
		// ------------------------------------
		
		// v v SKAPAR EN PANEL MED KNAPPARNA NYTT OCH AVSLUTA v v v
		// 				(Sätts längst ner i mainPanel)
		bottompanel = new JPanel();
		bottompanel.setBackground(Color.GRAY);
		bottompanel.setLayout(new FlowLayout());
		mainPanel.add(bottompanel, BorderLayout.SOUTH);

		JButton newGamebtn = new JButton("Nytt spel"); // Knappen nytt
		newGamebtn.setActionCommand("newgame");
		newGamebtn.addActionListener(new ButtonListener(this));
		bottompanel.add(newGamebtn);

		JButton endGamebtn = new JButton("Avsluta spel"); // Knappen avluta
		endGamebtn.setActionCommand("endgame");
		endGamebtn.addActionListener(new ButtonListener(this));
		bottompanel.add(endGamebtn);

		// v v v SKAPAR CARDSPANELEN v v v (Sätts till höger i mainPanel)
		JPanel outerCardPanel = new JPanel();
		outerCardPanel.setLayout(new FlowLayout());
		outerCardPanel.setBackground(Color.WHITE);
		mainPanel.add(outerCardPanel, BorderLayout.EAST);
		cardspanel = new JPanel();
		cardspanel.setLayout(new GridLayout(r,c));
		cardspanel.setBackground(Color.WHITE);
		outerCardPanel.add(cardspanel);
		// ----------------------
		// SLUT PÅ IMPLEMENTERING AV DESIGNEN ----------------------
	}
	// SKAPAR KORT, HÄMTAR BILDER, LÄGGER IN DEM I CARDSPANELEN v v v v v
	public void nyttSpel(){
		cardspanel.removeAll();
		cardspanel.setLayout(new GridLayout(r,c));
		p1points = 0;
		p2points = 0;
		p1plabel.setText("" + p1points); // poäng visas i rätt label
		p2plabel.setText("" + p2points);
		this.setPlayer(Spelare.PLAYER1); // Spelare 1 börjar spela
		this.p2pppanel.setBackground(Color.WHITE);
		this.p1pppanel.setBackground(Color.YELLOW);

		totalamount = c*r;

		Kort[] cardsArray = new Kort[r*c];//Kortarray med rätt antal intitieras
		int k = (c * r) / 2;
		CardListener cl = new CardListener(this);
		cl.count = 0;
		// Initerar varje kort i arrayen med rätt värden
		for (int i = 0; i < cardsArray.length/2; i++){
			Icon nicon = new ImageIcon("bildmapp/img" + k + ".png");
			Kort card1 = new Kort(nicon); //ikon
			Kort card2 = new Kort(nicon);
			card1.setBackground(Color.BLUE); //färg
			card2.setBackground(Color.BLUE);
			card1.addActionListener(cl);	// Actionlistener	
			card2.addActionListener(cl);
			card1.setPreferredSize(new Dimension(60, 60)); // Size
			card2.setPreferredSize(new Dimension(60, 60));
			cardsArray[i] = card1;		// Korten i arrayen sätts
			cardsArray[cardsArray.length-i-1] = card2;
			k--;
		}
		//Slumpar Arrayen med kort
		Verktyg slump = new Verktyg();
		slump.slumpOrdning(cardsArray);
		//Lägger till varje kort i cardspanelen
		for (int i = 0; i < cardsArray.length; i++){
			cardspanel.add(cardsArray[i]);
		}
		cardspanel.revalidate();
	}

	public void randomRAndC(){
		// Ger ett random samt giltigt värde på colums och rows
		Random rand = new Random();
		r = rand.nextInt(6) + 1;
		c = rand.nextInt(6) + 1;
		while ((c*r) > 36 || (c*r) < 4 || c > 6 || r > 6 || !((c*r) % 2 == 0)){
			r = rand.nextInt(6) + 1;
			c = rand.nextInt(6) + 1;
		}
	}

	public void resetBoard(){
		f.pack();
	  f.setVisible(true);
	}

	public void deccards(){
		//minskar variabel
		totalamount -= 2;
	}

	public int getcards(){
		return totalamount;
	}
	// METOD FÖR ATT ANGE VEMS TUR DET ÄR ATT SPELA
	public void changePlayer(){
		if (this.player == Spelare.PLAYER1){
			this.setPlayer(Spelare.PLAYER2);
			this.p1pppanel.setBackground(Color.WHITE);
			this.p2pppanel.setBackground(Color.YELLOW);
		}
		else if (this.player == Spelare.PLAYER2){
			this.setPlayer(Spelare.PLAYER1);
			this.p2pppanel.setBackground(Color.WHITE);
			this.p1pppanel.setBackground(Color.YELLOW);
		}
	}
	// Sätter variabeln player till enum paramentern
	public void setPlayer(Spelare playerino){
		this.player = null;
		this.player = playerino;
	}

	public Spelare getPlayer(){
		return this.player;
	}
}