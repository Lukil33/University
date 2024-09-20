package Medicine;

import Exceptions.NoRicetta;
import Exceptions.RicettaNonSelezionata;
import Exceptions.RicettaUsata;
import Ricette.Ricetta;
import Utility.Controller;
import Utility.Dati;

import java.util.Date;

public abstract class MedConRicetta extends AbsMed{
    protected int ripetibilita;
    protected MedConRicetta(String n, int r, int c, Date sc) {
        super(n, c, sc);
        this.ripetibilita = r;
    }
    @Override
    protected void aumentaNumUsiRicetta(Controller c){
        for(int i=0; i<c.numRic(); i++){
            if(c.getRic(i).getName().equals(this.name) && c.getRic(i).getData().after(Dati.getDate())){
                c.getRic(i).aumentaUsi();
            }
        }
    }
    @Override
    protected void checkEsistenzaRicetta(Controller c) throws NoRicetta, RicettaUsata, RicettaNonSelezionata{
        boolean isNotPresent = true;
        for(int i=0; i<c.numRic(); i++){
            if(c.getRic(i).getName().equals(this.name) && c.getRic(i).getData().after(Dati.getDate())){
                isNotPresent = false;
                checkRicetta(c.getRic(i));
            }
        }
        if(isNotPresent){
            throw new NoRicetta();
        }
    }
    private void checkRicetta(Ricetta r) throws RicettaUsata, RicettaNonSelezionata{
        if(!r.isActive()){
            throw new RicettaNonSelezionata();
        }
        r.checkNumOfUse(this.ripetibilita);
    }
    @Override
    public String getTipo(){
        return "Con Ricetta: "+ getRipetibilita();
    }
    protected abstract String getRipetibilita();
}
