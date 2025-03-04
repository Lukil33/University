package Fan.Tipologia;

public class Parete implements Tipologia{
    private final int cost = 20;
    @Override
    public String toString(){
        return "Parete";
    }
    @Override
    public int costToAdd(){
        return cost;
    }
}
