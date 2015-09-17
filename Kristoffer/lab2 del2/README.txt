Grupp 16, Kristoffer Ek & Albin B��w

//UTSKRIFT N�R VI K�R MED INDATA.TXT

1/3 + 1/4	--> 7/12
2/9 * -4/5	--> -8/45
2/6 - 7/9	--> -4/9
7/-2 / -2/5	--> 35/4
-5/10 + -3/4	--> -5/4
-5/3 * 4	--> -20/3
7/9 * 2		--> 14/9
-5 * 1/3	--> -5/3
2 / -5		--> -2/5
2/5 = 40/100	--> true
6/18 = -1/3	--> false
2/9 < 1/5	--> false
-5/9 < 1/2	--> true
1/2 +1/3	--> Felaktigt uttryck!
1/5		--> Felaktigt uttryck!
/4 + 1/3	--> NumberFormatException: For input string: ""
5/ + 1/3	--> NumberFormatException: For input string: ""
1//4 + 1/4	--> NumberFormatException: For input string: "/4"
1/ - 2 + 1/3	--> Felaktigt uttryck!
1/3 a + 1/3	--> Felaktigt uttryck!
-/3 + 1/3	--> NumberFormatException: For input string: "-"
1/3 + 1/3 + 1/3	--> Felaktigt uttryck!
1/3 & 1/3	--> Felaktig operator!
1/0 + 1/3	--> NumberFormatException: Denominator = 0
1 / 0		--> NumberFormatException: Denominator = 0

//------------------------------------------------ 

// BESKRIVNING AV RatNumTest3
N�r vi k�r RatNumTest3 s� kallar den p� divTester som �r en metod i RatNumTest2.
Metoden kollar ifall v�ra konstruktorer initierar v�rdena p� t�ljaren och n�mnaren korrekt,
genom att testa med flera olika v�rden. Inget skrivs ut om inga fel hittas.

Sedan k�rs RatNumTest3's egna divTester. Den testar v�ra equals- och clonemetoder �r 
korrekta genom att k�ra equals mellan tv� objekt. 
I slutet p� metoden s� kontroleras �ven v�ran toDouble metod.

Efter det s� kollar programet om vi det finns n�got argument till main.
Om s� �r fallet s� s�tter den filename till argumentet och scannar filen.
machine s�tts till true.

Ifall det inte finns n�got argument s� ber den inst�llet oss att skriva in ett uttryck.

En while loop k�rs sedan. Om machine �r true s� h�mtar den filens svar p� det aktuella utrycket

Sedan s�tts givenAnswer till v�ran RatNum's svar p� uttrycket, genom att anropa testExpr.
I testExpr s� s�tts tv� strycken objekt av klassen RatNum till det f�rsta rationella talet,
respektive det andra rationella talet. Efter det s� kollar metoden vilken operator det �r
och kallar sedan p� r�tt metod i v�ran RatNum. Svaret som v�ran utr�kning i RatNum ger 
retuneras sedan av testExpr till main och givenAnswer s�tts till detta.

Om machine �r false s� skrivs v�rat svar ut.
om machine �r true s� j�mf�r den v�rat svar med filens svar p� det aktuella utrycket.
Sedan skrivs filens och v�rat svar ut. Om v�rat svar �r fel s� skrivs �ven error ut.

Denna while loop k�rs tills den scannade raden = null. 
Om vi inte har valt att l�sa ifr�n en fil s� hoppar aldrig programmet ur while loopen,
utan den l�ter oss hela tiden skriva in ett nytt uttryck.
