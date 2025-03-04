package Blocchi.Abstract;

public abstract class AbstractFallingSolidBlock extends AbstractBlock{
    public AbstractFallingSolidBlock(char cont, String name) {
        super(cont, name);
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.destroyable_falling_block = true;
        this.pickable = true;
    }
}
