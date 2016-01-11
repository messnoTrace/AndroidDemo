package com.notrace.rxjava;

/**
 * Created by notrace on 2015/12/29.
 */
public class Repo {
    public String name;
    public String description;
    public String url;

    public Repo(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String toString() {
        return name + ": " + url;
    }
}
