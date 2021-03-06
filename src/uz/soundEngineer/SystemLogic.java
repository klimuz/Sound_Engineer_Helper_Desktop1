package uz.soundEngineer;

import java.util.ArrayList;
import java.util.Arrays;

public class SystemLogic {
    public static String sceneName = "";
    public static ArrayList<String> drumStrips = new ArrayList<>(Arrays.asList("Kick", "Sn1Top", "Sn1Bot", "Sn2",
            "Hat", "Tom1", "Tom2", "FlTom", "Over1", "Over2"));
    public static ArrayList<String> guitarStrips = new ArrayList<>(Arrays.asList("Bass", "EGtr", "AGtr"));
    public static ArrayList<String> synthStrips = new ArrayList<>(Arrays.asList("Sy1L", "Sy1R"));
    public static ArrayList<String> percussionStrips = new ArrayList();
    public static ArrayList<String> stringedStrips = new ArrayList();
    public static ArrayList<String> windStrips = new ArrayList();
    public static ArrayList<String> leadVocStrips = new ArrayList();
    public static ArrayList<String> backVocStrips = new ArrayList();
    public static ArrayList<String> omniStrips = new ArrayList();
    public static ArrayList<String> extraStrips = new ArrayList();
    public static ArrayList<String> outStrips = new ArrayList<>(Arrays.asList("Ramp", "SF",
            "Dr", "Keys", "Gtr", "Per", "FF", "Sub", "FohL", "FohR"));
    public static Integer CommonChannels(){
       int sumChan = (drumStrips.size() + guitarStrips.size() + synthStrips.size() + percussionStrips.size()
       + stringedStrips.size() + windStrips.size() + leadVocStrips.size() + backVocStrips.size() + omniStrips.size() + extraStrips.size());
       return sumChan;

   }

}
