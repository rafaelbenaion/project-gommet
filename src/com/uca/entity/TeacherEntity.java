package com.uca.entity;
import java.util.Date;
import java.util.ArrayList;

public class TeacherEntity{

    private int     id;
    private String  firstName;
    private String  lastName;
    private String  username;
    private String  password;
    
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

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

    public String getUsername()
    {
        return username;
    } 

    public String getPassword()
    {
        return password;
    } 
}
