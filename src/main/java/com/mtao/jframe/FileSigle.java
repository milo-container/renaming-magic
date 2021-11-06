package com.mtao.jframe;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FileSigle {
    private String time;
    private String pre;
    private String title;
    private String version;
    private String separator = "_";
    private String[] label;
    private String users;
    private String comments;

    public String __toString()
    {
        return this.getTime()
                + this.getSeparator()
                + this.getPre()
                + this.getSeparator()
                + this.getTitle()
                + this.getSeparator()
                + this.getLabel()
                + this.getSeparator()
                + this.getUsers()
                + this.getSeparator()
                + this.getComments();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVersion(String version) {
        this.title = version;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getLabel() {
        String st = "";
        for(String la : label) {
            st = st + "," + la;
        }
        return st.substring(0,st.length() - 1);
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
