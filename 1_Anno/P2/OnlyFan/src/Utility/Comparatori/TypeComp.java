package Utility.Comparatori;

import Fan.Alimentazione.Elettrica.*;
import Fan.Alimentazione.Meccanica.Meccanici;
import Fan.Fan;
import Fan.Tipologia.*;

import java.util.Comparator;

public class TypeComp implements Comparator<Fan>{
    @Override
    public int compare(Fan o1, Fan o2) {
        int res = toResult(o1)-toResult(o2);
        if(res == 0){
            res = o1.getCosto()-o2.getCosto();
        }
        return res;
    }
    private int toResult(Fan o){
        int res = 0;
        if(o.getTipo() instanceof Parete){
            res += 10;
        }else if(o.getTipo() instanceof Piantana){
            res += 20;
        }else if(o.getTipo() instanceof Soffitto){
            res += 30;
        }
        if(o.getAlimentazione() instanceof Meccanici){
            res += 1;
        }else if(o.getAlimentazione() instanceof Presa){
            res += 2;
        }else if(o.getAlimentazione() instanceof Batteria){
            res += 3;
        }
        return res;
    }
}
