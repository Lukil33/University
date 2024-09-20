package Utility.Comparator;

import Movies.Film;

import java.util.Comparator;

public class YearComp implements Comparator<Film>{
    @Override
    public int compare(Film o1, Film o2) {
        int res = o1.getYear() - o2.getYear();
        if(res == 0){
            res = o1.getTitle().compareTo(o2.getTitle());
        }
        return res;
    }
}
