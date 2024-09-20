package Medicine;

import Exceptions.NoRicetta;
import Exceptions.RicettaNonSelezionata;
import Exceptions.RicettaUsata;

import Utility.Controller;

import java.util.Date;

public class MedDaBanco extends AbsMed{
    public MedDaBanco(String n, int c, Date sc){
        super(n,c,sc);
    }
    @Override
    protected void aumentaNumUsiRicetta(Controller c){
    }
    @Override
    protected void checkEsistenzaRicetta(Controller c) throws NoRicetta, RicettaUsata, RicettaNonSelezionata {
    }
    @Override
    protected int setPrezzoScontato(int costo) {
        return costo;
    }
    @Override
    public String getTipo() {
        return "Medicinale da Banco";
    }
}
