package com.example.groupsfind;

public class Group {
    private  String group;
    private String fullName;

    public String getGroup() {
        return group;
    }

    public Group(String group, String fullName) {
        this.group = group;
        this.fullName = fullName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
