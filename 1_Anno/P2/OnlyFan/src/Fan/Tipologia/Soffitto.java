package Fan.Tipologia;

public class Soffitto implements Tipologia{
    private final int cost = 2;
    @Override
    public String toString(){
        return "Soffitto";
    }
    @Override
    public int costToAdd() {
        return cost;
    }
}
