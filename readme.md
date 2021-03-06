# TDDD27 - Online recipe page

NOTE - This project did not have the goal of being secure, optimized, etc, but
to learn new techniques. There are probably a lot of issues needing to be fixed
for this project to become production-ready.

## Running in development mode
This project is developed in IntelliJ, which makes the easiest way to running it by starting IntelliJ and executing the `frontend: devel` and `Backend` tasks.
It should also be possible to start by standing in the frontend/ folder and running `npm start`, and in the backend/ folder and running `mvn spring-boot:run`.
Dependencies are Java8 and Maven for backend, and NodeJS with angular-cli for frontend

## Docker
NOTE - Docker implementation has not been tested due to lack of time.

Frontend should be built with

    npm run dist
    docker build -t loll3k/recipe-frontend .

Backend CAN be build with simply

    docker build -t loll3k/recipe-backend .

But that would be stupid, since all source files with be included. Backend
should instead probably build a WAR-file and run `FROM tomcat`

There is a docker-compose file, which in theory should run by running

    docker-compose up

# Idea

## Vag idé
Det kan vara påfrestande att komma på vad man ska laga för mat varje dag. Även
om man redan kan en stor mängd recept så glömmer man lätt bort dom, och lagar
samma mat varje vecka. Tänk vad praktiskt det vore om det fanns en sida på
internet som man kunde skriva in sina favoritrecept på. På den sidan borde det
vara möjligt att generera fram gamla bortglömda recept som man inte ätit på
ett tag. Jag tänker mig en "recommended for you"-panel lite som steam gör
reklam för spel som man kanske är intresserad av, som man kan kryssa så dyker
det upp nya. Det vore även praktiskt med en "veckans mat"-funktion, som kan
generera en balanserad meny, där man kanske får lite kött, lite fisk, lite
kyckling, och en vegetarisk rätt varje vecka. Till råga på allt så skulle man
kanske kunna kryssa bort recept där som man inte känner för att äta, så byter
den ut det mot nya. När man känner sig nöjd så kan man inte bara spara veckans
meny, så man minns den under veckan, och kan kolla tillbaka på det senare
veckor, utan också generering av inköpslista i textformat.

## Funktionella krav?
  * Titelsida med inloggning
    - Kanske bara en jumbotron och en inloggningsruta, med lite stock photos på
      mat?
  * Eget konto
    - Ska kopplas via annan auth, t ex google eller facebook.
  * Receptlista med tillhörande recept. Dina recept är publika.
    - Recept skapas genom ett formulär (angular?).
    - Ingredienser ska fyllas på med typ (st, kg), samt vara (fritext,
      autocomplete?)
    - Instruktioner ska vara ett fritextfält, kanske markdown?
  * Man ska kunna tagga recept. Exempel på taggar är "kött", "fisk",
    "vegetarisk"
  * Man ska kunna generera en receptlista för veckan, där taggarna ska vara
    jämnt fördelade, t ex 2 kött 2 fisk, 3 vegetariska.
  * Det ska gå att persistera veckolistan, så man kan kolla tillbaka på tidigare
    veckor.
  * Generera inköpslista i textformat

## Extra idéer som kanske eller kanske inte är relevanta
  * Göra det möjligt att dela recept på ett smidigt sätt. Via facebook?
  * Göra det möjligt att skala recept på ett smidigt sätt, t ex dubbel mängd
    personer -> dubbel dos ingredienser.
  * Göra det möjligt att skapa egna taggar
  * Göra det möjligt att ladda upp bilder på sina kulinariska skapelser
  * Fundera om man kan integrera inköpslistan med existerande appar/program
  * Göra det möjligt att prenumerera på andras recept, ALTERNATIVT forka andras
    recept, eftersom jag vet att man ändå inte följer andras recept till punkt
    och pricka.

## Tekniker
  * Angular2 som frontend
    - Fungerar bra för formulär, och känns modernt.
  * Twitter bootstrap som styling
  * Spring boot som backend?
    - Enkelt att sätta upp för simpel REST
    - Finns stöd för ORM och automatisk classToJson-konvertering
  * H2 som databas
    - Enkelt att sätta upp, och bra stöd genom spring boot.
    - Jag föredrar vanlig SQL mot noSQL.
    - Verkar skala bra för mindre (<= 2GB) produktionsservrar enligt människor på internet
