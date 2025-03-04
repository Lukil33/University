package Blocks;

public class Division extends AbstractBlock{
    public Division() {
        super("/2");
    }

    @Override
    public int discover(int p) throws Discovered{
        return modifyPoints(p/2);
    }
}
