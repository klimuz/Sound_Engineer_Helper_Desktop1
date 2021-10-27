package uz.soundEngineer;

import java.util.ArrayList;
import java.util.Arrays;

public class SystemLogic {
    public static ArrayList mixerStrips = new ArrayList(65);
    public static ArrayList<String> drumStrips = new ArrayList<>(Arrays.asList("Kick", "Sn1Top", "Sn1Bot", "Sn2",
            "Hat", "Tom1", "Tom2", "FlTom", "Over1", "Over2"));
    public static ArrayList<String> guitarStrips = new ArrayList<>(Arrays.asList("Bass", "EGtr", "AGtr"));
    public static ArrayList<String> synthStrips = new ArrayList<>(Arrays.asList("Sy1L", "Sy1R"));
    public static ArrayList<String> percussionStrips = new ArrayList<>(Arrays.asList("Cng1", "Cng2", "Bong"));

   public static void setStrips(){
        mixerStrips.add(0,"Unnamed");


    }
}
