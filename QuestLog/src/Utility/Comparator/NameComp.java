package Utility.Comparator;

import Quest.AbsQuest;

import java.util.Comparator;

public class NameComp implements Comparator<AbsQuest>{
    @Override
    public int compare(AbsQuest o1, AbsQuest o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
