package Blocchi.Block;

import Blocchi.Abstract.AbstractSolidBlock;

public class TorchBlock extends AbstractSolidBlock{
    public TorchBlock(){
        super('T', "Torch");
        this.destroy_falling_block = true;
    }
}