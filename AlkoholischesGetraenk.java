public abstract class AlkoholischesGetraenk extends Getraenk
{
    float alkoholgehalt;
    public void setAlkoholgehalt(float alkoholgehalt){
        this.alkoholgehalt = alkoholgehalt;
    }
    public double getAlkoholgehalt(){
        return alkoholgehalt;
    }
    @Override
    public abstract String toString();
}

