package Blocchi.Block;

import Blocchi.Abstract.AbstractSolidBlock;
import Blocchi.Interfacce.SmeltableBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock(){
        super(' ',"Null");
        this.pickable = false;
    }
    public NullBlock smelt(){return Factory.nullBlock();};
}
