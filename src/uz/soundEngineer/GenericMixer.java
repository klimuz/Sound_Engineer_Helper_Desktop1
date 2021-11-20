package uz.soundEngineer;

import java.util.ArrayList;

public class GenericMixer {
    private ArrayList inputStrips = new ArrayList(SystemLogic.CommonChannels());
    private ArrayList outputStrips = new ArrayList(SystemLogic.outStrips.size());

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
    }
    public void populateOutputs(){
        outputStrips.add(0, mixerName);
    }


}
