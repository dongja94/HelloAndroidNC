package com.begentgroup.helloandroid;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016-06-29.
 */
public class Person {
    private String name;
    private int age;
    private Drawable picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }
}
