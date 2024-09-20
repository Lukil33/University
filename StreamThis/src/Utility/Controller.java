package Utility;

import Exceptions.*;
import Movies.Film;
import View.MainGui;

import java.util.Comparator;

public class Controller{
    private final Archivio arch;
    private final MainGui gui;
    public Controller(){
        this.arch = new Archivio();
        this.gui = new MainGui(this);
    }
    public void selectMovie(int i){
        this.gui.informationRedraw(this.arch.getElement(i));
    }
    public void changeComparator(Comparator<Film> c){
        this.arch.sortList(c);
        this.gui.headerRedraw();
    }
    public Film getElement(int i){
        return this.arch.getElement(i);
    }
    public MainGui getGui(){
        return this.gui;
    }
    public void swipe(int i) throws TooLeft, TooRight{
        this.arch.swipe(i);
    }
    public int getFocus(){
        return this.arch.getFocus();
    }
}
