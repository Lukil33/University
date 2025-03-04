package Utility;

import Mutation.Combattimento.Strenght;
import Mutation.Combattimento.Velocity;
import Mutation.Magia.Ignition;
import Mutation.Magia.Quen;
import Mutation.Mutation;
import Mutation.Pozioni.Tollerance;

import java.util.ArrayList;

public class MutazioniDisponibili extends ArrayList<Mutation> {
    MutazioniDisponibili(){
        initializeArray();
    }
    private void initializeArray(){
        this.add(new Strenght());
        this.add(new Velocity());
        this.add(new Tollerance());
        this.add(new Ignition());
        this.add(new Quen());
    }
    void applyMutation(int i, Geraldo g){
        getMutation(i).applyMutation(g);
    }
    Mutation getMutation(int i){
        return this.get(i);
    }
}