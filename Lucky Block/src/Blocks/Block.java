package Blocks;

public interface Block{
    public boolean getDiscovered();
    public String getString();
    public int discover (int p) throws Discovered;
}
