package com.htdu87.android.library.model;

public abstract class OneLineItem {
    private String lineOne;

    public OneLineItem() {
    }

    public OneLineItem(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }
}
