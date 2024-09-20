package Blocks;

public interface Block{
    public void discover() throws Explosive, Discovered;
    public String getName();
    public int getFlag();
    public boolean isFlagged();
    public boolean getDiscovered();
    public void changeFlag();
    public void addFlag(int x);
    public boolean isExplosive();
}