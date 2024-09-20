package Utility;

import Evocazioni.Attack;
import Evocazioni.Energie.*;
import Evocazioni.Evocation;
import Evocazioni.SupremeEvocation;
import Exceptions.EnemyElement;
import Exceptions.EnergyNotValid;
import Exceptions.GameOver;
import Exceptions.NotEnoughtEnergy;
import View.MainGui;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Controller{
    private final DatiGiocatore p1;
    private final DatiGiocatore p2;
    private final MainGui gui;
    private DatiGiocatore attackSide;
    private DatiGiocatore defenseSide;
    public Controller(){
        this.p1 = new DatiGiocatore();
        initializeP1();
        this.p2 = new DatiGiocatore();
        initializeP2();
        this.attackSide = this.p1;
        this.defenseSide = this.p2;
        this.gui = new MainGui(this);
    }
    private void initializeP1(){
        ArrayList<Evocation> evocation = new ArrayList<>();
        evocation.add(new Evocation("Ifrit", 30, new Fuoco(), new Attack("Hellflame", 2, 20)));
        evocation.add(new SupremeEvocation("Phoenix", 50, new Fuoco(), new Attack("Fiammata", 2, 20)));
        evocation.add(new Evocation("Diablos", 50, new Tenebra(), new Attack("Demi", 1, 20)));
        ArrayList<Energy> energy = new ArrayList<>();
        energy.add(new Fuoco());
        energy.add(new Fuoco());
        energy.add(new Neutra());
        energy.add(new Neutra());
        energy.add(new Tenebra());
        this.p1.initialize(evocation, energy);
    }
    private void initializeP2(){
        ArrayList<Evocation> evocation = new ArrayList<>();
        evocation.add(new Evocation("Leviathan", 30, new Acqua(), new Attack("Tsunami", 1, 10)));
        evocation.add(new SupremeEvocation("Bahamut", 60, new Neutra(), new Attack("MegaFlare", 3, 40)));
        evocation.add(new Evocation("Alexander", 30, new Neutra(), new Attack("Judgement", 1, 10)));
        ArrayList<Energy> energy = new ArrayList<>();
        energy.add(new Acqua());
        energy.add(new Acqua());
        energy.add(new Neutra());
        energy.add(new Tenebra());
        this.p2.initialize(evocation, energy);
    }
    private void changeSide(){
        if(this.attackSide.equals(this.p1)){
            this.attackSide = this.p2;
            this.defenseSide = this.p1;
        }else{
            this.attackSide = this.p1;
            this.defenseSide = this.p2;
        }
    }
    public void useEvocation(Evocation e, boolean side){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        try{
            validEvocation(e,side);
            this.defenseSide.applyDamage(e);
            changeSide();
            this.gui.redraw();
        }catch(NotEnoughtEnergy nee){
            alert.setContentText("Non hai abbastanza energie per attaccare");
            alert.showAndWait();
        }catch(EnemyElement ee){
            alert.setContentText("Evocazione nemica");
            alert.showAndWait();
        }catch(GameOver go){
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Bruh, hai vinto");
            alert.showAndWait();
        }
    }
    public void useEnergy(Energy e, boolean side){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        try{
            validEnergy(e,side);
            getAttackEvocation(0).addEnergy();
            this.attackSide.removeEnergy(e);
            this.gui.redraw();
        }catch(EnergyNotValid env){
            alert.setContentText("Hai selezionato un'energia di tipo sbagliata");
            alert.showAndWait();
        }catch(EnemyElement ee){
            alert.setContentText("Hai selezionato un'energia dell'avversario");
            alert.showAndWait();
        }
    }
    private void validEvocation(Evocation e, boolean side) throws NotEnoughtEnergy, EnemyElement{
        if(side){
            if(this.attackSide.getEvocation(0).getAttackEnergie() > this.attackSide.getEvocation(0).getAttackEnergieAttive()){
                throw new NotEnoughtEnergy();
            }
        }else{
            throw new EnemyElement();
        }
    }
    private void validEnergy(Energy e, boolean side) throws EnergyNotValid, EnemyElement {
        if(side){
            if((!this.attackSide.getEvocation(0).getType().getColor().equals(e.getColor())) && !(this.attackSide.getEvocation(0).getType() instanceof Neutra)){
                if(!(e instanceof Neutra)){
                    throw new EnergyNotValid();
                }
            }
        }else{
            throw new EnemyElement();
        }
    }

    public int getAttackEvocationSize(){
        return this.attackSide.getEvocationSize();
    }
    public Evocation getAttackEvocation(int i){
        return this.attackSide.getEvocation(i);
    }
    public int getAttackEnergySize(){
        return this.attackSide.getEnergySize();
    }
    public Energy getAttackEnergy(int i){
        return this.attackSide.getEnergy(i);
    }
    public int getDefenseEvocationSize(){
        return this.defenseSide.getEvocationSize();
    }
    public Evocation getDefenseEvocation(int i){
        return this.defenseSide.getEvocation(i);
    }
    public int getDefenseEnergySize(){
        return this.defenseSide.getEnergySize();
    }
    public Energy getDefenseEnergy(int i){
        return this.defenseSide.getEnergy(i);
    }
    public MainGui getGui(){
        return this.gui;
    }
}
