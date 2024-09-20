package Medicine;

import Exceptions.NoRicetta;
import Exceptions.RicettaNonSelezionata;
import Exceptions.RicettaUsata;
import Ricette.Ricetta;

import java.util.Date;

public class MedRicNonRip extends MedConRicetta{
    public MedRicNonRip(String n, int c, Date sc) {
        super(n, 1, c, sc);
    }
    @Override
    protected int setPrezzoScontato(int costo){
        return costo - 10;
    }
    @Override
    protected String getRipetibilita() {
        return "Non Ripetibile";
    }
}
