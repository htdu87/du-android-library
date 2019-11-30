package com.htdu87.android.library.model;

public class MenuItem {
    private int code;
    private String name;
    private Integer icon;

    public MenuItem() {
    }

    public MenuItem(int code, String name, Integer icon) {
        this.code = code;
        this.name = name;
        this.icon = icon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}
