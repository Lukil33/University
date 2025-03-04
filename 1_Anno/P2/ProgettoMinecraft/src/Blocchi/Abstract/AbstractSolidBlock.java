package Blocchi.Abstract;

abstract public class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock(char cont, String name){
        super(cont, name);
        this.falls_with_gravity = false;
        this.fall_through = false;
        this.pickable = true;
    }
}
