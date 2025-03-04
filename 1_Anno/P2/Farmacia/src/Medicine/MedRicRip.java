package Medicine;

import Exceptions.NoRicetta;
import Exceptions.RicettaNonSelezionata;
import Exceptions.RicettaUsata;
import Ricette.Ricetta;

import java.util.Date;

public class MedRicRip extends MedConRicetta{
    public MedRicRip(String n, int r, int c, Date sc) {
        super(n, r, c, sc);
    }
    @Override
    protected int setPrezzoScontato(int costo) {
        return costo - 5;
    }
    @Override
    protected String getRipetibilita() {
        return "Ripetibile fino a " + this.ripetibilita + " volte";
    }
}
