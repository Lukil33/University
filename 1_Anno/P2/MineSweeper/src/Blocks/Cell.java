package Blocks;

public class Cell extends AbstractBlock{
    private final int value;
    public Cell(int val){
        super(false, ""+val);
        this.value = val;
    }
    public int getVal(){
        return value;
    }
}
