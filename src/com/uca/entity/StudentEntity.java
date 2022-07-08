package com.uca.entity;
import java.util.Date;
import java.util.ArrayList;

public class StudentEntity {

    private int     id;
    private String  firstName;
    private String  lastName;
    private String  classroom;
    private String  birthDate;

    private ArrayList<StudentStickersEntity> stickerList = new ArrayList<>();

    public void setStickerList(ArrayList<StudentStickersEntity> list) {
        this.stickerList = list;
    }
    
    public void setId(int id)
    {
        this.id = id;
    } 

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    } 

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setClassroom(String classroom)
    {
        this.classroom = classroom;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public int getId()
    {
        return id;
    } 

    public String getFirstName()
    {
        return firstName;
    } 

    public String getLastName()
    {
        return lastName;
    } 

    public String getClassroom()
    {
        return classroom;
    } 

    public String getBirthDate()
    {
        return birthDate;
    } 

    public ArrayList<StudentStickersEntity> getStickerList()
    {
        return stickerList;
    } 
}
