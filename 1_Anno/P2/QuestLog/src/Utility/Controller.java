package Utility;


import Exceptions.AlreadyCompleted;
import Exceptions.NotStrong;
import Exceptions.PreviousQuestNotCompleted;
import Quest.*;
import View.MainGui;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Comparator;

public class Controller{
    private final PlayerStats stats;
    private final QuestLists quest;
    private final MainGui gui;
    public Controller(){
        this.stats = new PlayerStats("Geraldo da Ravina");
        this.quest = new QuestLists();
        this.gui = new MainGui(this);
    }
    public void completeQuest(AbsQuest a){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        try{
            check(a);
            a.setAsCompleted(this.stats);
            this.gui.statsRedraw();
            this.gui.centerRedraw();
        }catch(AlreadyCompleted ac){
            alert.setContentText("La quest selezionata è già stata completata");
            alert.showAndWait();
        }catch(NotStrong ns){
            alert.setContentText("Il tuo livello è ancora troppo basso per completare questa quest");
            alert.showAndWait();
        }catch(PreviousQuestNotCompleted pqnc){
            alert.setContentText("Non hai ancora completato le quest precedenti");
            alert.showAndWait();
        }
    }
    private void check(AbsQuest a) throws AlreadyCompleted, NotStrong, PreviousQuestNotCompleted{
        if(a.isCompleted()){
            throw new AlreadyCompleted();
        }else if(a.getLevelReq() > this.stats.getLevel()){
            throw new NotStrong();
        }else if(a instanceof MainQuest && ((MainQuest)a).getPrec() != null && !((MainQuest)a).getPrec().isCompleted()){
            throw new PreviousQuestNotCompleted();
        }
    }
    public void setMainComparator(Comparator<AbsQuest> c){
        this.quest.mainListSort(c);
        this.gui.centerRedraw();
    }
    public void setSecondaryComparator(Comparator<AbsQuest> c){
        this.quest.secondaryListSort(c);
        this.gui.centerRedraw();
    }
    public void setContractComparator(Comparator<AbsQuest> c){
        this.quest.contractListSort(c);
        this.gui.centerRedraw();
    }
    public void setDlcComparator(Comparator<AbsQuest> c){
        this.quest.dlcListSort(c);
        this.gui.centerRedraw();
    }

    public PlayerStats getStats(){
        return this.stats;
    }
    public ArrayList<MainQuest> getMainList(){
        return this.quest.getMainList();
    }
    public ArrayList<SecondaryQuest> getSecondaryList(){
        return this.quest.getSecondaryList();
    }
    public ArrayList<ContractQuest> getContractList(){
        return this.quest.getContractList();
    }
    public ArrayList<DlcQuest> getDlcList(){
        return this.quest.getDlcList();
    }
    public MainGui getGui(){
        return this.gui;
    }
}
