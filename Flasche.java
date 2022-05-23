public class Flasche<T extends Getraenk> {
    private T inhalt;
    public Flasche(){
    }
    public void fuellen (T inhalt){
        this.inhalt = inhalt;
    }
    public void leeren (){
        inhalt = null;
    }
    public T getInhalt(){
        return inhalt;
    }
    public String toString(){
        return getInhalt().toString();
    }
}
