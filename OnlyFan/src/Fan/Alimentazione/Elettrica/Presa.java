package Fan.Alimentazione.Elettrica;

import Fan.Alimentazione.Elettrica.Elettrica;

public class Presa implements Elettrica{
    private final int multiplier = 2;
    @Override
    public String toString(){
        return "Presa";
    }
    @Override
    public int costToMultiply() {
        return multiplier;
    }
}
