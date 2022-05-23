import java.util.ArrayList;
public class Getraenkeautomat<T extends Flasche> {
    private ArrayList<T> arraylistFlaschenlager ;
    private int kapazitaet;
    int aktuelleAnzahl = 0;

    public Getraenkeautomat(int kapazitaet){
        this.kapazitaet = kapazitaet;
        arraylistFlaschenlager = new ArrayList<>();
    }
    public void flascheEinlegen(T flasche){
        arraylistFlaschenlager.add(flasche);
        aktuelleAnzahl ++;
    }
    public void flascheAusgeben(){
        System.out.println(arraylistFlaschenlager.get(0) +" wurde ausgegeben!");
        arraylistFlaschenlager.remove(0);
        aktuelleAnzahl--;
    }
    public int getAktuelleAnzahl(){
        return aktuelleAnzahl;
    }

    public int getKapazitaet(){
        return kapazitaet;
    }

    @Override
    public String toString() {
        String list = arraylistFlaschenlager.toString();
        return list;
    }
}
