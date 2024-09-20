package Fan;

import Exceptions.ImpossibleFan;
import Fan.Alimentazione.Alimentazione;
import Fan.Alimentazione.Meccanica.Meccanica;
import Fan.Tipologia.Soffitto;
import Fan.Tipologia.Tipologia;

public class Fan{
    private final String marca;
    private int costo;
    private final Tipologia tipo;
    private final Alimentazione alimentazione;
    private boolean isActive;
    public Fan(String m, Tipologia tipo, Alimentazione alimentazione) throws ImpossibleFan{
        this.marca = m;
        this.tipo = tipo;
        this.alimentazione = alimentazione;
        check();
        finalCost();
        this.isActive = false;
    }
    private void check() throws ImpossibleFan{
        if(tipo instanceof Soffitto && alimentazione instanceof Meccanica){
            throw new ImpossibleFan();
        }
    }
    private void finalCost(){
        this.costo = (10 + tipo.costToAdd()) * alimentazione.costToMultiply();
    }
    public boolean isActive(){return this.isActive;}
    public void changeActivity(){this.isActive = !this.isActive;}
    public String getName(){
        return this.marca;
    }
    public Tipologia getTipo(){
        return this.tipo;
    }
    public Alimentazione getAlimentazione(){
        return this.alimentazione;
    }
    public int getCosto(){return this.costo;}
}
