package Utility.Comparator;

import Movies.Anime;
import Movies.Film;
import Movies.SerieTv;

import java.util.Comparator;

public class TypeComp implements Comparator<Film>{
    @Override
    public int compare(Film o1, Film o2) {
        int res = insertType(o1)-insertType(o2);
        if(res == 0){
            res = o1.getTitle().compareTo(o2.getTitle());
        }
        return res;
    }
    private int insertType(Film o){
        if(o instanceof Anime){
            return 1;
        }else if(o instanceof SerieTv){
            return 3;
        }else{
            return 2;
        }
    }
}
