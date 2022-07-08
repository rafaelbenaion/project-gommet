package com.uca.entity;

public class StickerEntity {

    private int     id;
    private String  color;
    private String  description;

    public void setId(int id)
    {
        this.id = id;
    }  

    public void setColor(String color)
    {
        this.color = color;
    } 

    public void setDescription(String description)
    {
        this.description = description;
    } 

    public int getId()
    {
        return id;
    } 

    public String getColor()
    {
        return color;
    } 

    public String getDescription()
    {
        return description;
    } 
}
