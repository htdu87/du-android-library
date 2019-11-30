package com.htdu87.android.library.model;

public abstract class TwoLineItem extends OneLineItem {
    private String lineTwo;

    public TwoLineItem() {
        super();
    }

    public TwoLineItem(String lineOne, Integer icon) {
        super(lineOne, icon);
    }

    public TwoLineItem(String lineOne, Integer icon, String lineTwo) {
        super(lineOne, icon);
        this.lineTwo = lineTwo;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }
}
