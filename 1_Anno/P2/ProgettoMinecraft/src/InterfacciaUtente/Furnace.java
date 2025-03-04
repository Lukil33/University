package InterfacciaUtente;

import Blocchi.Error.BlockErrorException;
import Blocchi.Interfacce.Block;
import Blocchi.Interfacce.SmeltableBlock;
import Blocchi.Block.Factory;
import Blocchi.Block.NullBlock;

public class Furnace{
    private SmeltableBlock input;
    private Block output;

    public Furnace(){
        this.input = Factory.nullBlock();
        this.output = Factory.nullBlock();
    }
    public void smelt(){
        this.output = this.input.smelt();
        this.input = Factory.nullBlock();
    }
    public SmeltableBlock watchInput(){return this.input;}
    public Block watchOutput(){return this.output;}
    public void setInput(SmeltableBlock block){
        this.input = block;
    }
    private void setOutput(SmeltableBlock block) {
        this.output = block;
    }
    public SmeltableBlock getInput(){
        SmeltableBlock b = this.input;
        setInput(Factory.nullBlock());
        return b;
    }
    public Block getOutput(){
        Block b = this.output;
        setOutput(Factory.nullBlock());
        return b;
    }
    public boolean isEmpty(){
        return this.input instanceof NullBlock;
    }
}
