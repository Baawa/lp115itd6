Grupp 16, Kristoffer Ek & Albin Bååw

//UTSKRIFT NÄR VI KÖR MED INDATA.TXT

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
När vi kör RatNumTest3 så kallar den på divTester som är en metod i RatNumTest2.
Metoden kollar ifall våra konstruktorer initierar värdena på täljaren och nämnaren korrekt,
genom att testa med flera olika värden. Inget skrivs ut om inga fel hittas.

Sedan körs RatNumTest3's egna divTester. Den testar våra equals- och clonemetoder är 
korrekta genom att köra equals mellan två objekt. 
I slutet på metoden så kontroleras även våran toDouble metod.

Efter det så kollar programet om vi det finns något argument till main.
Om så är fallet så sätter den filename till argumentet och scannar filen.
machine sätts till true.

Ifall det inte finns något argument så ber den instället oss att skriva in ett uttryck.

En while loop körs sedan. Om machine är true så hämtar den filens svar på det aktuella utrycket

Sedan sätts givenAnswer till våran RatNum's svar på uttrycket, genom att anropa testExpr.
I testExpr så sätts två strycken objekt av klassen RatNum till det första rationella talet,
respektive det andra rationella talet. Efter det så kollar metoden vilken operator det är
och kallar sedan på rätt metod i våran RatNum. Svaret som våran uträkning i RatNum ger 
retuneras sedan av testExpr till main och givenAnswer sätts till detta.

Om machine är false så skrivs vårat svar ut.
om machine är true så jämför den vårat svar med filens svar på det aktuella utrycket.
Sedan skrivs filens och vårat svar ut. Om vårat svar är fel så skrivs även error ut.

Denna while loop körs tills den scannade raden = null. 
Om vi inte har valt att läsa ifrån en fil så hoppar aldrig programmet ur while loopen,
utan den låter oss hela tiden skriva in ett nytt uttryck.
