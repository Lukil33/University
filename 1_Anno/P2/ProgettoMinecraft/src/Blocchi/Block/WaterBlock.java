package Blocchi.Block;

import Blocchi.Abstract.AbstractBlock;

public class WaterBlock extends AbstractBlock {
    public WaterBlock(){
        super('~',"Water");
        this.falls_with_gravity = true;
    }
}