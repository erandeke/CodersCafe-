package com.kedar.parkinglot.models;

public class EntryGate extends Gate {

    int entryGateNumber;
    DisplayBoard displayBoard;


    public EntryGate(int entryGateNumber, DisplayBoard displayBoard) {
        this.entryGateNumber = entryGateNumber;
        this.displayBoard = displayBoard;
    }

    public int getEntryGateNumber() {
        return entryGateNumber;
    }

    public void setEntryGateNumber(int entryGateNumber) {
        this.entryGateNumber = entryGateNumber;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }
}
