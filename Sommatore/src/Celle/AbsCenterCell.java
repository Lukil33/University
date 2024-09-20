package Celle;

import Exceptions.*;

import java.util.Random;

public abstract class AbsCenterCell extends AbsCell{
    protected static final int MIN_BOUND = 0;
    protected static final int MAX_BOUND = 3;
    AbsCenterCell(){
        assignValue();
    }
    private void assignValue(){
        Random r = new Random();
        this.value = r.nextInt(MIN_BOUND,MAX_BOUND+1);
    }
    public abstract void modifyValue();
}
