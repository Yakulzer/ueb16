public class Wein extends AlkoholischesGetraenk
{
    float alkoholgehalt;
    String weingut;
    public Wein (float alkoholgehalt, String weingut){
        setAlkoholgehalt(alkoholgehalt);
        setWeingut(weingut);
    }
    public void setWeingut(String weingut){
        this.weingut = weingut;
    }
    public String getWeingut(){
        return weingut;
    }
    @Override
    public String toString(){
        return "Wein (Alkoholgehalt: " + alkoholgehalt + " Weingut : " + weingut + ")";
    }
}
