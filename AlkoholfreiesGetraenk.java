public abstract class AlkoholfreiesGetraenk extends Getraenk
{
    String hersteller;
    public void setHersteller(String hersteller){
        this.hersteller = hersteller;
    }
    public String getHersteller(){
        return hersteller;
    }
    @Override
    public abstract String toString();
}
