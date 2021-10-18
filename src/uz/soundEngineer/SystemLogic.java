package uz.soundEngineer;

import java.util.ArrayList;
import java.util.Arrays;

public class SystemLogic {
    public static ArrayList mixerStrips = new ArrayList(65);
    public static ArrayList<String> drumStrips = new ArrayList<>(Arrays.asList("Kick", "Sn1Top", "Sn1Bot", "Sn2",
            "Hat", "Tom1", "Tom2", "FlTom", "Over1", "Over2"));
    public static ArrayList<String> guitarStrips = new ArrayList<>(Arrays.asList("Bass", "EGtr", "AGtr"));

   public static void setStrips(){
        mixerStrips.add(0,"Unnamed");


    }
}
