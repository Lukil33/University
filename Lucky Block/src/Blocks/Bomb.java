package Blocks;

public class Bomb extends AbstractBlock{
    public Bomb() {
        super("BOOM");
    }

    @Override
    public int discover(int p) throws Discovered{
        return modifyPoints(p);
    }
}
