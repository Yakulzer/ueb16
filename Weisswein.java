public class Weisswein extends Wein
{
    float alkoholgehalt;
    String weingut;
    public Weisswein (float alkoholgehalt, String weingut){
        super(alkoholgehalt, weingut);
    }

    @Override
    public String toString() {
        return "Weisswein (Alkoholgehalt: " + getAlkoholgehalt() + " Weingut : " + getWeingut() + ")";
    }
}