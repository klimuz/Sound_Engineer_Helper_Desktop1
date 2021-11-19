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
        System.out.println(inputStrips);
    }
    public void populateOutputs(){
        outputStrips.add(0, mixerName);
    }


}
