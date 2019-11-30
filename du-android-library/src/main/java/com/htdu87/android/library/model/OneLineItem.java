package com.htdu87.android.library.model;

public abstract class OneLineItem {
    private String lineOne;
    private Integer icon;

    public OneLineItem() {
    }

    public OneLineItem(String lineOne, Integer icon) {
        this.lineOne = lineOne;
        this.icon = icon;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}
