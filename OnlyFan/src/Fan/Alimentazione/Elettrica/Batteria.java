package Fan.Alimentazione.Elettrica;

public class Batteria implements Elettrica{
    private final int multiplier = 3;
    @Override
    public String toString(){
        return "Batteria";
    }
    @Override
    public int costToMultiply() {
        return multiplier;
    }
}
