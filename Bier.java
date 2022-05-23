public class Bier extends AlkoholischesGetraenk
{
    float alkoholgehalt;
    String brauerei;
    public Bier(float alkoholgehalt, String brauerei){
        setAlkoholgehalt(alkoholgehalt);
        setBrauerei(brauerei);
    }
    public void setBrauerei(String brauerei){
        this.brauerei = brauerei;
    }
    public String getBrauerei(){
        return brauerei;
    }
    @Override
    public String toString(){
        return "Bier (Alkoholgehalt: " + getAlkoholgehalt() + " Brauerei: " + brauerei + ")";
    }
}