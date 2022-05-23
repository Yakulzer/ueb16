public class Rotwein extends Wein
{
    float alkoholgehalt;
    String weingut;
    public Rotwein (float alkoholgehalt, String weingut){
        super(alkoholgehalt, weingut);
    }

    @Override
    public String toString() {
        return "Rotwein (Alkoholgehalt: " + getAlkoholgehalt() + " Weingut: " + getWeingut() + ")";
    }
}
