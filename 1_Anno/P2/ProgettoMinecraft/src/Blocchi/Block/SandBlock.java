package Blocchi.Block;

import Blocchi.Abstract.AbstractBlock;
import Blocchi.Abstract.AbstractFallingSolidBlock;
import Blocchi.Interfacce.SmeltableBlock;

class SandBlock extends AbstractFallingSolidBlock implements SmeltableBlock {
    public SandBlock(){
        super('S',"Sand");
    }

    public GlassBlock smelt(){
        return Factory.glassBlock();
    }
}