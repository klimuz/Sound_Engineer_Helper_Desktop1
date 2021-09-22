package uz.soundEngineer;

import java.util.ArrayList;
import java.util.Arrays;

public class SystemLogic {
    public static ArrayList mixerStrips = new ArrayList(65);
    public static ArrayList<String> drumStrips = new ArrayList<>(Arrays.asList("Kick", "Sn1Top", "Sn1Bot", "Sn2",
            "Hat", "Tom1", "Tom2", "FlTom", "Over1", "Over2"));

   /* public static void setDefaultDrums(){
        drumStrips.add("Kick");
        drumStrips.add("Sn1Top");
        drumStrips.add("Sn1Bot");
        drumStrips.add("Sn2");
        drumStrips.add("Hat");
        drumStrips.add("Tom1");
        drumStrips.add("Tom2");
        drumStrips.add("FlTom");
        drumStrips.add("Over1");
        drumStrips.add("Over2");


    }*/
    public static void setStrips(){
        mixerStrips.add(0,"Unnamed");


    }
}
