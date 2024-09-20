package Fan.Alimentazione.Meccanica;

import Fan.Alimentazione.Meccanica.Meccanica;

public class Meccanici implements Meccanica{
    private final int multiplier = 1;
    @Override
    public String toString(){
        return "Meccanica";
    }
    @Override
    public int costToMultiply() {
        return multiplier;
    }
}
