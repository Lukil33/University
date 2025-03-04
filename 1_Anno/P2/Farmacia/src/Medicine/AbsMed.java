package Medicine;

import Exceptions.*;
import Ricette.Ricetta;
import Utility.Controller;
import Utility.Dati;

import java.util.Date;

public abstract class AbsMed{
    protected final String name;
    private final int costo;
    private final int prezzoScontato;
    private final Date scadenza;
    protected AbsMed(String n, int c, Date sc){
        this.name = n;
        this.costo = c;
        this.scadenza = sc;
        this.prezzoScontato = setPrezzoScontato(c);
    }
    public void compra(Controller c){
        Dati.subtractSoldi(prezzoScontato);
        aumentaNumUsiRicetta(c);
    }
    protected abstract void aumentaNumUsiRicetta(Controller c);
    public void checkComprabile(Controller c) throws NoMoney, MedScaduta, NoRicetta, RicettaUsata, RicettaNonSelezionata{
        checkSoldi();
        checkScadenza();
        checkEsistenzaRicetta(c);
    }
    private void checkSoldi() throws NoMoney{
        if(Dati.getSoldi() - this.costo < 0){
            throw new NoMoney();
        }
    }
    private void checkScadenza() throws MedScaduta{
        if(scadenza.before(Dati.getDate())){
            throw new MedScaduta();
        }
    }
    protected abstract void checkEsistenzaRicetta(Controller c) throws NoRicetta, RicettaUsata, RicettaNonSelezionata;
    protected abstract int setPrezzoScontato(int costo);
    public String getName(){
        return this.name;
    }
    public int getCosto(){
        return this.costo;
    }
    public int getPrezzoScontato(){
        return this.prezzoScontato;
    }
    public String getDate(){
        try{
            checkScadenza();
            return "Scadenza: " + scadenza.toString();
        }catch(MedScaduta m){
            return "scaduta";
        }
    }
    public abstract String getTipo();
}
