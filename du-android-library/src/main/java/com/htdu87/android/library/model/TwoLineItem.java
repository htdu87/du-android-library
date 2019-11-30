package com.htdu87.android.library.model;

public abstract class TwoLineItem extends OneLineItem {
    private String lineTwo;

    public TwoLineItem() {
        super();
    }

    public TwoLineItem(String lineOne,  String lineTwo) {
        super(lineOne);
        this.lineTwo = lineTwo;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }
}
