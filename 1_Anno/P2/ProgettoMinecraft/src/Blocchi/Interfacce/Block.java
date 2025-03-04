package Blocchi.Interfacce;

public interface Block extends InventoryBlock {
    public void setNum(int n);
    public int getNum();
    public boolean getFallswithgravity();
    public boolean getFalltrough();
    public char display();
    public boolean is_pickable();
    public boolean isDestroy_falling_block();
    public boolean isDestroyable_falling_block();
}
