package Blocchi.Abstract;

import Blocchi.Interfacce.Block;

abstract public class AbstractBlock implements Block {
    protected char contenuto;
    protected String blockname;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected boolean pickable;
    protected int blocknum;
    protected boolean destroy_falling_block;
    protected boolean destroyable_falling_block;

    public AbstractBlock(char cont, String name){
        this.contenuto = cont;
        this.blockname = name;
        this.falls_with_gravity = false;
        this.fall_through = true;
        this.destroy_falling_block = false;
        this.destroyable_falling_block = false;
        this.pickable = false;
    }
    public boolean getFallswithgravity(){
        return this.falls_with_gravity;
    }
    public boolean getFalltrough(){
        return this.fall_through;
    }
    public char display(){
        return contenuto;
    }
    public boolean is_pickable(){
        return this.pickable;
    }
    public void setNum(int n){
        this.blocknum = n;
    }
    public int getNum(){return this.blocknum;}
    public boolean isDestroy_falling_block(){
        return destroy_falling_block;
    }
    public boolean isDestroyable_falling_block() {
        return destroyable_falling_block;
    }

    @Override
    public void display_in_inventory(){
        System.out.print("["+display()+"]");
    }
    @Override
    public String toString() {
        return blockname;
    }
}