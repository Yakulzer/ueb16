import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse Dialog.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Dialog
{
    Flasche<? extends Getraenk> flasche;
    Getraenkeautomat<? extends Flasche<? extends Getraenk>> getraenkeautomat;

    Scanner input;
    private static final int FLASCHE_FUELLEN = 1;
    private static final int FLASCHE_LEEREN = 2;
    private static final int FLASCHEN_INHALT_AUSGEBEN = 3;
    private static final int GETRAENKE_AUTOMAT_ANLEGEN = 4;
    private static final int FLASCHE_EINLEGEN = 5;
    private static final int FLASCHE_AUSGEBEN = 6;
    private static final int INHALT_AUTOMAT_AUSGEBEN = 7;
    private static final int ENDE = 0;


    private Dialog()
    {
        input = new Scanner (System.in);
    }

    /**
     * Durchfuehrung einer Schleife. Dabei ist der Startwert -1. Die Schleife wird
     * solange durchgefuehrt bis der Benutzer 0 fuer ENDE eingibt.
     * Es werden die Methoden einlesenFunktion() und ausfuehrenFunktion() ausgefuehrt.
     * Falls ein Fehler bei der Eingabe erfolgt, wird die entsprechende Ausnahme
     * ausgegeben und die Methode unterbrochen.
     */
    private void start()
    {
        int funktion = -1;

        while (funktion!=ENDE)
        {
            try
            {
                funktion=einlesenFunktion();
                ausfuehrenFunktion(funktion);
            }
            catch (IllegalArgumentException e)
            {
                System.err.println(e);
            }
            catch (InputMismatchException e)
            {
                System.err.println("Falsche Eingabe! Eingabe von Buchstaben an dieser Stelle nicht erlaubt. Bitte eine Zahl eingeben.");
                input.nextLine();
            }
        }
    }
    /**
     * Ausgabe der verschiedenen Eingabe-Moeglichkeiten fuer den Benutzer.
     * Der Benutzer gibt durch die Zahl 1-12 oder 0 seine Auswahl ein.
     * Die eingegebene Zahl wird zurueckgegeben.
     * @return eingelesene Funktion als ganzzahliger Wert.
     */
    private int einlesenFunktion()
    {
        int funktion;
        System.out.print(FLASCHE_FUELLEN                        + ": Flasche fuellen.\n"            +
                         FLASCHE_LEEREN                         + ": Flasche leeren.\n"             +
                         FLASCHEN_INHALT_AUSGEBEN               + ": Flascheninhalt.\n"             +
                         GETRAENKE_AUTOMAT_ANLEGEN              + ": Getraenkeautomat anlegen.\n"   +
                         FLASCHE_EINLEGEN                       + ": Flasche in Automat einlegen.\n"+
                         FLASCHE_AUSGEBEN                       + ": Flasche ausgeben\n"            +
                         INHALT_AUTOMAT_AUSGEBEN                + ": Inhalt Automat ausgeben.\n"    +
                         ENDE                                   + ": Programm beenden.\n"   );

        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Die ueber die Methode einlesenFunktion() eingegebene Zahl wird hier als Parameter mitgegeben.
     * Je nach Auswahl wird eine der angegebenen Cases ausgefuehrt. Wenn 0 fuer Ende eingegeben wird
     * erfolgt zusaetzlich die Ausgabe von "Programmende!".
     * Wird versehentlich z.B. 19 eingegeben erfolgt die Ausgabe von "Falsche Eingabe!".
     *
     * @param funktion auszufuehrende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion (int funktion)
    {
        switch (funktion)
        {
            case FLASCHE_FUELLEN:
            {
                flascheFuellen();
                break;
            }
            case FLASCHE_LEEREN:
            {
                flascheLeeren();
                break;
            }
            case FLASCHEN_INHALT_AUSGEBEN:
            {
                flascheInhaltAusgeben();
                break;
            }
            case GETRAENKE_AUTOMAT_ANLEGEN:
            {
                getraenkeAutomatAnlegen();
                break;
            }
            case FLASCHE_EINLEGEN:
            {
                flascheEinlegen();
                break;
            }
            case FLASCHE_AUSGEBEN:
            {
                flascheAusgeben();
                break;
            }
            case INHALT_AUTOMAT_AUSGEBEN:
            {
                inhaltAusgeben();
                break;
            }
            case ENDE:
            {
                System.out.println("Programm beendet...");
                break;
            }
            default:
            {
                System.err.println ("Falsche Eingabe! Bitte einen Wert zwischen 0 und x (entsprechend der gewuenschten Funktion eingeben).");
            }
        }
    }
    private void flascheFuellen(){
        flasche = new Flasche<>();
        System.out.print("Womit soll die FLasche gefuellt werden? 1. Alkoholfreies Getraenk 2. Alkoholisches Getraenk? ");
        int choice1 = input.nextInt();
        input.nextLine();
        if(flasche.getInhalt() != null){
            throw new IllegalArgumentException("Flasche ist bereits voll!");
        }
        if (choice1 == 1){
            System.out.print ("1. Wasser oder 2. Softdrink? ");
            int choiceWasserOderSoftdrink = input.nextInt();
            input.nextLine();
            if (choiceWasserOderSoftdrink == 1){
                Getraenk wasser = new Wasser("Saskia" , "Saskia-Quelle");
                flasche.fuellen(wasser);
                System.out.println ("Die Flasche wurde mit " + flasche.getInhalt() + " gefuellt");
            }
            else if (choiceWasserOderSoftdrink == 2){
                Getraenk softdrink = new SoftDrink ("Cola" , 23.4f);
                flasche.fuellen(softdrink);
                System.out.println ("Die Flasche wurde mit " + flasche.getInhalt() + " gefuellt.");
            }else{
                throw new IllegalArgumentException("Falsche Eingabe! Bitte 1 fuer Wasser oder 2 fuer Softdrink eingeben!");
            }
        }
        else if (choice1 == 2) {
            System.out.print("1. Bier oder 2. Wein? ");
            int choiceBierOderWein = input.nextInt();
            input.nextLine();
            if (choiceBierOderWein == 1) {
                Getraenk bier = new Bier(4.2f, "KarlsBerg Urpils");
                flasche.fuellen(bier);
                System.out.println("Die Flasche wurde mit " + flasche.getInhalt() + " gefuellt.");
            }
            else if (choiceBierOderWein == 2) {
                System.out.print("1.Rot - oder 2. Weisswein? ");
                int choiceRotOderWeisswein = input.nextInt();
                if (choiceRotOderWeisswein == 1) {
                    Getraenk rotwein = new Rotwein(12.3f, "Vino Griccio");
                    flasche.fuellen(rotwein);
                    System.out.println("Die Flasche wurde mit " + flasche.getInhalt() + " gefuellt.");
                }
                else if (choiceRotOderWeisswein == 2) {
                    Getraenk weisswein = new Weisswein(24.7f, "Vino Blanco");
                    flasche.fuellen(weisswein);
                    System.out.println("Die Flasche wurde mit " + flasche.getInhalt() + " gefuellt.");
                }else{
                    throw new IllegalArgumentException("Flasche Eingabe! Bitte 1 fuer Rot oder 2 fuer Weisswein eingeben!");
                }
            }else{
                throw new IllegalArgumentException("Falsche Eingabe! Bitte 1 fuer Bier oder 2 fuer Wein eingeben!");
            }
        }else{
            throw new IllegalArgumentException("Falsche Eingabe! bitte 1 für alkoholfreies oder 2 für alkoholisches Getraenk eingeben!");
        }
    }
    private void flascheLeeren(){
        flasche.leeren();
    }
    private void flascheInhaltAusgeben(){
        if(flasche.getInhalt() == null){
            System.out.println ("Die Flasche ist leer!");
        }else{
            System.out.println(flasche.toString());
        }
    }
    private void getraenkeAutomatAnlegen(){
        System.out.print("Wie gross ist das Fassungsvermoegen des Getraenkeautomats? ");

        int kapazitaet = input.nextInt();
        input.nextLine();

       /* System.out.println("Welche Art von Getraenkeautomat soll angelegt werden?\n" +
                           "1.Wasser:\n"                                             +
                           "2.Softdrink:\n"                                          +
                           "3.Bier:\n"                                               +
                           "4.Wein:\n"                                               +
                           "5.Alkoholfreie Getraenke:\n"                             +
                           "6.Alkoholische Getraenke:"                               );

        int choiceGetraenkeAutomat = input.nextInt();
        if (choiceGetraenkeAutomat == 1) {*/
            getraenkeautomat = new Getraenkeautomat<Flasche<Wasser>>(kapazitaet);
        //}
    }
    private void flascheEinlegen(){
        if (getraenkeautomat.getAktuelleAnzahl() >= getraenkeautomat.getKapazitaet()){
            System.out.println("Automat ist voll!");
        }else if(getraenkeautomat != null) {
            flascheFuellen();
            if (flasche.getInhalt() != null) {
                getraenkeautomat.flascheEinlegen(flasche);
            }
        }
    }
    private void flascheAusgeben(){
        if(getraenkeautomat == null){
            System.out.println("Es gibt noch keinen Getraenkeautomat!");
        }
        else if(getraenkeautomat.getAktuelleAnzahl() < 1){
            System.out.println("Automat ist leer!");
        }else{
            getraenkeautomat.flascheAusgeben();
        }
    }
    private void inhaltAusgeben(){
        if (getraenkeautomat == null){
            System.out.println("Es existiert noch kein Automat!");
        } else if (getraenkeautomat.getAktuelleAnzahl()<1){
            System.out.println("Der Automat ist leer");
        } else {
            System.out.println(getraenkeautomat.toString());
        }
    }

    public static void main (String[]args){
        new Dialog().start();
    }
}


