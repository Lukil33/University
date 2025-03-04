package Utility;

import Exceptions.*;
import Movies.*;
import Utility.Comparator.NameComp;

import java.util.ArrayList;
import java.util.Comparator;

public class Archivio extends ArrayList<Film>{
    private int focus;
    Archivio(){
        this.focus = 0;
        insertAll();
        sortList(new NameComp());
    }
    private void insertAll(){
        this.add(new SerieTv("Boris",2010,"Italiano",4,10));
        this.add(new Anime("Attack On Titan",2013,"Giapponese","Inglese",10));
        this.add(new Film("Parasite",2019,"Inglese",20));
        this.add(new Anime("Pokemon",2010,"Inglese","no sottotitoli",10));
        this.add(new Film("The Irishman",2019,"Inglese",5));
        this.add(new SerieTv("1994",2019,"Italiano",3,10));
        this.add(new Film("Her",2013,"Inglese",20));
    }
    void sortList(Comparator<Film> c){
        this.sort(c);
    }
    Film getElement(int i){
        return this.get(i);
    }
    void swipe(int i) throws TooLeft, TooRight{
        this.focus += i;
        if(this.focus < 0){
            this.focus += 1;
            throw new TooLeft();
        }else if(this.focus >= this.size()-2){
            this.focus -= 1;
            throw new TooRight();
        }
    }
    int getFocus(){
        return this.focus;
    }
}
