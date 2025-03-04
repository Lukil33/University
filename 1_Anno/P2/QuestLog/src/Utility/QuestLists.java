package Utility;

import Quest.*;

import java.util.ArrayList;
import java.util.Comparator;

public class QuestLists{
    private final ArrayList<MainQuest> mainQList;
    private final ArrayList<SecondaryQuest> secondaryQList;
    private final ArrayList<ContractQuest> contractQList;
    private final ArrayList<DlcQuest> dlcQList;
    QuestLists(){
        this.mainQList = new ArrayList<>();
        this.secondaryQList = new ArrayList<>();
        this.contractQList = new ArrayList<>();
        this.dlcQList = new ArrayList<>();
        initialize();
    }
    private void initialize(){
        this.mainQList.add(new MainQuest("Liliac and Gooseberries", 2, "WhiteOrchard", "The Nilfgaardian Connection"));
        this.mainQList.add(new MainQuest("The Nilfgaardian Connection", 3, "Velen", "Pyres of Novigrad"));
        this.mainQList.add(new MainQuest("Pyres of Novigrad", 5, "Novigrad", null));
        setMainPrec();

        this.secondaryQList.add(new SecondaryQuest("A Favor for a Friend", 2, 10, "Keira Metz"));
        this.secondaryQList.add(new SecondaryQuest("The Last Wish", 6, 30, "Bloody Baron"));

        String[] flist = {"Drowners", "Foglet"};
        this.contractQList.add(new ContractQuest("Swamp Thing", 12, 40, flist));
        String[] slist = {"Drowners"};
        this.contractQList.add(new TreasureHuntsQuest("Coast of Wrecks", 4, 50, slist, "Novigrad"));
        String[] tlist = {"Wolves", "Drowners"};
        this.contractQList.add(new TreasureHuntsQuest("Dirty Funds", 1, 20, tlist, "Velen"));

        this.dlcQList.add(new DlcQuest("Envoys, Wineboys", 8, "Velen", "Capture the Castle", "The Nilfgaardian Connection"));
        this.dlcQList.add(new DlcQuest("Capture the Castle", 9, "Toussaint", null, "The Nilfgaardian Connection"));
        setDlcPrec();
    }
    private void setMainPrec(){
        for(MainQuest s:mainQList){
            for(MainQuest f:mainQList){
                if(s.getProssima() != null && s.getProssima().equals(f.getName())){
                    f.setPrec(s);
                }
            }
        }
    }
    private void setDlcPrec(){
        for(DlcQuest p:dlcQList){
            for(MainQuest s:mainQList){
                if(p.getDependency().equals(s.getName())){
                    p.setCheck(s);
                }
            }
        }
    }
    void mainListSort(Comparator<AbsQuest> c){
        this.mainQList.sort(c);
    }
    void secondaryListSort(Comparator<AbsQuest> c){
        this.secondaryQList.sort(c);
    }
    void contractListSort(Comparator<AbsQuest> c){
        this.contractQList.sort(c);
    }
    void dlcListSort(Comparator<AbsQuest> c){
        this.dlcQList.sort(c);
    }

    ArrayList<MainQuest> getMainList(){
        return this.mainQList;
    }
    ArrayList<SecondaryQuest> getSecondaryList(){
        return this.secondaryQList;
    }
    ArrayList<ContractQuest> getContractList(){
        return this.contractQList;
    }
    ArrayList<DlcQuest> getDlcList(){
        return this.dlcQList;
    }
}
