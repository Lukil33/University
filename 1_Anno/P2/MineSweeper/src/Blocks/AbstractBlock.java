package Blocks;

public abstract class AbstractBlock implements Block{
    private final boolean explode;
    private boolean discovered;
    private boolean flagged;
    private final String name;
    private int n_flag;
    public AbstractBlock(boolean exp, String n){
        this.explode = exp;
        this.discovered = false;
        this.name = n;
        this.n_flag = 0;
        this.flagged = false;
    }
    public boolean isExplosive(){
        return this.explode;
    }
    public boolean getDiscovered(){
        return this.discovered;
    }
    public String getName(){
        return this.name;
    }
    public int getFlag(){
        return this.n_flag;
    }
    public boolean isFlagged(){
        return this.flagged;
    }
    public void discover() throws Explosive, Discovered{
        if(explode){
            this.discovered = true;
            throw new Explosive();
        }else{
            if(discovered){
                throw new Discovered();
            }else{
                this.discovered = true;
            }
        }
    }
    public void changeFlag(){
        this.flagged = !flagged;
    }
    public void addFlag(int x){
        this.n_flag += x;
    }

}
