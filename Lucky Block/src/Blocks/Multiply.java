package Blocks;

public class Multiply extends AbstractBlock{
    public Multiply(){
        super("X2");
    }

    @Override
    public int discover(int p) throws Discovered{
        return modifyPoints(p*2);
    }
}
