package Blocks;

public abstract class AbstractBlock implements Block{
    private String name;
    private boolean discovered;
    public AbstractBlock(String n){
        this.name = n;
        this.discovered = false;
    }
    protected void modifyName(int val){
        this.name+=val;
    }
    protected int modifyPoints(int res) throws Discovered{
        if(!discovered){
            discovered = true;
            return res;
        }else{
            throw new Discovered();
        }
    }
    public String getString(){
        return this.name;
    }
    public boolean getDiscovered(){
        return this.discovered;
    };
}