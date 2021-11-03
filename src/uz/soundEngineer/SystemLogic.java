package uz.soundEngineer;

import java.util.ArrayList;
import java.util.Arrays;

public class SystemLogic {
    public static ArrayList mixerStrips = new ArrayList(65);
    public static ArrayList<String> drumStrips = new ArrayList<>(Arrays.asList("Kick", "Sn1Top", "Sn1Bot", "Sn2",
            "Hat", "Tom1", "Tom2", "FlTom", "Over1", "Over2"));
    public static ArrayList<String> guitarStrips = new ArrayList<>(Arrays.asList("Bass", "EGtr", "AGtr"));
    public static ArrayList<String> synthStrips = new ArrayList<>(Arrays.asList("Sy1L", "Sy1R"));
    public static ArrayList<String> percussionStrips = new ArrayList();
    public static ArrayList<String> stringedStrips = new ArrayList();
    public static ArrayList<String> windStrips = new ArrayList();
    public static ArrayList<String> leadVocStrips = new ArrayList();
    public static ArrayList<String> backVocStrips = new ArrayList();
    public static ArrayList<String> otherStrips = new ArrayList();


   public static void setStrips(){
        mixerStrips.add(0,"Unnamed");
        }
   public static int CommonChannels(){
       int sumChan = (drumStrips.size() + guitarStrips.size() + synthStrips.size() + percussionStrips.size()
       + stringedStrips.size() + windStrips.size() + leadVocStrips.size() + backVocStrips.size() + otherStrips.size());
       return sumChan;
   }
}
