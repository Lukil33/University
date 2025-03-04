package Utility;

import Exceptions.*;
import Medicine.AbsMed;
import Ricette.Ricetta;
import View.ArrayMed.MedPane;
import View.MainGui;
import javafx.scene.control.Alert;

public class Controller{
    private final Dati dati;
    private final RegistroMed mregister;
    private final RegistroRic rregister;
    private final MainGui gui;
    public Controller(){
        this.dati = new Dati();
        this.mregister = new RegistroMed();
        this.rregister = new RegistroRic();
        this.gui = new MainGui(this);
    }
    public void compra(AbsMed med){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        try{
            med.checkComprabile(this);
            med.compra(this);
            this.gui.bottomRedraw();
        }catch(NoMoney n){
            a.setContentText("Soldi insufficienti");
            a.showAndWait();
        }catch(MedScaduta m){
            a.setContentText("Medicina scaduta");
            a.showAndWait();
        }catch(NoRicetta r){
            a.setContentText("Non hai la ricetta adatta");
            a.showAndWait();
        }catch(RicettaUsata ru){
            a.setContentText("La ricetta è già stata usata il numero massimo di volte");
            a.showAndWait();
        }catch(RicettaNonSelezionata rns){
            a.setContentText("La ricetta non è stata selezionata");
            a.showAndWait();
        }
    }
    public void setCenter(MedPane mp){
        this.gui.centerRedraw(mp);
    }
    public void selectRicetta(int i){
        this.getRic(i).changeActivity();
        this.gui.buttonRedraw();
    }
    public int numMed(){
        return this.mregister.getSize();
    }
    public int numRic(){
        return this.rregister.getSize();
    }
    public AbsMed getMed(int i){
        return this.mregister.getElement(i);
    }
    public Ricetta getRic(int i){
        return this.rregister.getElement(i);
    }
    public MainGui getGui(){
        return this.gui;
    }
}
