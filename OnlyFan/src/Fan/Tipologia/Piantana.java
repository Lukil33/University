package Fan.Tipologia;

public class Piantana implements Tipologia{
    private final int cost = 10;
    @Override
    public String toString(){
        return "Piantana";
    }
    @Override
    public int costToAdd() {
        return cost;
    }
}
