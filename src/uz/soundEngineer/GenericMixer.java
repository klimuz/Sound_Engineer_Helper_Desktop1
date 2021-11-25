package uz.soundEngineer;

import java.util.ArrayList;

public class GenericMixer {
    private ArrayList<String> inputStrips = new ArrayList(SystemLogic.CommonChannels());
    private ArrayList<String> outputStrips = new ArrayList(SystemLogic.outStrips.size());

    private String mixerName;
    public String getMixerName() {
        return mixerName;
    }
    public void setMixerName(String mixerName) {
        this.mixerName = mixerName;
    }
    public void populateInputs(){
        inputStrips.add(0, mixerName);
        inputStrips.addAll(SystemLogic.drumStrips);
        inputStrips.addAll(SystemLogic.guitarStrips);
        inputStrips.addAll(SystemLogic.synthStrips);
        inputStrips.addAll(SystemLogic.percussionStrips);
        inputStrips.addAll(SystemLogic.stringedStrips);
        inputStrips.addAll(SystemLogic.windStrips);
        inputStrips.addAll(SystemLogic.leadVocStrips);
        inputStrips.addAll(SystemLogic.backVocStrips);
        inputStrips.addAll(SystemLogic.extraStrips);
        inputStrips.addAll(SystemLogic.omniStrips);

        System.out.println(inputStrips);
//Solve odd-even for stereo sources
        if (inputStrips.contains("BasL") && (inputStrips.indexOf("BasL")%2 == 0)){
            if (inputStrips.contains("EGtr")){
                inputStrips.remove("EGtr");
                inputStrips.add(inputStrips.indexOf("BasL"), "EGtr");
            }else if (inputStrips.contains("EGt1")){
                inputStrips.remove("EGt1");
                inputStrips.add(inputStrips.indexOf("BasL"), "EGt1");
            }else if (inputStrips.contains("AGtr")){
                inputStrips.remove("AGtr");
                inputStrips.add(inputStrips.indexOf("BasL"), "AGtr");
            }else if (inputStrips.contains("AGt1")){
                inputStrips.remove("AGt1");
                inputStrips.add(inputStrips.indexOf("BasL"), "AGt1");
            }else if (inputStrips.contains("Syn1")){
                inputStrips.remove("Syn1");
                inputStrips.add(inputStrips.indexOf("BasL"), "Syn1");
            }else if (inputStrips.contains("Syn2")){
                inputStrips.remove("Syn2");
                inputStrips.add(inputStrips.indexOf("BasL"), "Syn2");
            }
        }
        System.out.println(inputStrips);
    }
    public void populateOutputs(){
        outputStrips.add(0, mixerName);
    }


}
