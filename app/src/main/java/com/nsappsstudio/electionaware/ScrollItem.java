package com.nsappsstudio.electionaware;

public class ScrollItem {
    public String topic;
    public int type;
    public String bgUrl;

    public ScrollItem(String topic, int type, String bgUrl) {
        this.topic = topic;
        this.type = type;
        this.bgUrl = bgUrl;
    }

    public String getTopic() {
        return topic;
    }

    public int getType() {
        return type;
    }

    public String getBgUrl() {
        return bgUrl;
    }
}
