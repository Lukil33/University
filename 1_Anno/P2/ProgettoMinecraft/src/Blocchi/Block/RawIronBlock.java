package Blocchi.Block;

import Blocchi.Abstract.AbstractSolidBlock;
import Blocchi.Interfacce.SmeltableBlock;

class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {
    public RawIronBlock(){
        super('R',"Raw Iron");
    }
    public IronSwordBlock smelt(){
        return new IronSwordBlock();
    }
}
