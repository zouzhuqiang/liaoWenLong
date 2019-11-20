package com.lwl.advertising.domain;

public class Distribution {
    private int id;
    private int terminalId;
    private int advertisingId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(int terminalId) {
        this.terminalId = terminalId;
    }

    public int getAdvertisingId() {
        return advertisingId;
    }

    public void setAdvertisingId(int advertisingId) {
        this.advertisingId = advertisingId;
    }
}
