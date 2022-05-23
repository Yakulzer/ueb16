public class Wasser extends AlkoholfreiesGetraenk
{
    String hersteller;
    String quelle;

    public Wasser (String hersteller, String quelle){
        setHersteller(hersteller);
        setQuelle(quelle);
    }
    public void setQuelle(String quelle){
        this.quelle = quelle;
    }
    public String getQuelle(){
        return quelle;
    }
    @Override
    public String toString (){
        return "Wasser (Hersteller: " + getHersteller() + " Quelle: " + quelle + ")";
    }
}