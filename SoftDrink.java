public class SoftDrink extends AlkoholfreiesGetraenk
{
    String hersteller;
    float zuckergehalt;

    public SoftDrink (String hersteller, float zuckergehalt){
        setHersteller(hersteller);
        setZuckergehalt(zuckergehalt);
    }
    public void setZuckergehalt (float zuckergehalt){
        this.zuckergehalt = zuckergehalt;
    }
    public float getZuckergehalt(){
        return zuckergehalt;
    }
    @Override
    public String toString(){
        return "Softdrink (Hersteller " + getHersteller() + " Zuckergehalt: " + zuckergehalt + ")";
    }
}
