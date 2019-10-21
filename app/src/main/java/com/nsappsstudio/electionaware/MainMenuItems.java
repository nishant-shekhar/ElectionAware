package com.nsappsstudio.electionaware;

public class MainMenuItems {
    public String optionName;
    public String counter;

    public MainMenuItems(String optionName, String counter) {
        this.optionName = optionName;
        this.counter = counter;
    }

    public String getOptionName() {
        return optionName;
    }

    public String getCounter() {
        return counter;
    }
}
