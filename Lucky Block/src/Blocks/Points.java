package Blocks;

import java.util.Random;

public class Points extends AbstractBlock{
    private int value;
    public Points(){
        super("");
        Random rand = new Random();
        value = rand.nextInt(1,11) * 100;
        modifyName(value);
    }

    @Override
    public int discover(int p) throws Discovered{
        return modifyPoints(p+value);
    }
}
